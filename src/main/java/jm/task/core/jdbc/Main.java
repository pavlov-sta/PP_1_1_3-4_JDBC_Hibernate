package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private static final UserService USER_SERVICE = new UserServiceImpl();

    public static void main(String[] args) {
        USER_SERVICE.createUsersTable();

        USER_SERVICE.saveUser("Ivan ", "Ivanov", (byte) 30);
        USER_SERVICE.saveUser("Maria", "Petrova", (byte) 25);
        USER_SERVICE.saveUser("Bob", "Dilan", (byte) 31);
        USER_SERVICE.saveUser("Jon", "Wick", (byte) 48);

        USER_SERVICE.getAllUsers().stream().forEach(System.out::println);
        USER_SERVICE.cleanUsersTable();
        USER_SERVICE.dropUsersTable();

    }
}
