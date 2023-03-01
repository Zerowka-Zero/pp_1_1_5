//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String sqlCommand = "CREATE TABLE user (Id INT PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR(45), lastname  VARCHAR(45), age INT)";
//        try (Connection connection = Util.getConnection()) {
//            connection.createStatement().executeUpdate(sqlCommand);
//            connection.commit();
//            System.out.println("Таблица созданна ✅\n");
//        } catch (SQLException ex ) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String sqlCommand = "DROP TABLE user";
//        try (Connection connection = Util.getConnection()) {
//            connection.createStatement().executeUpdate(sqlCommand);
//            connection.commit();
//            System.out.println("Таблица удалена ✅\n");
//        } catch (SQLException ex) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String sqlCommand = "INSERT INTO user (firstName, lastname, age) VALUE (?, ?, ?)";
//        try (Connection connection = Util.getConnection()) {
//            var ps = connection.prepareStatement(sqlCommand);
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setInt(3, age);
//            ps.executeUpdate();
//            connection.commit();
//            System.out.printf("User с именем – %s добавлен в базу данных ✅\n", name);
//
//        } catch (SQLException ex ) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (Connection connection = Util.getConnection()) {
//            String sqlCommand = "DELETE FROM user WHERE Id = ?";
//            PreparedStatement ps = connection.prepareStatement(sqlCommand);
//            ps.setLong(1, id);
//            ps.executeUpdate();
//            connection.commit();
//            System.out.printf("Пользователь с id %s удален из базы данных ✅\n", id);
//        } catch (SQLException ex) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sqlCommand = "SELECT * FROM user";
//        try (Connection connection = Util.getConnection()) {
//            ResultSet rs = connection.createStatement().executeQuery(sqlCommand);
//            while (rs.next()) {
//                User user = new User(rs.getString(2), rs.getString(3), rs.getByte(4));
//                user.setId(rs.getLong(1));
//                users.add(user);
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        try (Connection connection = Util.getConnection()) {
//            String sqlCommand = "TRUNCATE user";
//            PreparedStatement ps = connection.prepareStatement(sqlCommand);
//            ps.executeUpdate();
//            connection.commit();
//            System.out.println("✅\n");
//
//        } catch (SQLException ex) {
//            System.out.println("☦️");
//            ex.getStackTrace();
//        }
//    }
//}
