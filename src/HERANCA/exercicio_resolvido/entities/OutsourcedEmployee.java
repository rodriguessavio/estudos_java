package HERANCA.exercicio_resolvido.entities;

public class OutsourcedEmployee extends Employee {
    private double additionalCharge;

    public OutsourcedEmployee(){

    }

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() {
        return super.payment() + (additionalCharge * 1.10);
    }
}
