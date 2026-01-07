package ControleEstoquePOO;
import java.util.Scanner;


public class LoginScreen {
    userManager userManager = new userManager();
    StoreSystemMenu menuLoja = new StoreSystemMenu(userManager.usersList);
    UserRepository userRepository = new UserRepository();
    int choice = 0;
    Scanner scanner = new Scanner(System.in);
    public void accountOptions() {

        //metodo de menu simples
        do {
            //uso do "scanner buffado" q é feito pra pegar erros do usuario e n quebrar o programa
            choice = InputUtility.readIntNumbers("1 - Create Account | 2 - Login | 3 - Exit:");


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

        String newUserValues = verifyUsers();
        String cpf = verifyCpf();
        String password = verifyPassword();

        userManager.addUsers(new CreateUser(newUserValues,cpf,password));

        userRepository.saveUsers(userManager.usersList);

        System.out.println("✅User saved!✅");
    }

    public void accountLogin() {
        System.out.println(" ----- AVAILABLE USERS -----");
        listAvailableUsers();

        loginChecker();
    }

    public String verifyUsers() {
        while (true) {
            System.out.println("Enter your new user:");
            String newUser = scanner.nextLine();

            if (userManager.userExists(newUser)) {
                System.err.println("❌THIS USER IS ALREADY BEING USED❌");
            }else {
                return newUser;
            }
        }
    }

    public void loginChecker() {
        if (userManager.usersList.isEmpty()) {
            System.err.println("❌YOU STILL HADN'T ANY USERS CREATED❌");
            return;
        }

        while (true) {
            System.out.print("Enter the username to login:");
            String user = scanner.nextLine();
            System.out.println("Enter the password to login:");
            String password = scanner.nextLine();

            int loginStatus = userManager.loginAuthenticator(user,password);

            if (loginStatus == 1) {
                ProductManager productManager = new ProductManager(userManager.usersList);
                System.out.println("✅ Successfully logged in :D ✅");
                menuLoja.menuOptions();
                return;
            }else if (loginStatus == 2) {
                System.err.println("❌ WRONG PASSWORD! ❌");
            }else {
                System.err.println("❌ THIS USER DOESN'T EXIST ❌");
            }
        }
    }

    public void listAvailableUsers() {
        for (CreateUser eachUser: userManager.usersList) {
            System.out.println(eachUser.getUser());
        }
    }
    public  String verifyPassword() {
        while (true) {
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            System.out.println("Confirm your password:");
            String confirmPassword = scanner.nextLine();

            //so deixa o usuario criar conta se ambas senhas forem iguais
            if (confirmPassword.equals(password)) {
                return password;
            }else {
                System.err.println("❌PASSWORDS DO NOT MATCH!❌");
            }
        }
    }

    public String verifyCpf() {
        while (true) {
            String cpf = InputUtility.readCPF("Enter your CPF:");

            if (userManager.cpfExists(cpf)) {
                System.err.println("❌ THIS CPF ALREADY EXIST ❌");
            }else {
                return cpf;
            }

        }
    }
}
