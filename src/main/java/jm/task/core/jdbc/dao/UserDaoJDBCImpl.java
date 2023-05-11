package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection CON = new Util().getMySQLConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE user " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY (id))";

        try (Statement stm = CON.createStatement()) {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void dropUsersTable() {
        try (Statement dropTable = CON.createStatement()) {
            dropTable.executeUpdate("DROP TABLE if exists user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement pstm = CON.prepareStatement("INSERT INTO user (name, lastName, age) VALUES (?,?,?)")) {
            pstm.setString(1, name);
            pstm.setString(2, lastName);
            pstm.setInt(3, age);
            pstm.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement psmt = CON.prepareStatement("DELETE FROM user WHERE id = ?")) {
            psmt.setLong(1, id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

       /* try (Statement stm = CON.createStatement()) {
            ResultSet rst = stm.executeQuery("SELECT * FROM user");
            while (rst.next()) {
                User user = new User();
                user.setId(rst.getLong("id"));
                user.setName(rst.getString("name"));
                user.setLastName(rst.getString("lastName"));
                user.setAge(rst.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement stm = CON.createStatement()) {
            stm.executeUpdate("DELETE from user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
