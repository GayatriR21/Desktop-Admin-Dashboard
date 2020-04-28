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
public class Register {
    
    public static boolean register(String username, String password, String confirm) {
        
        if (!password.equals(confirm))
            return false;
        
        DatabaseManager manager = new DatabaseManager();
        manager.connect();
        System.out.println("Connected");
            try {
                
                String query = "INSERT INTO users VALUES (NULL, '" + username + "', '" + password + "', 'user')";

                manager.connection.createStatement().execute(query);

       

            } catch (SQLException ex) {
                Logger.getLogger(DesktopAdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                manager.disconnect();
                return false;
            }
               
            manager.disconnect();
            return true;
    }
}
