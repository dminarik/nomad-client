package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class AmazonInstanceTypeConstraint extends AttributeKeyConstraint {

    public AmazonInstanceTypeConstraint(String instanceType, Operand operand) {
        super("platform.aws.instance-type", instanceType, operand);
    }

}
