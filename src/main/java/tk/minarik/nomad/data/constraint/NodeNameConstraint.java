package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class NodeNameConstraint extends Constraint {

    /**
     * Node name constraint
     *
     * @param nodeName The client node's name
     * @param operand  Comparison operation
     */
    public NodeNameConstraint(String nodeName, Operand operand) {
        this.lTarget = "${node.unique.name}";
        this.rTarget = nodeName;
        this.operand = operand;
    }

}
