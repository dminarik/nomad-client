package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class AmazonAmiIdConstraint extends AttributeKeyConstraint {

    public AmazonAmiIdConstraint(String amiId, Operand operand) {
        super("platform.aws.ami-id", amiId, operand);
    }

}
