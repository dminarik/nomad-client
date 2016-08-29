import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Plugin
import org.gradle.api.Project

class NomadPlugin implements Plugin<Project> {

    private static
    final WINDOWS_DOWNLOAD_URL = "https://releases.hashicorp.com/nomad/0.4.1/nomad_0.4.1_windows_amd64.zip"
    private static final LINUX_DOWNLOAD_URL = "https://releases.hashicorp.com/nomad/0.4.1/nomad_0.4.1_linux_amd64.zip"
    private static final DOWNLOAD_TARGET = "build/nomad/install/nomad.zip"
    private static final INSTALL_TARGET = "build/nomad"

    Process process = null;

    @Override
    void apply(Project project) {
        //Add nomad extension object
        project.extensions.create("nomad", NomadPluginExtension)

        //Download Nomad
        project.task("downloadNomad") {
            inputs.file new File("build/nomad/install/nomad.zip")

            doLast {
                ant.mkdir(dir: "build/nomad")
                ant.mkdir(dir: "build/nomad/install")
                if(Os.isFamily(Os.FAMILY_WINDOWS)) {
                    ant.get(src: WINDOWS_DOWNLOAD_URL, dest: DOWNLOAD_TARGET)
                }
                if(Os.isFamily(Os.FAMILY_UNIX)){
                    ant.get(src: LINUX_DOWNLOAD_URL, dest: DOWNLOAD_TARGET)
                }
            }
        }

        //Unpack Nomad
        project.task("unpackNomad", dependsOn: "downloadNomad") {
            doLast {
                ant.unzip(src: DOWNLOAD_TARGET, dest: INSTALL_TARGET)
            }
        }

        project.task("runNomad", dependsOn: "unpackNomad") << {
            ProcessBuilder builder = null;
            if(Os.isFamily(Os.FAMILY_WINDOWS)) {
                new ProcessBuilder("build\\nomad\\nomad", "agent", "--dev")
            }
            if(Os.isFamily(Os.FAMILY_UNIX)){
                new ProcessBuilder("build/nomad/nomad", "agent", "--dev")
            }
            process = builder.start();
            Thread.sleep(10000)
        }

        project.task("stopNomad", dependsOn: "unpackNomad") << {
            if (process != null) {
                process.destroy()
            }
        }
    }
}

class NomadPluginExtension {

}