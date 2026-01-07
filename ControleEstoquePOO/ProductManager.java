package ControleEstoquePOO;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    userManager user = new userManager();
    ArrayList<CreateUser> usersList;
    ArrayList<Produto> productsList = new ArrayList<>();
    ProductRepository productRepository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);

    public ProductManager (ArrayList<CreateUser> usersList) {
        this.usersList = usersList;
    }

    public void addProducts(Produto product) {
        productsList.add(product);
        productRepository.saveProducts(productsList);
    }

}
