package ControleEstoquePOO;

import java.util.ArrayList;

public class userManager {
    ArrayList<CreateUser> usersList = new ArrayList<>();
    UserRepository userRepository = new UserRepository();

    public boolean cpfExists(String cpf) {
        for (CreateUser eachUser : usersList) {
            if (eachUser.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean userExists(String user) {
        for (CreateUser eachUser : usersList) {
            if (eachUser.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public int loginAuthenticator(String user,String password) {
        for (CreateUser eachUser : usersList) {
            if (eachUser.getUser().equals(user)) {
                if (eachUser.getPassword().equals(password)) {
                    return 1;
                }else {
                    return 2;
                }
            }
        }
        return 3;
    }


    public void addUsers(CreateUser newUser) {
        usersList.add(newUser);
        userRepository.saveUsers(usersList);
    }
}
