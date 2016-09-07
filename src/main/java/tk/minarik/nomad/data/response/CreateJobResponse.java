package tk.minarik.nomad.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Created by darko on 7.9.2016..
 */
@Data
public class CreateJobResponse {

    @JsonProperty("EvalID")
    private UUID evalId;
    @JsonProperty("EvalCreateIndex")
    private int evalCreateIndex;
    @JsonProperty("JobModifyIndex")
    private int jobModifyIndex;

}
