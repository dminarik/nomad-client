package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class LogConfig {

    /**
     * The maximum number of rotated files Nomad will retain for stdout and stderr, each tracked individually.
     */
    @JsonProperty("MaxFiles")
    private int maxFiles;

    /**
     * The size of each rotated file. The size is specified in MB.
     */
    @JsonProperty("MaxFileSizeMB")
    private int maxFileSizeMB;

}
