package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * TODO Add meaningfull description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Resources {

    /**
     * The CPU required in MHz.
     */
    @JsonProperty("CPU")
    private int cpu;

    /**
     * The disk required in MB.
     */
    @JsonProperty("DiskMB")
    private int diskMB;

    /**
     * The number of IOPS required given as a weight between 10-1000.
     */
    @JsonProperty("IOPS")
    private int iops;

    /**
     * The memory required in MB.
     */
    @JsonProperty("MemoryMB")
    private int memoryMB;

    /**
     * A list of network objects.
     */
    @JsonProperty("Networks")
    private List<Network> networks;

}
