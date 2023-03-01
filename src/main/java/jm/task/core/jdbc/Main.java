package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Алексей", "Владыкин", (byte) 99);
        userService.saveUser("Джо", "Байден", (byte) 80);
        userService.saveUser("Алексей", "Навальный", (byte) 46);
        userService.saveUser("Рамзан", "Кадыров", (byte) 46);

        System.out.println(userService.getAllUsers());
        userService.dropUsersTable();
    }
}
