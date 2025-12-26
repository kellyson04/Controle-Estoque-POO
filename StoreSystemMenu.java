import java.util.ArrayList;
import java.util.Scanner;

public class StoreSystemMenu {
    ArrayList<Produto> listaProdutos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    //tentando melhorar o programa, porem agora com auxilio de metodos e preferindo switch no lugar de ifs na escolha do menu ja que são numeros fixos
    public void opcoesMenu() {
        do {
            System.out.println("---- Welcome to our STORE CRUD SYSTEM! ----");
            System.out.print(" 1 - Add Product\n 2 - Remove Product by ID\n 3 - Remove Product by Name\n 4 - Update name,price or quantity\n 5 - List all Products\n 6 - List Products by Category\n 7 - Quit Program \n:");
            choice = scanner.nextInt();
            scanner.nextLine();

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

            }
        }while (choice != 7 );
    }
    public void addProduct() {
        System.out.print("Product name:");
        String productName = scanner.nextLine();
        System.out.print("Product category:");
        String productCategory = scanner.nextLine();
        System.out.print("Product price:");
        try {
            double productPrice = scanner.nextDouble();
            System.out.print("Product quantity:");
            int productQuantity = scanner.nextInt();

            Produto produto = new Produto(productName,productCategory,productPrice,productQuantity);
            listaProdutos.add(produto);
            System.out.println("Product successfully added!");
        }catch (Exception error) {
            System.err.println("❌ONLY NUMBERS!❌");
            scanner.nextLine();
        }
    }

    public void removeProductById() {
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);
            System.out.print("AVAILABLE IDS TO REMOVE:");
            System.out.println(i + " " + actualProduct.getProductName());

        }
        try {
            System.out.print("Type the ID of the product that you want to remove:");
            int productToRemove = scanner.nextInt();
            if (productToRemove >= 0 && productToRemove < listaProdutos.size()) {
                listaProdutos.remove(productToRemove);
                System.out.println("Product successfully removed!");
            }
        }catch (Exception error) {
            System.out.println("ONLY NUMBERS!");
        }
    }

    public void removeProductByName() {
        System.out.println("Enter the name of the product to remove:");
        String productToRemove = scanner.nextLine();

        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);
            if (actualProduct.getProductName().equalsIgnoreCase(productToRemove)) {
                listaProdutos.remove(actualProduct);
                System.out.println("Product successfully removed!");
                break;
            }
        }
    }

    public void updateProduct() {
        System.out.print("Products Available for Update\n");
        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);
            System.out.println(i + " " + actualProduct.getProductName() + " " + actualProduct.getProductCategory() + " " + actualProduct.getProductPrice() + " " + actualProduct.getProductQuantity());
        }


        System.out.println("What would you like to update? 1 - Name | 2 - Category | 3 - Price | 4 - Quantity:");
        int changeProduct = scanner.nextInt();
        scanner.nextLine();

        if (changeProduct == 1) {
            System.out.print("Enter the current name of the product:");
            String productNameToChange = scanner.nextLine();

            System.out.print("Enter the NEW name:");
            String productNewName = scanner.nextLine();

            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);

                if (actualProduct.getProductName().equalsIgnoreCase(productNameToChange)) {
                    actualProduct.setProductName(productNewName);
                    System.out.println("✅Name successfully changed! . . .✅");
                    break;
                }
            }

        }else if (changeProduct == 2) {



            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);
                System.out.println("ID " + i + " Category:" +actualProduct.getProductCategory());
            }

            System.out.println("Enter the product ID:");
            int idtoChangeCategory = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);
                if (i == idtoChangeCategory) {
                    System.out.println("Enter the NEW Category:");
                    String productNewCategory = scanner.nextLine();

                    actualProduct.setProductCategoryName(productNewCategory);
                    System.out.println("✅Category successfully changed!✅");
                    break;
                }
            }

        }else if (changeProduct == 3) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);
                System.out.println("ID " + i + " Price $:" +actualProduct.getProductPrice());
            }

            System.out.println("Now Enter the ID:");
            int idToChangePrice = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);

                if (i == idToChangePrice) {
                    System.out.println("Enter the new Price:");
                    double newProductPrice = scanner.nextDouble();
                    actualProduct.setProductPrice(newProductPrice);
                    System.out.println("Product price successfully changed!");
                    break;
                }
            }
        }else if (changeProduct == 4) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);
                System.out.println("ID " + i + " Quantity:" +actualProduct.getProductQuantity());
            }

            System.out.println("Now Enter the ID:");
            int changeQuantityID = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0;  i < listaProdutos.size(); i++) {
                Produto actualProduct = listaProdutos.get(i);

                if (i == changeQuantityID) {
                    System.out.print("Enter the new quantity:");
                    int newProductQuantity = scanner.nextInt();
                    actualProduct.setProductQuantity(newProductQuantity);
                    System.out.println("✅Quantity successfully changed!✅");
                    break;
                }
            }
        }
    }

    public void listProducts() {
        for (Produto eachProductSpecifics : listaProdutos) {
            System.out.println(eachProductSpecifics);
        }
    }
    
    public void listProductsByCategory() {
        System.out.print("Enter the category you want to list:");
        String categoryToList = scanner.nextLine();

        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto actualProduct = listaProdutos.get(i);

            if (actualProduct.getProductCategory().equalsIgnoreCase(categoryToList)) {
                System.out.println("Products in category " +categoryToList);
                System.out.println(actualProduct.getProductName());
            }
        }
    }
}
