package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final SessionFactory sessionFactory = buildSessionFactory();

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

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure(new File("src\\main\\resources\\hibernate.cfg.xml"))
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
