package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import seb.ui.Sebastian;

/**
 * A GUI for Seb using FXML.
 */
public class Main extends Application {

    private Sebastian sebastian = new Sebastian("./data/Sebastian.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("Sebastian");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setSeb(sebastian);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
