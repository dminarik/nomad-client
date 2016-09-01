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

/**
 * TODO Add meaningful comment
 * <p>
 * Created by darko on 1.9.2016..
 */
@Data
public class Check {

    /**
     * This indicates the check types supported by Nomad. Valid options are currently script, http and tcp.
     */
    @JsonProperty("Type")
    @JsonSerialize(using = TypeSerializer.class)
    @JsonDeserialize(using = TypeDeserializer.class)
    private Type type;
    /**
     * The name of the health check.
     */
    @JsonProperty("Name")
    private String name;
    /**
     * This indicates the frequency of the health checks that Consul will perform.
     */
    @JsonProperty("Interval")
    private int interval;
    /**
     * This indicates how long Consul will wait for a health check query to succeed.
     */
    @JsonProperty("Timeout")
    private int timeout;
    /**
     * The path of the http endpoint which Consul will query to query the health of a service if the type of the check is http.
     * Nomad will add the IP of the service and the port, users are only required to add the relative URL of the health check endpoint.
     */
    @JsonProperty("Path")
    private String path;
    /**
     * This indicates the protocol for the http checks. Valid options are http and https. We default it to http
     */
    @JsonProperty("Protocol")
    @JsonSerialize(using = ProtocolSerializer.class)
    @JsonDeserialize(using = ProtocolDeserializer.class)
    private Protocol protocol = Protocol.Http;
    /**
     * This is the command that the Nomad client runs for doing script based health check.
     */
    @JsonProperty("Command")
    private String command;
    /**
     * Additional arguments to the command for script based health checks.
     */
    @JsonProperty("Args")
    private List<String> args;

    public enum Type {
        Script, Http, Tcp
    }

    public enum Protocol {
        Http, Https
    }

    /**
     * Serializes check type in decapitalized form
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
     * Deserializes check type from deserialized form
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

    /**
     * Serializes protocol type in decapizalized form
     */
    private static class ProtocolSerializer extends StdSerializer<Protocol> {
        public ProtocolSerializer(Class<Protocol> t) {
            super(t);
        }

        public ProtocolSerializer(JavaType type) {
            super(type);
        }

        public ProtocolSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        public ProtocolSerializer(StdSerializer<?> src) {
            super(src);
        }

        @Override
        public void serialize(Protocol value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.name().toLowerCase());
        }
    }

    /**
     * Deserializes protocol type from decapitalized form
     */
    private static class ProtocolDeserializer extends StdDeserializer<Protocol> {
        public ProtocolDeserializer(Class<?> vc) {
            super(vc);
        }

        public ProtocolDeserializer(JavaType valueType) {
            super(valueType);
        }

        public ProtocolDeserializer(StdDeserializer<?> src) {
            super(src);
        }

        @Override
        public Protocol deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Protocol.valueOf(StringUtils.capitalize(p.getText()));
        }
    }
}
