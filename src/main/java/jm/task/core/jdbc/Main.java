package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //userService.createUsersTable();
        //userService.dropUsersTable();
        //userService.saveUser("Polina", "Gybareva", (byte) 23);
        //userService.removeUserById(1);
        for (User us : userService.getAllUsers()) {
            System.out.println(us);
        }
    }
}
