package ControleEstoquePOO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProductRepository {

    public void saveProducts (ArrayList<Produto> productsList) {
        //TODO: ainda preciso aprender como vou salvar os produtos de classes diferentes, o saveProducts no momento atual so salva as informações padrão da classe pai
        try (PrintWriter writer = new PrintWriter(new FileWriter("products.csv"))) {

            for (Produto product : productsList) {
                writer.println( " -> " + product.getUserCpf()+ ", " +product.getProductName() + ", " + product.getProductCategory() + ", " + product.getProductPrice() + ", " + product.getProductQuantity());
            }

        }catch (IOException error) {
            System.out.println("❌TECHNICAL ERROR AT THE DISC");
        }
    }
}
