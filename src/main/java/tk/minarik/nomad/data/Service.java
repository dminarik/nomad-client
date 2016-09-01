package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Service {

    /**
     * Nomad automatically determines the name of a Task. By default the name of a service is $(job-name)-$(task-group)-$(task-name).
     * Users can explicitly name the service by specifying this option. If multiple services are defined for a Task then only one task
     * 7can have the default name, all the services have to be explicitly named.
     * Users can add the following to the service names: ${JOB}, ${TASKGROUP}, ${TASK}, ${BASE}.
     * Nomad will replace them with the appropriate value of the Job, Task Group, and Task names while registering the Job. ${BASE} expands to ${JOB}-${TASKGROUP}-${TASK}.
     * Names must be adhere to RFC-1123 §2.1 and are limited to alphanumeric and hyphen characters (i.e. [a-z0-9\-]), and be less than 64 characters in length.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * A list of string tags associated with this Service. String interpolation is supported in tags.
     */
    @JsonProperty("Tags")
    private List<String> tags;

    /**
     * PortLabel is an optional string and is used to associate the port with the service. If specified, the port label must match one defined in the resources block.
     * This could be a label to either a dynamic or a static port. If an incorrect port label is specified, Nomad doesn't register the IP:Port with Consul.
     */
    @JsonProperty("PortLabel")
    private String portLabel;

    /**
     * Checks is an array of check objects. A check object defines a health check associated with the service. Nomad supports the script, http and tcp Consul Checks.
     * Script checks are not supported for the qemu driver since the Nomad client doesn't have access to the file system of a tasks using the Qemu driver.
     */
    @JsonProperty("Chacks")
    private List<Check> checks;


}
