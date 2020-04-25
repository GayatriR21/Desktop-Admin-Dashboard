/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author londo
 */
public class DatabaseManager {
    
    Connection connection;
    
    // create properties
    private Properties getProperties() {
        Properties properties = new Properties();
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", DatabaseConstants.USERNAME);
            properties.setProperty("password", DatabaseConstants.PASSWORD);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DatabaseConstants.DATABASE_DRIVER);
                connection = DriverManager.getConnection(DatabaseConstants.DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
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
    
}
