package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class NodeIdConstraint extends Constraint {

    /**
     * Node ID constraint
     *
     * @param nodeId  The 36 character unique client node identifier (Example: 9afa5da1-8f39-25a2-48dc-ba31fd7c0023)
     * @param operand Comparison operation
     */
    public NodeIdConstraint(String nodeId, Operand operand) {
        this.lTarget = "${node.unique.id}";
        this.lTarget = nodeId;
        this.operand = operand;
    }

}
