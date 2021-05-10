package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.beans.EventHandler;

public class Main extends Application {
    Controller theController;





    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception{
        saveData();
    }

    public void saveData() {
        Athlete.save();
        TwentyTwentyAthlete.save();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
