/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package sql;

import app.DesktopAdminDashboard;
import app.Profile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author londo
 */
public class Login {
    
    
    public static Profile login(String username, String password) {
        DatabaseManager manager = new DatabaseManager();
        manager.connect();
        System.out.println("Connected");
        Profile profile = null;
            try {
                
                String query = "SELECT * FROM users WHERE email=? AND password=?";
                PreparedStatement statement = manager.connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);



                ResultSet info = manager.query(statement);

                while (info.next()) {
                    profile = new Profile(info.getInt("id"), info.getString("email"), info.getString("userType"));
                    System.out.println("Found account");
                }

            } catch (SQLException ex) {
                Logger.getLogger(DesktopAdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                manager.disconnect();
            }
               
            manager.disconnect();
            return profile;
    }
}
