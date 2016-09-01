package tk.minarik.nomad.data.constraint;

/**
 * Created by darko on 2.9.2016..
 */
public class DriverKeyConstraint extends AttributeKeyConstraint {

    public DriverKeyConstraint(String driverKey, String value, Operand operand) {
        super(
                String.format("driver.\"%s\"", driverKey),
                value,
                operand
        );
    }

}
