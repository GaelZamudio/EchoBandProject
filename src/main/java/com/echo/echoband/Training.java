package com.echo.echoband;

import com.echo.echoband.controller.TrainingController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class Training extends Application {
    private Connection cn;
    private int num;


    public void cambiarEscena(Stage stage, String vistaFXML) throws IOException {
        FXMLLoader cargador = new FXMLLoader(getClass().getResource(vistaFXML));
        AnchorPane root = cargador.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("configurationStyle.css").toExternalForm());
        stage.setScene(scene);

        stage.setFullScreen(true);
        stage.centerOnScreen();
    }



    @Override
    public void start(Stage stage) throws IOException {
        cambiarEscena(stage, "trainingView.fxml");

        stage.setTitle("Entrenar");
        stage.setMinWidth(1500);
        stage.setMinHeight(700);
        stage.centerOnScreen();
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
