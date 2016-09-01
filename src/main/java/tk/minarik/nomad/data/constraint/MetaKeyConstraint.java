package tk.minarik.nomad.data.constraint;

import tk.minarik.nomad.data.Constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class MetaKeyConstraint extends Constraint {

    /**
     * Meta key constraint
     *
     * @param metaKey Meta key
     * @param value   Meta value
     * @param operand Comparison operator
     */
    public MetaKeyConstraint(String metaKey, String value, Operand operand) {
        this.lTarget = String.format("${meta.\"%s\"}", metaKey);
        this.rTarget = value;
        this.operand = operand;
    }

}
