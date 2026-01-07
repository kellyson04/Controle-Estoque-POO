package ControleEstoquePOO;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreSystemMenu {
    //agora eu declaro as variaveis para serem globais pra deixar os novos metodos q constroem livros e eletrodomesticos mais limpos invocando apenas o metodo
    //baseProduct que serve pra preencher as vars globais antes de serem passadas para o arraylist.
    ProductManager productsManager;
    Scanner scanner = new Scanner(System.in);
    ProductRepository productRepository = new ProductRepository();

    String productName;
    String productCategory;
    double productPrice;
    int productQuantity;
    String userCpf;

    public StoreSystemMenu(ArrayList<CreateUser> usersList) {
        this.productsManager = new ProductManager(usersList);
    }


    int choice = 0;


    public void menuOptions() {
        do {

            //se o usuario digitasse uma letra no menu antigamente o programa quebrava, com o metodo readIntNumbers isso não ocorre mais.
            System.out.println("---- Welcome to our STORE CRUD SYSTEM! ----");
            choice = InputUtility.readIntNumbers(" 1 - Add Product\n 2 - Remove Product by ID\n 3 - Remove Product by Name\n 4 - Update name,category,price or quantity\n 5 - List all Products\n 6 - List Products by Category\n 7 - Quit Program \n:");

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
        int productType = InputUtility.readIntNumbers("Which category is your Product: 1 - Eletronics 2 - Books 3 - Alimentos");

        switch (productType) {
            case 1:
                eletronicProduct();
                break;
            case 2:
                bookProduct();
                break;
            case 3:
                foodProduct();
                break;
            default:
                System.out.println("❌THIS OPTION DOESNT EXIST ON MENU❌");
        }
    }

    public void baseProduct() {
        productName = InputUtility.readNames("Product name:");
        productCategory = InputUtility.readNames("Product category:");
        productPrice = InputUtility.readDoubleNumbers("Product price:");
        productQuantity = InputUtility.readIntNumbers("Product quantity:");
        userCpf = InputUtility.readCPF("Enter your CPF again:");
    }

    public void eletronicProduct() {
        int voltage = InputUtility.readIntNumbers("Enter the voltage:");
        System.out.println("Enter the power:");
        String power = scanner.nextLine();
        System.out.println("Enter the current:");
        String current = scanner.nextLine();
        baseProduct();

        productsManager.addProducts(new Eletronico(voltage,power,current,productName,productCategory,productPrice,productQuantity,userCpf));
        productRepository.saveProducts(productsManager.productsList);
        System.out.println("✅Product successfully added!✅");
    }

    public void bookProduct() {
        String author = InputUtility.readNames("Enter author name:");
        String genre = InputUtility.readNames("Enter the book genre:");
        System.out.println("Enter the publisher:");
        String publisher = scanner.nextLine();
        int pages = InputUtility.readIntNumbers("Enter pages number:");
        baseProduct();

        productsManager.addProducts(new Book(author,genre,publisher,pages,productName,productCategory,productPrice,productQuantity,userCpf));
        productRepository.saveProducts(productsManager.productsList);
        System.out.println("✅Product successfully added!✅");
    }

    public void foodProduct() {
        String brand = InputUtility.readNames("Enter the brand:");
        String expirationDate = InputUtility.readDates("Enter the expiration date:");
        double weight = InputUtility.readDoubleNumbers("Enter the weight:");
        baseProduct();

        productsManager.addProducts(new Food(brand,expirationDate,weight,productName,productCategory,productPrice,productQuantity,userCpf));
        productRepository.saveProducts(productsManager.productsList);
        System.out.println("✅Product successfully added!✅");
    }

    public void removeProductById() {
        listProducts();

        if (productsManager.productsList.isEmpty()) {
            return;
        }
        int productToRemove = InputUtility.readIntNumbers("Enter the ID of the product to remove:");
        if (productToRemove >= 0 && productToRemove < productsManager.productsList.size()) {
            productsManager.productsList.remove(productToRemove);
            productRepository.saveProducts(productsManager.productsList);
            System.out.println("✅Product successfully removed!✅");

        }else {
            System.out.println("❌INVALID ID.❌");
        }
    }

    public void removeProductByName() {
        listProducts();

        if (productsManager.productsList.isEmpty()) {
            return;
        }

        Produto actualProductName = null;

        while (actualProductName == null) {
            String productToRemove = InputUtility.readNames("Enter the name that you'd like to remove:");
            for (Produto eachProductName : productsManager.productsList) {
                if (eachProductName.getProductName().equalsIgnoreCase(productToRemove)) {
                    actualProductName = eachProductName;
                    break;
                }
            }
            if (actualProductName == null) {
                System.out.println("❌ THIS PRODUCT NAME DOESNT EXIST ❌");
            }
        }

        productsManager.productsList.remove(actualProductName);
        productRepository.saveProducts(productsManager.productsList);
        System.out.println("✅Product successfully removed✅");

    }

    public void updateProduct() {
        listProducts();

        if (productsManager.productsList.isEmpty()) {
            return;
        }

        int changeProduct = InputUtility.readIntNumbers("What would you like to update? 1 - Name | 2 - Category | 3 - Price | 4 - Quantity:");
        System.out.println("Products Available for Update");
        //agora utilizo o metodo listProducts abaixo pra tentar ao maximo seguir a regra do dont repeat yourself e escrever codigo atoa.
        listProducts();

        if (changeProduct == 1) {
            /*primeira vez usando a tecnica de loop com null, utilizei nas outras opções tb, codigo fica muito mais legivel
              e não tem mais aquele bug chato no qual o usuario digiva um nome ou preco etc que não existia e o programa voltava para o menu
              sem nenhuma explicação.*/

            Produto updateName = null;

            while (updateName == null) {
                String productNameToChange = InputUtility.readNames("Enter the current name of the product:");

                for (Produto eachProduct : productsManager.productsList) {
                    if (eachProduct.getProductName().equalsIgnoreCase(productNameToChange)) {
                        updateName = eachProduct;
                        break;
                    }
                }

                if (updateName == null) {
                    System.err.println("❌ THIS NAME DOESN'T EXIST ❌");
                }
            }

            String changeProductName = InputUtility.readNames("Enter the new name:");
            updateName.setProductName(changeProductName);
            productRepository.saveProducts(productsManager.productsList);
            System.out.println("✅Name successfully changed✅");

        }else if (changeProduct == 2) {
            Produto actualCategory = null;

            while (actualCategory == null) {
                String categoryToChange = InputUtility.readNames("Enter the category name:");
                for (Produto eachProduct : productsManager.productsList) {
                    if (eachProduct.getProductCategory().equalsIgnoreCase(categoryToChange)) {
                        actualCategory = eachProduct;
                        break;
                    }
                }

                if (actualCategory == null) {
                    System.out.println("❌THIS CATEGORY DOESN'T EXIST❌");
                }
            }

            String updateCategory = InputUtility.readNames("Enter the new category name:");
            actualCategory.setProductCategoryName(updateCategory);
            productRepository.saveProducts(productsManager.productsList);
            System.out.println("✅Category successfully changed!✅");

        }else if (changeProduct == 3) {
            Produto actualPrice = null;

            while (actualPrice == null) {

                int idToChangePrice = InputUtility.readIntNumbers("Enter the id of the product that you'd like to change the price:");
                if (idToChangePrice >= 0 && idToChangePrice < productsManager.productsList.size()) {
                    Produto actualPricee = productsManager.productsList.get(idToChangePrice);
                    double newPrice = InputUtility.readDoubleNumbers("Enter the new Price:");
                    actualPricee.setProductPrice(newPrice);
                    actualPrice = actualPricee;
                    productRepository.saveProducts(productsManager.productsList);
                    System.out.println("✅Price successfully changed!✅");
                }else {
                    System.out.println("❌THIS ID IS INVALID❌");
                }
            }

        }else if (changeProduct == 4) {
            Produto actualQuantity = null;

            while (actualQuantity == null) {
                int idToChangeQuantity = InputUtility.readIntNumbers("Enter the id of the Product that you'd like to change:");
                if (idToChangeQuantity >= 0 && idToChangeQuantity < productsManager.productsList.size()) {
                    actualQuantity = productsManager.productsList.get(idToChangeQuantity);
                    int newQuantity = InputUtility.readIntNumbers("Enter the new quantity:");
                    actualQuantity.setProductQuantity(newQuantity);
                    productRepository.saveProducts(productsManager.productsList);
                    System.out.println("✅Quantity successfully changed✅");
                }else {
                    System.out.println("❌THIS ID IS INVALID❌");
                }
            }

        }
    }

    public void listProducts() {
        if (productsManager.productsList.isEmpty()) {
            System.err.println("❌You doesn't have any product in your cart yet❌");
        }

        for (int i = 0; i < productsManager.productsList.size(); i++) {
            System.out.println("ID " + i + productsManager.productsList.get(i));
        }
    }

    public void listProductsByCategory() {
        listProducts();
        if (productsManager.productsList.isEmpty()) {
            return;
        }
        String categoryToList = InputUtility.readNames("Enter category to list:");

        for (int i = 0; i < productsManager.productsList.size(); i++) {
            Produto actualProduct = productsManager.productsList.get(i);

            if (actualProduct.getProductCategory().equalsIgnoreCase(categoryToList)) {
                System.out.println("Products in category " +categoryToList);
                System.out.println(actualProduct.getProductName());
            }
        }
    }
}
