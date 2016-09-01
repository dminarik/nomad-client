package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class DynamicPort {

    /**
     * The label to annotate a port so that it can be referred in the service discovery block or environment variables.
     */
    @JsonProperty("Label")
    private String label;

}
