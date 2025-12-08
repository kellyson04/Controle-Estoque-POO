import java.util.Scanner;

public class executarProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do produto:");
        String productName = scanner.nextLine();
        System.out.println("Digite o valor do produto:");
        double productPrice = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto:");
        int productQuantity = scanner.nextInt();

        Produto produtoFuncoes = new Produto(productName,productPrice,productQuantity);

        System.out.println(produtoFuncoes);

        System.out.println("Deseja adicionar mais estoque de "+productName+" se sim TYPE add, se desejar remover TYPE remove:");
        System.out.println("Caso nao queira adicionar nada apenas digite SAIR");
        String stockAddOrRemoveChoose = scanner.next().toUpperCase();

        if (stockAddOrRemoveChoose.equals("SAIR")) {
            System.out.println("TOTAL:");
            System.out.println(produtoFuncoes + " obrigado!");
            System.exit(0);
        }

        do {
            if (stockAddOrRemoveChoose.equals("ADD")) {
                System.out.print("Agora insira a quantia que deseja adicionar no estoque:");
                int quantityAddValue = scanner.nextInt();
                produtoFuncoes.addProduct(quantityAddValue);
            }if (stockAddOrRemoveChoose.equals("REMOVE")) {
                System.out.println("Agora insira a quantia que deseja remover no estoque:");
                int quantityRemoveValue = scanner.nextInt();
                produtoFuncoes.removeProduct(quantityRemoveValue);
            }
            System.out.println("TOTAL ATUALIZADO:");
            System.out.println(produtoFuncoes);

            System.out.println("Caso nao queira adicionar mais nada apenas digite SAIR");
            System.out.println("Agora se deseja adicionar mais estoque de "+productName+" se sim TYPE add, se desejar remover TYPE remove:");
            stockAddOrRemoveChoose = scanner.next().toUpperCase();
        }while (!stockAddOrRemoveChoose.equals("SAIR"));



        System.out.println("TOTAL ATUALIZADO:");
        System.out.println(produtoFuncoes);



    }
}
