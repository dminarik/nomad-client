package tk.minarik.nomad.data.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import tk.minarik.nomad.data.Job;
import tk.minarik.nomad.data.response.CreateJobResponse;

/**
 * Created by darko on 7.9.2016..
 */
@Data
@AllArgsConstructor
public class CreateJobRequest {

    @JsonProperty("Job")
    private final Job job;

}
