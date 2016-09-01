package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TODO add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Task {

    /**
     * Artifacts is a list of Artifact objects which define artifacts to be downloaded before the task is run. See the artifacts reference for more details.
     */
    @JsonProperty("Artifacts")
    private List<Artifact> artifacts;

    /**
     * A map of key/value configuration passed into the driver to start the task. The details of configurations are specific to each driver.
     */
    @JsonProperty("Config")
    private Map<String, String> config;

    /**
     * This is a list of Constraint objects. See the constraint reference for more details.
     */
    @JsonProperty("Constraints")
    private List<Constraint> constraints;

    /**
     * Specifies the task driver that should be used to run the task.
     * See the <a href="https://www.nomadproject.io/docs/drivers/">driver documentation</a> for what is available.
     * Examples include docker, qemu, java, and exec.
     */
    @JsonProperty("Driver")
    private String driver;

    /**
     * A map of key/value representing environment variables that will be passed along to the running process.
     * Nomad variables are interpreted when set in the environment variable values.
     * See the table of interpreted variables <a href="https://www.nomadproject.io/docs/jobspec/interpreted.html">here</a>.
     */
    @JsonProperty("Env")
    private Map<String, String> env;

    /**
     * KillTimeout is a time duration in nanoseconds. It can be used to configure the time between signaling a task it will be killed and actually killing it.
     * Drivers first sends a task the SIGINT signal and then sends SIGTERM if the task doesn't die after the KillTimeout duration has elapsed.
     */
    @JsonProperty("KillTimeout")
    private int killTimeout;

    /**
     * This allows configuring log rotation for the stdout and stderr buffers of a Task. See the log rotation reference below for more details.
     */
    @JsonProperty("LogConfig")
    private LogConfig logConfig;

    /**
     * Annotates the task group with opaque metadata.
     */
    @JsonProperty("Meta")
    private Map<String, String> meta;

    /**
     * The name of the task. This field is required.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * Provides the resource requirements of the task. See the resources reference for more details.
     */
    @JsonProperty("Resources")
    private Resources resources;

    /**
     * Services is a list of Service objects. Nomad integrates with Consul for service discovery. A Service object represents a routable and discoverable service on the network. Nomad automatically registers
     * when a task is started and de-registers it when the task transitions to the dead state.
     * Click <a href="https://www.nomadproject.io/docs/jobspec/servicediscovery.html">here</a> to learn more about services.
     */
    @JsonProperty("Services")
    private List<Service> services;

    /**
     * Set the user that will run the task. It defaults to the same user the Nomad client is being run as. This can only be set on Linux platforms.
     */
    @JsonProperty("User")
    private String user;

}
