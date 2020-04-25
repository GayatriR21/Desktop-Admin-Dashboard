/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author londo
 */
public class DatabaseManager {
    
    public Connection connection;
    
    public DatabaseManager() {
    }
    

    // connect database
    public void connect() {
        if (connection == null) {
            try {
                
                connection = DriverManager.getConnection("jdbc:mysql://" + DatabaseConstants.DATABASE_URL + "/" + DatabaseConstants.DATABASE_NAME + "?" +
                                   "user=" + DatabaseConstants.USERNAME + "&password=" + DatabaseConstants.PASSWORD + "&useLegacyDatetimeCode=false&serverTimezone=UTC");
                
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public ResultSet query(String statement) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(statement);
        return resultSet;
    }
    
    public ResultSet query(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }
    
}
