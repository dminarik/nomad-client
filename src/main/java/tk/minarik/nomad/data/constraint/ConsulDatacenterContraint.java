package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class ConsulDatacenterContraint extends AttributeKeyConstraint {

    public ConsulDatacenterContraint(String consulDc, Operand operand) {
        super("consul.datacenter", consulDc, operand);
    }

}
