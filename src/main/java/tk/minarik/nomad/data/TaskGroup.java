package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TaskGroups is a list of TaskGroup objects
 * <p>
 * TODO Fix this comment!!!
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
@RequiredArgsConstructor
public class TaskGroup {

    private static final RestartPolicy DEFAULT_RESTART_POLICY = new RestartPolicy();

    /**
     * This is a list of Constraint objects. See the constraint reference for more details.
     */
    @JsonProperty("Constraints")
    private List<Constraint> constraints;

    /**
     * Specifies the number of the task groups that should be running. Must be non-negative, defaults to one.
     */
    @JsonProperty("Count")
    private int count = 1;

    /**
     * A key/value map that annotates the task group with opaque metadata.
     */
    @JsonProperty("Meta")
    private Map<String, String> meta;

    /**
     * The name of the task group. Must be specified.
     */
    @JsonProperty("Name")
    private final String name;

    /**
     * Specifies the restart policy to be applied to tasks in this group. If omitted, a default policy for
     * batch and non-batch jobs is used based on the job type. See the restart policy reference for more details.
     */
    @JsonProperty("RestartPolicy")
    private RestartPolicy restartPolicy = DEFAULT_RESTART_POLICY;

    /**
     * A list of Task object that are part of the task group.
     */
    @JsonProperty("Tasks")
    private List<Task> tasks = new ArrayList<>();
}
