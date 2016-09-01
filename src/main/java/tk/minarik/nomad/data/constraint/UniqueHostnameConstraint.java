package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class UniqueHostnameConstraint extends AttributeKeyConstraint {

    public UniqueHostnameConstraint(String hostname, Operand operand) {
        super("unique.hostname", hostname, operand);
    }

}
