package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class DatacenterConstraint extends Constraint {

    /**
     * Datacenter constraint
     *
     * @param dc      The client node's datacenter
     * @param operand Comparison operation
     */
    public DatacenterConstraint(String dc, Operand operand) {
        this.lTarget = "${node.datacenter}";
        this.rTarget = dc;
        this.operand = operand;
    }

}
