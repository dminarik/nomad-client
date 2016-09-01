package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class KernelNameConstraint extends AttributeKeyConstraint {

    public KernelNameConstraint(Kernel kernel, Operand operand) {
        this(kernel.getValue(), operand);
    }

    public KernelNameConstraint(String kernalName, Operand operand) {
        super("kernel.name", kernalName, operand);
    }

    public enum Kernel {
        Linux("linus"),
        Darwin("darwin");

        private final String value;

        Kernel(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
