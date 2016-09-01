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
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by darko on 28.8.2016..
 */
@Data
public class Job {

    /**
     * Controls if the entire set of tasks in the job must be placed atomically or if they can be
     * scheduled incrementally. This should only be used for special circumstances. Defaults to false.
     */
    @JsonProperty("AllAtOnce")
    private boolean allAtOnce;
    /**
     * A list to define additional constraints where a job can be run. See the constraint reference for more details.
     */
    @JsonProperty("Constraints")
    private List<Constraint> constraints;
    /**
     * A list of datacenters in the region which are eligible for task placement. This must be provided, and does not have a default.
     */
    @JsonProperty("Datacenters")
    private List<String> datacenters;
    /**
     * A list to define additional task groups. See the task group reference for more details.
     */
    @JsonProperty("TaskGroups")
    private List<TaskGroup> taskGroups;
    /**
     * Annotates the job with opaque metadata.
     */
    private Map<String, String> meta;
    /**
     * Specifies the job priority which is used to prioritize scheduling and access to resources. Must be between 1 and 100 inclusively, and defaults to 50.
     */
    @JsonProperty("Priority")
    private int priority = 50;
    /**
     * The region to run the job in, defaults to "global".
     */
    @JsonProperty("Region")
    private String region = "global";
    /**
     * Specifies the job type and switches which scheduler is used. Nomad provides the service, system and batch schedulers, and defaults to service.
     * To learn more about each scheduler type visit <a>https://www.nomadproject.io/docs/jobspec/schedulers.html</a>
     */
    @JsonProperty("Type")
    @JsonSerialize(using = TypeSerializer.class)
    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;
    /**
     * Specifies the task's update strategy. When omitted, rolling updates are disabled.
     */
    @JsonProperty("Update")
    private Update update;
    /**
     * Periodic allows the job to be scheduled at fixed times, dates or intervals. The periodic expression is always evaluated in the UTC
     * timezone to ensure consistent evaluation when Nomad Servers span multiple time zones. The Periodic object is optional.
     */
    @JsonProperty("Periodic")
    private Periodic periodic;

    /**
     * Type of job. This value affects scheduler behaviour.
     * Can be Service, System or Batch
     */
    public enum Type {
        Service, System, Batch
    }

    /**
     * Serializes Type enum in decapitalized form
     */
    private static class TypeSerializer extends StdSerializer<Type> {

        public TypeSerializer(Class<Type> t) {
            super(t);
        }

        public TypeSerializer(JavaType type) {
            super(type);
        }

        public TypeSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        public TypeSerializer(StdSerializer<?> src) {
            super(src);
        }

        @Override
        public void serialize(Type value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.name().toLowerCase());
        }
    }

    /**
     * Deserializes Type enum from decapitalized form
     */
    private static class TypeDeserializer extends StdDeserializer<Type> {
        public TypeDeserializer(Class<?> vc) {
            super(vc);
        }

        public TypeDeserializer(JavaType valueType) {
            super(valueType);
        }

        public TypeDeserializer(StdDeserializer<?> src) {
            super(src);
        }

        @Override
        public Type deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Type.valueOf(StringUtils.capitalize(p.getText()));
        }
    }

}
