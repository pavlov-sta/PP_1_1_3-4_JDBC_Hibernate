package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public Connection getMySQLConnection() {
        Connection con = null;
        try {
            String userName = "root";
            String password = "cfxzkX?i1";
            String connectionUrl = "jdbc:mysql://localhost:3306/mySql_test";

            con = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
