/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class main extends Application {

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(this.getClass().getResource("/FXML/Logowanie.fxml"));
        loader.setLocation(this.getClass().getResource("/FXML/BorderPane.fxml"));
        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Silownia");
        primaryStage.show();
    }

    public static void main(String[] args) {
       // HibernateConnection.OpenConnection();
        launch(args);
        //HibernateConnection.CloseConnection();
    }
}
