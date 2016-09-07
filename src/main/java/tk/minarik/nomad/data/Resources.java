package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TODO Add meaningfull description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resources {

    /**
     * The CPU required in MHz.
     */
    @JsonProperty("CPU")
    private int cpu = 20;

    /**
     * The disk required in MB.
     */
    @JsonProperty("DiskMB")
    private int diskMB = 10;

    /**
     * The number of IOPS required given as a weight between 10-1000.
     */
    @JsonProperty("IOPS")
    private int iops;

    /**
     * The memory required in MB.
     */
    @JsonProperty("MemoryMB")
    private int memoryMB = 10;

    /**
     * A list of network objects.
     */
    @JsonProperty("Networks")
    private List<Network> networks;

}
