package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao<User, Integer> {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findById(Integer id) {
        String query = "SELECT * FROM users WHERE id=?";
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try {
            PreparedStatement statement = connection.prepareStatement(query);


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String save = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(save);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Save success" : "Save failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {
        String update = "UPDATE users SET first_name=?, last_name=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getId());
            int result = statement.executeUpdate();
            System.out.println(result == 1 ? "Update success" : "Update failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(Integer id) {
        String delete = "DELETE FROM users WHERE id=?";
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

