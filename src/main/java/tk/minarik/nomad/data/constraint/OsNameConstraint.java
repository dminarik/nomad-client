package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class OsNameConstraint extends AttributeKeyConstraint {

    public OsNameConstraint(String osName, Operand operand) {
        super("os.name", osName, operand);
    }

    public enum Os {
        //TODO List more OS
        Ubuntu("ubuntu"),
        Windows("windows"),
        Darwin("darwin");

        private final String value;

        Os(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
