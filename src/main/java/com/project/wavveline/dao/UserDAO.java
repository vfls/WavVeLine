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

            int rowInserted = statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Unable to add user: " + e.getMessage());
            return false;
        }

    }

    //TODO MUDAR FUNÇÃO PARA PUXAR NOME, USERNAME E CARGO DO USUÁRIO

    public boolean findUser(String username, String password) {
        try {
            connection = DBConnection.getConnection();

            statement = connection.prepareStatement("SELECT 1, FROM usermsg WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {

                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Login info not found!" + e.getMessage());
        }
    }

}

