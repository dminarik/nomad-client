package tk.minarik.nomad.data.docker;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import tk.minarik.nomad.data.Job;
import tk.minarik.nomad.data.Resources;
import tk.minarik.nomad.data.Task;

import java.util.List;

/**
 * Created by darko on 2.9.2016..
 */
public class DockerTask extends Task{

    public DockerTask(String name, String image, Resources resources){
        super("docker", name, resources);
        this.setImage(image);
    }

    /**
     * The Docker image to run. The image may include a tag or custom URL and should include https:// if required. By default it will be fetched from Docker Hub.
     * @param image
     */
    public void setImage(String image){
        config.put("image", image);
    }

    /**
     * The Docker image to run. The image may include a tag or custom URL and should include https:// if required. By default it will be fetched from Docker Hub.
     * @return
     */
    public String getImage(){
        return (String)config.get("image");
    }

    /**
     * (Optional) A list of paths to image archive files. If this key is not specified, Nomad assumes the image is hosted on a repository and attempts to pull the image. The artifact blocks can be specified to download each of the archive files. The equivalent of docker load -i path would be run on each of the archive files.
     * @param load
     */
    public void setLoad(String load){
        config.put("load", load);
    }

    /**
     * (Optional) A list of paths to image archive files. If this key is not specified, Nomad assumes the image is hosted on a repository and attempts to pull the image. The artifact blocks can be specified to download each of the archive files. The equivalent of docker load -i path would be run on each of the archive files.
     * @return
     */
    public String getLoad(){
        return (String)config.get("load");
    }

    /**
     * (Optional) The command to run when starting the container.
     * @param command
     */
    public void setDockerCommand(String command){
        config.put("command", command);
    }

    /**
     * (Optional) The command to run when starting the container.
     */
    public String getDockerCommand(){
        return (String)config.get("command");
    }

    public void setArgs(List<String> args){
        config.put("args", args);
    }

    /**
     * (Optional) A list of arguments to the optional command. If no command is present, args are ignored.
     * References to environment variables or any interpretable Nomad variables will be interpreted before launching the task.
     * @return
     */
    public List<String> getArgs(){
        return (List<String>)config.get("args");
    }

    /**
     * (Optional) A key/value map of labels to set to the containers on start.
     * @param labels
     */
    public void setLabels(List<String> labels){
        config.put("labels", labels);
    }

    /**
     * (Optional) A key/value map of labels to set to the containers on start.
     */
    public List<String> getLabels(){
        return (List<String>)config.get("labels");
    }

    /**
     *  (Optional) true or false (default). Privileged mode gives the container access to devices on the host. Note that this also requires the nomad agent and docker daemon to be configured to allow privileged containers.
     * @param privileged
     */
    public void setPrivileged(boolean privileged){
        config.put("privileged", String.valueOf(privileged));
    }

    /**
     *  (Optional) true or false (default). Privileged mode gives the container access to devices on the host. Note that this also requires the nomad agent and docker daemon to be configured to allow privileged containers.
     * @return
     */
    public boolean isPrivileged(){
        return config.get("privileged") != null ? (Boolean)config.get("privileged") : false;
    }

    /**
     *  (Optional) The IPC mode to be used for the container. The default is none for a private IPC namespace.
     *  Other values are host for sharing the host IPC namespace or the name or id of an existing container. Note that
     *  it is not possible to refer to Nomad started Docker containers since their names are not known in advance.
     *  Note that setting this option also requires the Nomad agent to be configured to allow privileged containers.
     * @param ipcMode
     */
    public void setIpcMode(String ipcMode){
        config.put("ipc_mode", ipcMode);
    }

    public String getIpcMode(){
        return (String)config.get("ipc_mode");
    }
    //TODO IPC mode
    //TODO PID mode
    //TODO UTS mode
    //TODO Network mode
    //TODO Hostname
    //TODO DNS servers
    //TODO DNS search domains
    //TODO SSL
    //TODO Port map
    //TODO Auth
    //TODO Tty
    //TODO Interactive
    //TODO Shm size
    //TODO Work dir
    //TODO Authentication (for repo)

    //TODO Docker endpoint
    //TODO Docker auth config
    //TODO Docker TLS Certificate
    //TODO Docker TLS Key
    //TODO Docker TLS CA
    //TODO Docker cleanup image
    //TODO Docker SELinux label
    //TODO Docker privileged enabled


}
