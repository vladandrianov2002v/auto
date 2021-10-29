package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.Auto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoImpl implements Dao<Auto, Integer> {

    private final Connection connection;

    public AutoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auto findById(Integer id) {
        String query = "SELECT * FROM auto WHERE id=?";
        Auto auto = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                auto = new Auto(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("marka"),
                        resultSet.getString("body_type"),
                        resultSet.getInt("type_gasoline")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;

    }

    @Override
    public List<Auto> findAll() {
        List<Auto> autos = new ArrayList<>();
        String query = "SELECT * FROM auto";

        try {
            PreparedStatement statement = connection.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                autos.add(
                        new Auto(
                                resultSet.getInt("id"),
                                resultSet.getString("model"),
                                resultSet.getString("marka"),
                                resultSet.getString("body_type"),
                                resultSet.getInt("type_gasoline")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }

    @Override
    public void save(Auto auto) {
        String save = "INSERT INTO auto (model, marka, body_type, type_gasoline) VALUES (?, ?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(save);
            statement.setString(1, auto.getModel());
            statement.setString(2, auto.getMarka());
            statement.setString(3, auto.getBodyType());
            statement.setInt(4, auto.getTypeGasoline());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Save success" : "Save failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Auto auto) {
        String update = "UPDATE auto SET model=?, marka=?, body_type=?, type_gasoline=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, auto.getModel());
            statement.setString(2, auto.getMarka());
            statement.setString(3, auto.getBodyType());
            statement.setInt(4, auto.getTypeGasoline());
            statement.setInt(5, auto.getId());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Update success" : "Update failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(Integer id) {
        String delete = "DELETE FROM auto WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Delete success" : "Delete failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

