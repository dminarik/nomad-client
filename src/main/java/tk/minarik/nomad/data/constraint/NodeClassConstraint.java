package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class NodeClassConstraint extends Constraint {

    /**
     * Node class constraint
     *
     * @param nodeClass The client node's class
     * @param operand   Comparison oeration
     */
    public NodeClassConstraint(String nodeClass, Operand operand) {
        this.lTarget = "${node.class}";
        this.rTarget = nodeClass;
        this.operand = operand;
    }

}
