package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class CpuNumCoreConstraint extends AttributeKeyConstraint {

    public CpuNumCoreConstraint(int numCores, Operand operand) {
        super("cpu.numcores", String.valueOf(numCores), operand);
    }

}
