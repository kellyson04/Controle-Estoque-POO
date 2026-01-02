import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreSystemMenu {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    public void menuOptions() {
        do {

            //se o usuario digitasse uma letra no menu antigamente o programa quebrava, com o metodo readIntNumbers isso não ocorre mais.
            System.out.println("---- Welcome to our STORE CRUD SYSTEM! ----");
            choice = readIntNumbers(" 1 - Add Product\n 2 - Remove Product by ID\n 3 - Remove Product by Name\n 4 - Update name,category,price or quantity\n 5 - List all Products\n 6 - List Products by Category\n 7 - Quit Program \n:");


            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProductById();
                    break;
                case 3:
                    removeProductByName();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    listProducts();
                    break;
                case 6:
                    listProductsByCategory();
                    break;
                case 7:
                    System.out.println("SYSTEM CLOSED . . . BYE");
                    break;
                    /*agora com a existencia do default o usuario alem de não conseguir quebrar o programa com o metodo readNumbers digitando letras ao inves de numeros
                      ele tambem sera avisado quando digitar um numero indisponivel no menu.*/
                default:
                    System.out.println("❌THIS OPTION DOESNT EXIST ON MENU❌");

            }
        }while (choice != 7 );
    }
    public void addProduct() {
        //utilizando os metodos como scanner pra evitar quebra do programa ou dados sem sentido ex productName sendo = 1234, oque agora não é mais possivel graças ao regex.
        String productName = readNames("Product name:");
        String productCategory = readNames("Product category:");
        double productPrice = readDoubleNumbers("Product price:");
        int productQuantity = readIntNumbers("Product quantity:");
        Produto produto = new Produto(productName,productCategory,productPrice,productQuantity);
        listaProdutos.add(produto);
        saveProducts("✅Product successfully added!✅");


    }

    public void removeProductById() {
        System.out.print("AVAILABLE IDS TO REMOVE:");
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);
            System.out.println(i + " " + actualProduct.getProductName());

        }
        int productToRemove = readIntNumbers("Enter the ID of the product to remove:");
        if (productToRemove >= 0 && productToRemove < listaProdutos.size()) {
            listaProdutos.remove(productToRemove);
            saveProducts("✅Product successfully removed!✅");

        }else {
            System.out.println("❌INVALID ID.❌");
        }
    }

    public void removeProductByName() {
        listProducts();

        Produto actualProductName = null;

        while (actualProductName == null) {
            String productToRemove = readNames("Enter the name that you'd like to remove:");
            for (Produto eachProductName : listaProdutos) {
                if (eachProductName.getProductName().equalsIgnoreCase(productToRemove)) {
                    actualProductName = eachProductName;
                    break;
                }
            }
            if (actualProductName == null) {
                System.out.println("❌ THIS PRODUCT NAME DOESNT EXIST ❌");
            }


        }

        listaProdutos.remove(actualProductName);
        saveProducts("✅Product successfully removed✅");


    }

    public void updateProduct() {



        int changeProduct = readIntNumbers("What would you like to update? 1 - Name | 2 - Category | 3 - Price | 4 - Quantity:");
        System.out.println("Products Available for Update");
        //agora utilizo o metodo listProducts abaixo pra tentar ao maximo seguir a regra do dont repeat yourself e escrever codigo atoa.
        listProducts();

        if (changeProduct == 1) {
            /*primeira vez usando a tecnica de loop com null, utilizei nas outras opções tb, codigo fica muito mais legivel
              e não tem mais aquele bug chato no qual o usuario digiva um nome ou preco etc que não existia e o programa voltava para o menu
              sem nenhuma explicação.*/

            Produto updateName = null;


            while (updateName == null) {
                String productNameToChange = readNames("Enter the current name of the product:");

                for (Produto eachProduct : listaProdutos) {
                    if (eachProduct.getProductName().equalsIgnoreCase(productNameToChange)) {
                        updateName = eachProduct;
                        break;
                    }
                }

                if (updateName == null) {
                    System.err.println("❌ THIS NAME DOESN'T EXIST ❌");
                }
            }

            String changeProductName = readNames("Enter the new name:");
            updateName.setProductName(changeProductName);
            saveProducts("✅Name successfully changed✅");


        }else if (changeProduct == 2) {
            Produto actualCategory = null;

            while (actualCategory == null) {
                String categoryToChange = readNames("Enter the category name:");
                for (Produto eachProduct : listaProdutos) {
                    if (eachProduct.getProductCategory().equalsIgnoreCase(categoryToChange)) {
                        actualCategory = eachProduct;
                        break;
                    }
                }

                if (actualCategory == null) {
                    System.out.println("❌THIS CATEGORY DOESN'T EXIST❌");
                }
            }

            String updateCategory = readNames("Enter the new category name:");
            actualCategory.setProductCategoryName(updateCategory);
            saveProducts("✅Category successfully changed!✅");


        }else if (changeProduct == 3) {
            Produto actualPrice = null;

            while (actualPrice == null) {

                int idToChangePrice = readIntNumbers("Enter the id of the product that you'd like to change the price:");
                if (idToChangePrice >= 0 && idToChangePrice < listaProdutos.size()) {
                    Produto actualPricee = listaProdutos.get(idToChangePrice);
                    double newPrice = readDoubleNumbers("Enter the new Price:");
                    actualPricee.setProductPrice(newPrice);
                    actualPrice = actualPricee;
                    saveProducts("✅Price successfully changed!✅");
                }else {
                    System.out.println("❌THIS ID IS INVALID❌");
                }

            }


        }else if (changeProduct == 4) {
            Produto actualQuantity = null;

            while (actualQuantity == null) {
                int idToChangeQuantity = readIntNumbers("Enter the id of the Product that you'd like to change:");
                if (idToChangeQuantity >= 0 && idToChangeQuantity < listaProdutos.size()) {
                    actualQuantity = listaProdutos.get(idToChangeQuantity);
                    int newQuantity = readIntNumbers("Enter the new quantity:");
                    actualQuantity.setProductQuantity(newQuantity);
                    saveProducts("✅Quantity successfully changed✅");
                }else {
                    System.out.println("❌THIS ID IS INVALID❌");
                }
            }

        }
    }

    public void listProducts() {
        for (int i = 0; i < listaProdutos.size(); i++) {
            System.out.println("ID " + i + listaProdutos.get(i));
        }
    }

    public void listProductsByCategory() {
        String categoryToList = readNames("Enter category to list:");

        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);

            if (actualProduct.getProductCategory().equalsIgnoreCase(categoryToList)) {
                System.out.println("Products in category " +categoryToList);
                System.out.println(actualProduct.getProductName());
            }
        }
    }

    public String readNames(String message) {
        while (true) {
            System.out.println(message);
            String entrada = scanner.nextLine();
            if (entrada.matches("[a-zA-Z ]+")) {
                return entrada;
            }else {
                System.err.println("❌ ONLY LETTERS ARE ALLOWED HERE❌");
            }
        }
    }

    public int  readIntNumbers(String message) {
        while (true) {
            System.out.println(message);

            String entrada = scanner.nextLine();

            try {
                int number = Integer.parseInt(entrada);
                return number;

            }catch (NumberFormatException e) {
                System.err.println("❌ENTER ONLY NUMBERS PLEASE❌");
            }
        }
    }

    //percebi que com o uso do readIntNumbers no productPrice o usuario não conseguiria colocar por ex 10.50, então resolvi criar o readDoubleNumbers.
    public double readDoubleNumbers(String message) {
        while (true) {
            System.out.println(message);

            String entrada = scanner.nextLine();

            try {
                double converterEntrada = Double.parseDouble(entrada);
                return converterEntrada;

            }catch (NumberFormatException e) {
                System.err.println("❌ENTER ONLY NUMBERS PLEASE❌");
            }
        }
    }

    //mesma função do metodo saveUsers porem sendo utilizado nos produtos, ainda estou tentando entender melhor o funcionamento da biblioteca IO
    public void saveProducts (String message) {
        System.out.println(message);
        try (PrintWriter writer = new PrintWriter(new FileWriter("products.csv"))) {

            for (Produto product : listaProdutos) {
                writer.println(product.getProductName() + "," + product.getProductCategory() + "," + product.getProductPrice() + "," + product.getProductQuantity());
            }
        }catch (IOException error) {
            System.out.println("❌TECHNICAL ERROR AT THE DISC");
        }
    }

}
