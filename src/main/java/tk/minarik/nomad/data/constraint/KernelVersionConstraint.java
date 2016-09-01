package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class KernelVersionConstraint extends AttributeKeyConstraint {

    public KernelVersionConstraint(String kernelVersion, Operand operand) {
        super("kernel.version", kernelVersion, operand);
    }

}
