package practicaljavatwo;

import javafx.application.Application;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IDNameDatabase extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Practical Activity 3");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Calibra", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label question = new Label("Enter an ID to  display the name of the ID.");
        grid.add(question, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 0, 2);

        userTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    userTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        Button btn = new Button("Display");
        HBox hBox = new HBox(10);
        hBox.setAlignment((Pos.BASELINE_CENTER));
        hBox.getChildren().add(btn);
        grid.add(hBox, 0, 3);

        TextField display = new TextField();
        grid.add(display, 0, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userTextField.getText();

                String url = "jdbc:mysql://localhost:3306/"; // 3306 is default port
                String user = "root";
                String password = ""; // you set password when MySQL is installed

                Connection con = null; // JDBC connection
                Statement stmt = null; // SQL statement object
                ResultSet rs = null; // results after SQL execution

                try {
                    con = DriverManager.getConnection(url, user, password); // connect to MySQL
                    stmt = con.createStatement();

                    stmt.executeUpdate("DROP DATABASE activityThree;");
                    stmt.executeUpdate("CREATE DATABASE activityThree;");
                    stmt.executeUpdate("USE activityThree;");
                    stmt.executeUpdate("CREATE TABLE activityThrees (ID INTEGER NOT NULL AUTO_INCREMENT,Name VARCHAR(32), PRIMARY KEY(ID));");
                    stmt.executeUpdate("INSERT INTO activityThrees (Name) VALUES ('Takuya'),('Shota'),('Hideo'),('Naoko'),('Kenji'),('Shohei'),('Koji'),('Ben'),('Nick'),('Tanaka');");


                    PreparedStatement preStatement = (PreparedStatement) con.prepareStatement("SELECT Name FROM activityThrees WHERE ID = ?");
                    preStatement.setString(1, userTextField.getText());
                    rs = preStatement.executeQuery();

                    while (rs.next()) { // loop until the end of the results
                        String name = rs.getString("Name");
                        display.setText(name);
                    }
                } catch (SQLException ex) {
                    display.setText("SQLException caught: " + ex.getMessage());

                } catch (Exception ex) {
                    display.setText("You made a typo");
                } finally {
                    // Close all database objects nicely
                    try {
                        if (rs != null) {
                            rs.close();
                        }

                        if (stmt != null) {
                            stmt.close();
                        }

                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        display.setText("SQLException caught: " + ex.getMessage());
                    }
                }

            }
        });
        Scene scene = new Scene(grid, 500, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
