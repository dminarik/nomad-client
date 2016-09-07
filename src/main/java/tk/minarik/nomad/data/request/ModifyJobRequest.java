package tk.minarik.nomad.data.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import tk.minarik.nomad.data.Job;

/**
 * Created by darko on 8.9.2016..
 */
@Data
@AllArgsConstructor
public class ModifyJobRequest {

    @JsonProperty("Job")
    private Job job;

}
