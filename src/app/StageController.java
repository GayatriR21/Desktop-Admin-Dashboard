/*
 * Name: Callum Bass
 * Student ID: w1682693
 * Software Development - Group Project
 */
package app;

import static app.DesktopAdminDashboard.profile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sql.Login;

/**
 *
 * @author Callum Bass <w1682693>
 */
public class StageController {
    
    Stage stage;
    Scene scene;
    BorderPane border;
    
    public StageController() {
        
    }
    
    
    public void initializeBorder() {
      this.border = new BorderPane();
    }
    
    public void setMainMenuScene() {
        initializeBorder();
        HBox hbox = createHBox();
        border.setTop(hbox);
        border.setLeft(createVBox());
        //addStackPane(hbox);         // Add stack to HBox in top region

        border.setCenter(createLoginPane());
    }
    
    public void updateScene() {
        this.scene = new Scene(this.border, 800, 600);
    }
    
    public void updateStage() {
        this.stage.setScene(this.scene);
    }
    
    public void update() {
        updateScene();
        updateStage();
    }
    
    
    
    public VBox createVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.setMinWidth(100);
        vbox.setStyle("-fx-background-color: #FFFFFF;");

        Text title = new Text("Graphs");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
            new Hyperlink("Sales"),
            new Hyperlink("Marketing"),
            new Hyperlink("Distribution"),
            new Hyperlink("Costs")};

        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }

    return vbox;
}
    
    public HBox createAdminPanel() {
        HBox hbox = new HBox();
    hbox.setAlignment(Pos.CENTER);
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #d4d4d4;");

    Button buttonCurrent = new Button("Activity Log");
    buttonCurrent.setPrefSize(100, 20);

    Button buttonProjected = new Button("Data Editor");
    buttonProjected.setPrefSize(100, 20);
    
    Button buttonSearch = new Button("Search");
    buttonProjected.setPrefSize(100, 20);
    
    hbox.getChildren().addAll(buttonCurrent, buttonProjected, buttonSearch);

    return hbox;
    }
    
    public HBox createHBox() {
    HBox hbox = new HBox();
    hbox.setAlignment(Pos.CENTER_RIGHT);
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);
    hbox.setStyle("-fx-background-color: #d4d4d4;");

    Button buttonCurrent = new Button("Login");
    buttonCurrent.setPrefSize(100, 20);

    Button buttonProjected = new Button("Register");
    buttonProjected.setPrefSize(100, 20);
    hbox.getChildren().addAll(buttonCurrent, buttonProjected);

    return hbox;
}
    public GridPane createLoginPane() {
        GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(12);
    grid.setAlignment(Pos.CENTER);

    HBox hbButtons = new HBox();
    hbButtons.setSpacing(10.0);
    
    



ColumnConstraints column1 = new ColumnConstraints();
column1.setHalignment(HPos.RIGHT);
grid.getColumnConstraints().add(column1); 

ColumnConstraints column2 = new ColumnConstraints();
column2.setHalignment(HPos.LEFT);
grid.getColumnConstraints().add(column2); 


    Button btnSubmit = new Button("Submit");
    Button btnClear = new Button("Clear");
    Button btnExit = new Button("Exit");
    btnSubmit.setStyle("-fx-font-size: 15pt;");

    Label lblName = new Label("User name:");
    TextField tfName = new TextField();
    Label lblPwd = new Label("Password:");
    PasswordField pfPwd = new PasswordField();

    hbButtons.getChildren().addAll(btnSubmit, btnClear, btnExit);
    grid.add(lblName, 0, 0);
    grid.add(tfName, 1, 0);
    grid.add(lblPwd, 0, 1);
    grid.add(pfPwd, 1, 1);
    grid.add(hbButtons, 0, 2, 2, 1);
    
    btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        profile = Login.login(tfName.getText(), pfPwd.getText());
        if (!ProfileManager.isLoggedIn()){
            alert("Error", "Sorry, there was an issue logging you in!");
        } else {
            alert("Success", "You have been logged in!");
            border.setBottom(createAdminPanel());
            update();
        }
        
    }
    
    
});
    
    
    btnClear.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        tfName.setText("");
        pfPwd.setText("");
       
    }
});
    
    return grid;
    }
    
    
    public void alert(String title, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(title);
    alert.setContentText(description);
    alert.showAndWait();
    }
    
}
