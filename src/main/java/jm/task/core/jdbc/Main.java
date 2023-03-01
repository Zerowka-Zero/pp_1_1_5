package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDaoHibernateImpl udhi = new UserDaoHibernateImpl();
        udhi.createUsersTable();
        udhi.saveUser("Алексей", "Владыкин", (byte) 99);
        udhi.saveUser("Джо", "Байден", (byte) 80);
        udhi.saveUser("Алексей", "Навальный", (byte) 46);
        udhi.saveUser("Рамзан", "Кадыров", (byte) 46);

        System.out.println(udhi.getAllUsers());

        udhi.dropUsersTable();
    }
}

