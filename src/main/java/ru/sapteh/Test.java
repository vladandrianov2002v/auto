package ru.sapteh;

import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.AutoDaoImpl;;
import ru.sapteh.model.Auto;
import ru.sapteh.utils.Connector;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = Connector.getInstance();
        Dao<Auto,Integer> autoDao =new AutoDaoImpl(connection);
        Auto auto1 =new Auto("niva","lada","universal",92);
        System.out.println(autoDao.findById(1));
        System.out.println(autoDao.findAll());
        autoDao.save(auto1);
        autoDao.deleteById(5);
    }
}
