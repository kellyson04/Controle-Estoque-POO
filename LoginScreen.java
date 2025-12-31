import java.util.ArrayList;
import java.util.Scanner;

public class LoginScreen {
    ArrayList<CreateUser> usersList = new ArrayList<>();
    int choice = 0;
    Scanner scanner = new Scanner(System.in);
    public void accountOptions() {

        //metodo de menu simples
        do {
            //uso do "scanner buffado" q é feito pra pegar erros do usuario e n quebrar o programa
            choice = readNumbers("1 - Create Account | 2 - Login | 3 - Exit:");


            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    accountLogin();
                    break;
                case 3:
                    System.out.println("SYSTEM CLOSED . . . BYE");
                    break;
                default:
                    System.err.println("❌AVAILABLE MENU OPTIONS ARE ONLY 1,2 or 3");
                    break;
            }
        }while (choice != 3);
    }

    //
    public void createAccount() {
        System.out.println("Enter username:");
        String user = scanner.nextLine();
        String cpf = readCPF("Enter your CPF:");
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        while (true) {
            System.out.println("Confirm your password:");
            String confirmPassword = scanner.nextLine();

            //so deixa o usuario criar conta se ambas senhas forem iguais
            if (confirmPassword.equals(password)) {
                CreateUser newUser = new CreateUser(user,cpf,password);
                usersList.add(newUser);
                System.out.println("Account successfully created!");
                break;
            }else {
                System.err.println("❌PASSWORDS DO NOT MATCH!❌");
            }
        }
    }

    public void accountLogin() {
        //laço com o intuito apenas de listagem de usuarios
        System.out.println(" ----- AVAILABLE USERS -----");
        for (CreateUser eachUser : usersList) {
            System.out.println(eachUser.getUser());
        }


        System.out.print("Enter username to login:");
        String user = scanner.nextLine();

        //entendendo melhor o uso de variaveis booleanas pra confirmar se encontrou o usuario dentro do laço
        boolean findUser = false;
        for (CreateUser eachUser:usersList) {
            if (eachUser.getUser().equals(user)) {
                findUser = true;
                System.out.println("Password:");
                String password = scanner.nextLine();

                //o segundo if so funciona se a primeira parte se cumprir, no caso ambos tentam pegar erros do usuario
                if (eachUser.getPassword().equals(password)) {
                    System.out.println("✅ Successfully logged in :D✅");

                    StoreSystemMenu menuLoja = new StoreSystemMenu();
                    menuLoja.opcoesMenu();

                    return;
                }else {
                    System.err.println("❌ WRONG PASSWORD! ❌");
                    break;
                }
            }

        }
        //outra opção de erro q descobri ter como fazer com variaveis booleanas
        if (findUser == false) {
            System.err.println("USER DOES NOT EXIST");
        }

    }

    //metodo mt util pra ler nomes e avisar o usuario no caso da digitação de numeros
    public String readCPF(String message) {

        while (true) {
            System.out.println(message);
            String entrada = scanner.nextLine();

            if (entrada.matches("[0-9.-]+")) {
                if (entrada.length() <= 14) {
                    return entrada;
                }else {
                    System.err.println("❌CHARACTER LIMIT EXCEEDED (MAX 14)❌");
                }
            }else {
                System.err.println("❌ INVALID INPUT, ONLY NUMBERS AND '-' '.' ");
            }
        }
    }

    //seguindo a mesma logica de cima porem sendo mais importante ainda pq caso digite letra em uma variavel int o programa quebra
    public int readNumbers(String message) {
        while (true) {
            System.out.println(message);

            String entrada = scanner.nextLine();

            try {
                int number = Integer.parseInt(entrada);
                   return number;


            }catch (NumberFormatException error) {
                System.err.println("❌ENTER ONLY NUMBERS PLEASE❌");
            }
        }
    }
}
