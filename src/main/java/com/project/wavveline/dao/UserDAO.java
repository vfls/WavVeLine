package com.project.wavveline.dao;

import com.project.wavveline.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    private final Connection connection = null;
    private PreparedStatement statement = null;

    public boolean createAccount(User user) {
        try {
            statement = connection.prepareStatement("INSERT INTO user (username, name, password, title, email) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getTitle());
            statement.setString(6, user.getEmail());

            int rowInserted = statement.executeUpdate();
            return rowInserted > 0;

        } catch (SQLException e) {
            System.out.println("Unable to add user: " + e.getMessage());
            return false;
        }

    }
}
