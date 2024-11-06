package com.echo.echoband;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Memory extends Application {
    private SerialReader serialReader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/echo/echoband/memoryView.fxml"));
        AnchorPane root = loader.load();

        Scene scene = new Scene(root, 1500, 700);
        scene.getStylesheets().add(Training.class.getResource("memoryStyle.css").toExternalForm());
        primaryStage.setMinWidth(1500);
        primaryStage.setMinHeight(700);
        primaryStage.setFullScreen(true);
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Entrenar");

        primaryStage.show();

        // Crear instancia de SerialReader e iniciar recepción de datos
        serialReader = new SerialReader();
        serialReader.comenzarARecibirDatos(); // Inicia la lectura de datos
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (serialReader != null) {
            serialReader.cerrarConexion(); // Cierra la conexión cuando se cierra la aplicación
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
