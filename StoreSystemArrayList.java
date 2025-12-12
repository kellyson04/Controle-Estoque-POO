import java.util.ArrayList;
import java.util.Scanner;

public class StoreSystemArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listadeProdutos = new ArrayList<>();

        int choice = 0; //iniciando a var pra conseguir iniciar o loop do while

        do {

            System.out.println("---- Welcome to our STORE CRUD SYSTEM! ----");

            System.out.print(" 1 - Add Product\n 2 - Remove Product\n 3 - List all Products\n 4 - Quit Program \n:");
            choice = scanner.nextInt();

            //limpando o bufferzin
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Product name:");
                String productName = scanner.nextLine();
                System.out.print("Product price:");
                double productPrice = scanner.nextDouble();
                System.out.print("Product quantity:");
                int productQuantity = scanner.nextInt();

                //fazendo uso da classe produto e armazenando tudo no arraylist , conceito mt bom ja q da pra guardar diversos produtos
                Produto products = new Produto(productName,productPrice,productQuantity);
                listadeProdutos.add(products);
                System.out.println("Product added successfully!");
            }else if(choice == 2) {
                //for pra ter acesso a todos IDS da lista
                for (int i = 0; i < listadeProdutos.size(); i++) {
                    System.out.println("ID " + i + " Product: " + listadeProdutos.get(i));
                }
                System.out.println("Type the id of the product that you want to remove");
                int removeProduct = scanner.nextInt();

                //mini tratamento de erro pra tentar previnir erros do usuario kk
                if(removeProduct >= 0 && removeProduct < listadeProdutos.size()) {
                    listadeProdutos.remove(removeProduct);
                    System.out.println("Product removed successfully!");
                }
            }else if (choice == 3) {
                //for each basico so pra listar os produtos
                System.out.println("Your Products List:");
                for (Produto eachProduct : listadeProdutos) {
                    System.out.println(eachProduct);
                }
            }
        }while (choice != 4);
        System.out.println("System closed . . .");
        scanner.close();
    }
}
