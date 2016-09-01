package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Specifies the task's update strategy. When omitted, rolling updates are disabled.
 * <p>
 * Created by darko on 1.9.2016..
 */
public class Update {

    /**
     * MaxParallel is given as an integer value and specifies the number of tasks that can be updated at the same time.
     */
    @JsonProperty("MaxParallel")
    private int maxParallel;

    /**
     * Stagger introduces a delay between sets of task updates and is given in nanoseconds.
     */
    @JsonProperty("Stagger")
    private int stagger;

}
