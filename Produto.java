public class Produto {
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Produto(String productName,double productPrice, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public void addProduct(int quantity) {
        this.productQuantity = this.productQuantity + quantity;
    }

    public void removeProduct(int quantity) {
        this.productQuantity = this.productQuantity - quantity;
    }

    public double totalValue() {
        double totalStock = this.productPrice * this.productQuantity;
        return totalStock;
    }

    public String toString() {
        return "O produto " +productName+ " no valor de R$" +productPrice+ " contendo " +productQuantity+ " unidades" + " foi adicionado com sucesso no valor total de R$" +totalValue();
    }
}
