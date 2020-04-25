/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sql.DatabaseManager;

/**
 *
 * @author londo
 */
public class DesktopAdminDashboard extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        TextField textField = new TextField();
        Label label = new Label();
        
        
        btn.setText("Get Password");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                DatabaseManager manager = new DatabaseManager();
                manager.connect();
                try {
                    System.out.println(textField.getText());
                    String query = "SELECT * FROM users WHERE email=?";
                    PreparedStatement statement = manager.connection.prepareStatement(query);
                    statement.setString(1, textField.getText());
                    
                    
                    
                    ResultSet info = manager.query(statement);
                    
                    while (info.next()) {
                    System.out.println("Row: " + info.getString("password"));
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DesktopAdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                manager.disconnect();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(textField);
        root.getChildren().add(btn);
        root.getChildren().add(label);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
