package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
public class Network {

    /**
     * The number of MBits in bandwidth required.
     */
    @JsonProperty("MBits")
    private int mBits;

    /**
     * Nomad can allocate two types of ports to a task - Dynamic and Static/Reserved ports. A network object allows the user to specify a list of DynamicPorts and ReservedPorts.
     */
    @JsonProperty("DynamicPorts")
    private List<DynamicPort> dynamicPorts;

    /**
     * Nomad can allocate two types of ports to a task - Dynamic and Static/Reserved ports. A network object allows the user to specify a list of DynamicPorts and ReservedPorts.
     */
    @JsonProperty("ReservedPorts")
    private List<ReservedPort> reservedPorts;

}
