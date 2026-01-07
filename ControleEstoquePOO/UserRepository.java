package ControleEstoquePOO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UserRepository {

    public void saveUsers(ArrayList<CreateUser> usersList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("users.csv"))) {

            for(CreateUser user : usersList) {
                writer.println( " -> " +user.getUser() + "," + user.getCpf() + "," + user.getPassword());
            }

        } catch (IOException e) {
            System.out.println("❌TECHNICAL ERROR AT THE DISC");
        }
    }
}
