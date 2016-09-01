package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * Nomad downloads artifacts using go-getter. The go-getter library allows downloading of artifacts from various sources using a URL as the input source. The key/value pairs given in the options block map directly to parameters appended to the supplied source URL. These are then used by go-getter to appropriately download the artifact. go-getter also has a CLI tool to validate its URL and can be used to check if the Nomad artifact is valid.
 * <p>
 * Nomad allows downloading http, https, and S3 artifacts. If these artifacts are archives (zip, tar.gz, bz2, etc.), these will be unarchived before the task is started.
 * <p>
 * The Artifact object supports the following keys:
 * <p>
 * GetterSource - The path to the artifact to download.
 * <p>
 * RelativeDest - An optional path to download the artifact into relative to the root of the task's directory. If omitted, it will default to local/.
 * <p>
 * GetterOptions - A map[string]string block of options for go-getter. Full documentation of supported options are available here.
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Artifact {

    /**
     * The path to the artifact to download.
     */
    @JsonProperty("GetterSource")
    private String getterSource;

    /**
     * An optional path to download the artifact into relative to the root of the task's directory. If omitted, it will default to local/.
     */
    @JsonProperty("RelativeDest")
    private String relativeDest = "local/";

    /**
     * A map[string]string block of options for go-getter.
     * Full documentation of supported options are available
     * <a href="https://github.com/hashicorp/go-getter/tree/ef5edd3d8f6f482b775199be2f3734fd20e04d4a#protocol-specific-options-1">here</a>.
     */
    private Map<String, String> getterOpts;

}
