package com.project.wavveline.dao;

import com.project.wavveline.connection.DBConnection;
import com.project.wavveline.entities.User;

import java.sql.*;

public class UserDAO {
    private Connection connection = null;
    private PreparedStatement statement = null;

    //TODO ADICIONAR VERIFIAÇÃO DE DADOS REPETIDOS
    public boolean createAccount(User user) {
        try {
            connection = DBConnection.getConnection();
            statement = connection.prepareStatement("INSERT INTO user (username, name, password, title, email) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getTitle());
            statement.setString(5, user.getEmail());

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to add user: " + e.getMessage());
            return false;
        }
    }

    public ResultSet findUser(String username, String password) {
        ResultSet resultSet = null;
        try {
            connection = DBConnection.getConnection();

            statement = connection.prepareStatement("SELECT name, title FROM user WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException("Login info not found!" + e.getMessage());
        }
        return resultSet;
    }
}

