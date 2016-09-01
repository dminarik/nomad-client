package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Periodic allows the job to be scheduled at fixed times, dates or intervals. The periodic expression is always evaluated in the
 * UTC timezone to ensure consistent evaluation when Nomad Servers span multiple time zones. The Periodic object is optional.
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Periodic {

    /**
     * Enabled determines whether the periodic job will spawn child jobs.
     */
    @JsonProperty("Enabled")
    private boolean enabled;
    /**
     * SpecType determines how Nomad is going to interpret the periodic expression. cron is the only supported SpecType currently.
     */
    @JsonProperty("SpecType")
    private SpecType specType = SpecType.cron;
    /**
     * A cron expression configuring the interval the job is launched at.
     * Supports predefined expressions such as "@daily" and "@weekly"
     * See <a>https://github.com/gorhill/cronexpr#implementation</a> for full
     * documentation of supported cron specs and the predefined expressions.
     */
    @JsonProperty("Spec")
    private String spec;
    /**
     * ProhibitOverlap - ProhibitOverlap can be set to true to enforce that the periodic job
     * doesn't spawn a new instance of the job if any of the previous jobs are still running. It is defaulted to false.
     */
    @JsonProperty("ProhibitOverlap")
    private boolean prohibitOverlap = false;

    public enum SpecType {
        cron
    }

}
