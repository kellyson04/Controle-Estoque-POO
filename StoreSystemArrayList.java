import java.util.ArrayList;
import java.util.Scanner;

public class StoreSystemArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> listadeProdutos = new ArrayList<>();

        int choice = 0; //iniciando a var pra conseguir iniciar o loop do while

        do {

            System.out.println("---- Welcome to our STORE CRUD SYSTEM! ----");

            System.out.print(" 1 - Add Product\n 2 - Remove Product by ID\n 3 - Remove Product by Name\n 4 - List all Products\n 5 - List Products by Category\n 6 - Quit Program \n:");
            choice = scanner.nextInt();

            //limpando o bufferzin
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Product name:");
                String productName = scanner.nextLine();
                System.out.print("Product category:");
                String productCategory = scanner.nextLine();

                //aprendendo tratamento de erro com try catch caso o usuario digite o valor em String ou coloque um caracter invalido
                try {
                    System.out.print("Product price:");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Product quantity:");
                    int productQuantity = scanner.nextInt();
                    Produto products = new Produto(productName,productCategory,productPrice,productQuantity);
                    listadeProdutos.add(products);
                    System.out.println("Product added successfully!");
                }catch (Exception error) {
                    System.err.println("Invalid answer, only numbers here");
                    scanner.nextLine();
                }

            }else if(choice == 2) {
                //for pra ter acesso a todos IDS da lista
                for (int i = 0; i < listadeProdutos.size(); i++) {
                    System.out.println("ID " + i + " Product: " + listadeProdutos.get(i));
                }
                System.out.println("Type the id of the product that you want to remove");
                int removeProductbyID = scanner.nextInt();

                //mini tratamento de erro pra tentar previnir erros do usuario kk
                if(removeProductbyID >= 0 && removeProductbyID < listadeProdutos.size()) {
                    listadeProdutos.remove(removeProductbyID);
                    System.out.println("Product removed successfully!");
                }
            }else if(choice == 3) {
                //removendo produto por nome
                System.out.print("Type the Product name:");
                String removeProductbyName = scanner.nextLine();
                for (int i = 0; i < listadeProdutos.size(); i++) {
                    Produto listapraRemover = listadeProdutos.get(i);
                    if (listapraRemover.getProductName().equalsIgnoreCase(removeProductbyName)) {
                        listadeProdutos.remove(listapraRemover);
                        System.out.println("Product removed by name successfully!");
                        break;
                    }
                }
            } else if (choice == 4) {
                //for each basico so pra listar os produtos
                System.out.println("Your Products List:");
                for (Produto eachProduct : listadeProdutos) {
                    System.out.println(eachProduct);
                }
            }else if (choice == 5) {
                //lógica bem semelhante a de remover por nome, fiz com intuito de melhorar o uso de for if com araylist
                System.out.println("Type the category name:");
                String categoryName = scanner.nextLine();
                for (int i = 0; i < listadeProdutos.size(); i++) {
                    Produto listarCategorias = listadeProdutos.get(i);
                    if (listarCategorias.getProductCategory().equalsIgnoreCase(categoryName)) {
                        System.out.println(listarCategorias);
                    }
                }
            }
        }while (choice != 6);
        System.out.println("System closed . . .");
        scanner.close();
    }
}
