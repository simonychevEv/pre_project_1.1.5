package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User USER1 = new User("Petr", "Ivanov", (byte) 28);
    private static final User USER2 = new User("Oleg", "Petrov", (byte) 33);
    private static final User USER3 = new User("Mariya", "Sidorova", (byte) 30);
    private static final User USER4 = new User("Nikolay", "Smirnov", (byte) 25);

    public static void main(String[] args) {
        // Создание таблицы
        userService.createUsersTable();
        // Добавление 4 пользователей
        userService.saveUser(USER1.getName(), USER1.getLastName(), USER1.getAge());
        userService.saveUser(USER2.getName(), USER2.getLastName(), USER2.getAge());
        userService.saveUser(USER3.getName(), USER3.getLastName(), USER3.getAge());
        userService.saveUser(USER4.getName(), USER4.getLastName(), USER4.getAge());
        // Получение всех User(ов) из таблицы
        for (User user: userService.getAllUsers()) {
            System.out.println(user);
        }
        // Удаление User по id
        userService.removeUserById(1);
        // Очистка таблицы
        userService.cleanUsersTable();
        // Удаление таблицы
        userService.dropUsersTable();
    }
}
