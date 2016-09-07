package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Created by darko on 28.8.2016..
 */
@Data
public class Allocation {

    @Data
    public static class TaskState{
        //TODO Implement task states data structure
    }

    @JsonProperty("ID")
    private UUID id;

    @JsonProperty("EvalID")
    private UUID evalId;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("NodeID")
    private String nodeId;

    @JsonProperty("JobID")
    private String jobId;

    @JsonProperty("TaskGroup")
    private String taskGroup;

    @JsonProperty("DesiredStatus")
    private String desiredStatus;

    @JsonProperty("DesiredDescription")
    private String desiredDescription;

    @JsonProperty("ClientDescription")
    private String clientDescription;

    @JsonProperty("ClientStatus")
    private String clientStatus;

    @JsonProperty("TaskStates")
    private List<TaskState> taskStates;



}
