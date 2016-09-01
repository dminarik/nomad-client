package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
public class ReservedPort {

    /**
     * The label to annotate a port so that it can be referred in the service discovery block or environment variables.
     */
    @JsonProperty("Label")
    private String label;

    /**
     * The port number for static ports. If the port is dynamic, then this attribute is ignored.
     */
    @JsonProperty("Value")
    private int value;

}
