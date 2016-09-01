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

import java.io.IOException;

/**
 * TODO Add meaningful description
 * <p>
 * Created by darko on 1.9.2016..
 */
public class Constraint {

    /**
     * Specifies the attribute to examine for the constraint.
     * See the table of attributes <a href="https://www.nomadproject.io/docs/jobspec/interpreted.html#interpreted_node_vars">here</a>.
     */
    @JsonProperty("LTarget")
    private String lTarget;
    /**
     * Specifies the value to compare the attribute against. This can be a literal value, another attribute or a regular expression if the Operator is in "regexp" mode.
     */
    @JsonProperty("rTarget")
    private String rTarget;
    /**
     * Operand - Specifies the test to be performed on the two targets. It takes on the following values:
     * <p>
     * regexp - Allows the RTarget to be a regular expression to be matched.
     * distinct_host - If set, the scheduler will not co-locate any task groups on the same machine. This can be specified as a job constraint which applies the constraint to all task groups in the job, or as a task group constraint which scopes the effect to just that group.
     * <p>
     * Placing the constraint at both the job level and at the task group level is redundant since when placed at the job level, the constraint will be applied to all task groups. When specified, LTarget and RTarget should be omitted.
     * <p>
     * Comparison Operators - =, ==, is, !=, not, >, >=, <, <=. The ordering is compared lexically.
     */
    @JsonProperty("Operand")
    @JsonSerialize(using = OperandSerializer.class)
    @JsonDeserialize(using = OperandDeserializer.class)
    private Operand operand;

    public enum Operand {
        Regexp("regexp"),
        DistinctHost("distinct_host"),
        Equal("=="),
        EqualShort("="),
        Is("is"),
        NotEqual("!="),
        Greater(">"),
        EqualOrGreater(">="),
        Less("<"),
        EqualOrLess("<="),
        Not("not");

        private final String value;

        Operand(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Serialize operand to its specified symbol
     */
    private static class OperandSerializer extends StdSerializer<Operand> {
        public OperandSerializer(Class<Operand> t) {
            super(t);
        }

        public OperandSerializer(JavaType type) {
            super(type);
        }

        public OperandSerializer(Class<?> t, boolean dummy) {
            super(t, dummy);
        }

        public OperandSerializer(StdSerializer<?> src) {
            super(src);
        }

        @Override
        public void serialize(Operand value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(value.getValue());
        }
    }

    /**
     * Deserialize operand from a symbol
     */
    private static class OperandDeserializer extends StdDeserializer<Operand> {
        public OperandDeserializer(Class<?> vc) {
            super(vc);
        }

        public OperandDeserializer(JavaType valueType) {
            super(valueType);
        }

        public OperandDeserializer(StdDeserializer<?> src) {
            super(src);
        }

        @Override
        public Operand deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            for (Operand operand : Operand.values()) {
                if (operand.value.equals(p.getText())) {
                    return operand;
                }
            }
            return null;
        }
    }

}
