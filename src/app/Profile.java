/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package app;

/**
 *
 * @author Callum Bass <w1682693>
 */
public class Profile {
    
    int id;
    String email;
    String userType;
    
    public Profile(int id, String email, String userType) {
        this.id = id;
        this.email = email;
        this.userType = userType;
    }
    
    public boolean isLoggedIn() {
        if (this == null)
            return false;
        return true;
    }
    
}
