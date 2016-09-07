package tk.minarik.nomad.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestartPolicy {

    /**
     * Attempts is the number of restarts allowed in an Interval.
     */
    @JsonProperty("Attempts")
    private int attempts;
    /**
     * Interval is a time duration that is specified in nanoseconds. The Interval begins when the first task
     * starts and ensures that only Attempts number of restarts happens within it. If more than Attempts number
     * of failures happen, behavior is controlled by Mode.
     */
    @JsonProperty("Interval")
    private int interval;
    /**
     * A duration to wait before restarting a task. It is specified in nanoseconds. A random jitter of up to 25% is added to the delay.
     */
    @JsonProperty("Delay")
    private int delay;
    /**
     * Mode - Mode is given as a string and controls the behavior when the task fails more than Attempts times in an Interval. Possible values are listed below:
     * delay - delay will delay the next restart until the next Interval is reached.
     * fail - fail will not restart the task again.
     */
    @JsonProperty("Mode")
    @JsonSerialize(using = ModeSerializer.class)
    @JsonDeserialize(using = ModeDeserializer.class)
    private Mode mode = Mode.Fail;

    /**
     * Mode is given as a string and controls the behavior when the task fails more than Attempts times in an Interval. Possible values are listed below:
     * delay - delay will delay the next restart until the next Interval is reached.
     * fail - fail will not restart the task again.
     */
    public enum Mode {
        Delay, Fail
    }

    /**
     * Serializes mode to decapitalized form
     */
    private static class ModeSerializer extends StdSerializer<Mode> {
        public ModeSerializer() {
            super(Mode.class);
        }

        @Override
        public void serialize(Mode value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.name().toLowerCase());
        }
    }

    /**
     * Deserializes mode from decapitalized form
     */
    private static class ModeDeserializer extends StdDeserializer<Mode> {

        public ModeDeserializer(){
            super(Mode.class);
        }

        @Override
        public Mode deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Mode.valueOf(StringUtils.capitalize(p.getText()));
        }
    }

}
