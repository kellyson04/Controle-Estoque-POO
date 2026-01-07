package ControleEstoquePOO;
public abstract class Produto {
    private String productName;
    private String productCategory;
    private double productPrice;
    private int productQuantity;
    private String userCpf;

    public Produto(String productName,String productCategory, double productPrice, int productQuantity, String userCpf) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.userCpf = userCpf;
    }

    public void addProduct(int quantity) {
        this.productQuantity = this.productQuantity + quantity;
    }

    public void removeProduct(int quantity) {
        this.productQuantity = this.productQuantity - quantity;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String newProductName) {
        this.productName = newProductName;
    }

    public String getProductCategory() {
        return this.productCategory;
    }

    public void setProductCategoryName(String newCategoryName) {
        this.productCategory = newCategoryName;
    }

    public double getProductPrice () {
        return this.productPrice;
    }

    public String getUserCpf() {
        return this.userCpf;
    }

    public void setProductPrice(double newProductPrice) {
        this.productPrice = newProductPrice;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int newProductQuantity) {
        this.productQuantity = newProductQuantity;
    }


    public double totalValue() {
        double totalStock = this.productPrice * this.productQuantity;
        return totalStock;
    }

    public String toString() {
        return " Product " +getProductName()+ " Category " +getProductCategory() + " Price: $" +productPrice+ " Qty: " +productQuantity+  " Total Value: $" +totalValue();
    }
}
