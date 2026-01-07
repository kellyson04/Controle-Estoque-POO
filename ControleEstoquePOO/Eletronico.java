package ControleEstoquePOO;

public class Eletronico extends Produto{
    private int voltage;
    private String power;
    private String current;

    public Eletronico(int voltage,String power,String current, String productName,String productCategory, double productPrice, int productQuantity, String userCpf) {
        super(productName,productCategory,productPrice,productQuantity,userCpf);
        this.voltage = voltage;
        this.power = power;
        this.current = current;
    }

    public int getVoltage() {
        return this.voltage;
    }

    public String getPower() {
        return this.power;
    }

    public String getCurrent() {
        return this.current;
    }

    @Override
    public String toString() {
        return " Voltage: " +getVoltage() + " Power: " +getPower() + " Current: " +getCurrent() + " " + super.toString();
    }
}
