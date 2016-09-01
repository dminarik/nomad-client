package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class AttributeKeyConstraint extends Constraint {

    /**
     * Attribute key constraint
     *
     * @param attributeKey Attribute key
     * @param value        Attribute value
     * @param operand      Comparison operation
     */
    public AttributeKeyConstraint(String attributeKey, String value, Operand operand) {
        this.lTarget = String.format("${attr.\"%s\"}", attributeKey);
        this.rTarget = value;
        this.operand = operand;
    }

}
