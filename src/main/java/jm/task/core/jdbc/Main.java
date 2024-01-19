package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
//        // Создание таблицы
        userService.createUsersTable();
//        // Добавление 4 пользователей
        userService.saveUser("Petr", "Ivanov", (byte) 28);
        userService.saveUser("Oleg", "Petrov", (byte) 33);
        userService.saveUser("Mariya", "Sidorova", (byte) 30);
        userService.saveUser("Nikolay", "Smirnov", (byte) 25);
//        // Получение всех User(ов) из таблицы
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
//        // Удаление User по id
        userService.removeUserById(1);
//        // Очистка таблицы
        userService.cleanUsersTable();
//        // Удаление таблицы
        userService.dropUsersTable();
    }
}
