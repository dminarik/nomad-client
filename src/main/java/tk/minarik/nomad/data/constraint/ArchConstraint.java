package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class ArchConstraint extends AttributeKeyConstraint {

    public ArchConstraint(Arch arch, Operand operand) {
        this(arch.getValue(), operand);
    }

    public ArchConstraint(String arch, Operand operand) {
        super("arch", arch, operand);
    }

    public enum Arch {
        //TODO List more architectures
        Amd64("amd64"), _386("386");

        private final String value;

        Arch(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
