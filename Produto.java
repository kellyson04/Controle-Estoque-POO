public class Produto {
    private String productName;
    private String productCategory;
    private double productPrice;
    private int productQuantity;

    public Produto(String productName,String productCategory, double productPrice, int productQuantity) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
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

    public String getProductCategory() {
        return this.productCategory;
    }

    public double totalValue() {
        double totalStock = this.productPrice * this.productQuantity;
        return totalStock;
    }

    public String toString() {
        return " O produto " +productName+ " da categoria " +getProductCategory() + " no valor de R$" +productPrice+ " contendo " +productQuantity+ " unidades" + " Com total de R$" +totalValue() + " Esta no seu Carrinho!";
    }
}
