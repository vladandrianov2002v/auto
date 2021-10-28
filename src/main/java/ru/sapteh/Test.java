package ru.sapteh;

import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.UserDaoImpl;
import ru.sapteh.model.User;
import ru.sapteh.utils.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getInstance();
        Dao<User,Integer> userDao =new UserDaoImpl(connection);

        System.out.println(userDao.findById(1));
    }
}
