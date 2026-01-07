package ControleEstoquePOO;

public class Food extends Produto {
    private String brand;
    private String expirationDate;
    private double weight;

    public Food(String brand,String expirationDate,double weight,String productName,String productCategory, double productPrice,int productQuantity,String UserCpf) {
        super(productName,productCategory,productPrice,productQuantity,productCategory);
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return " Brand: " + getBrand() + " Expiration Date: " + getExpirationDate() + " Weight " + getWeight() + " " + super.toString();
    }
}
