package base.shipsys;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Scene scene1,scene2,scene3,scene4;
    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ports.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 500, 250);
        stage.setTitle("Shipping System");
        stage.setScene(scene1);
        stage.show();
        fxmlLoader = new FXMLLoader(Main.class.getResource("containerShip.fxml"));
        scene2 = new Scene(fxmlLoader.load(), 500, 250);
/*
        fxmlLoader = new FXMLLoader(Main.class.getResource("container.fxml"));
        scene3 = new Scene(fxmlLoader.load(), 500, 250);

        fxmlLoader = new FXMLLoader(Main.class.getResource("pallet.fxml"));
        scene4 = new Scene(fxmlLoader.load(), 500, 250);
    }
    */
    }

    public static void main(String[] args) {
        launch();
    }
}