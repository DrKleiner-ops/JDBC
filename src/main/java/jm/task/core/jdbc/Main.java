package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util.createTable();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Jora", "Vareny", (byte) 23));
        users.add(new User("Perqw", "S", (byte) 65));
        users.add(new User("Jfdsf", "Vrewr", (byte) 212));
        users.add(new User("Jfda", "EWfdsf", (byte) 1));
        for (User us : users) {
            Util.addUser(us);
            System.out.println(us.getName() + " done");
        }
        Util.selectAll();
        Util.drop();
    }
}
