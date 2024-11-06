package com.echo.echoband.controller;

import com.echo.echoband.Statistics;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StatisticsController {

    @FXML private MFXButton entrenar;
    @FXML private MFXButton estadisticas;
    @FXML private MFXButton amigos;
    @FXML private MFXButton perfil;
    @FXML private MFXButton liga;
    @FXML private MFXButton config;
    @FXML private MFXButton cerrar;

    @FXML private LineChart<Number, Number> lineChart;
    @FXML private NumberAxis xAxis;
    @FXML private NumberAxis yAxis;
    @FXML private BarChart<String, Number> barChart;
    @FXML private CategoryAxis xAxisBar;

    // Método para recibir y procesar el array de datos
    public void setData(ArrayList<Integer> data) {
        // Configurar la serie para la gráfica
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        // Población de la serie con los datos del array
        for (int i = 0; i < data.size(); i++) {
            series.getData().add(new XYChart.Data<>(i, data.get(i)));
        }

        // Añadir la serie a la gráfica
        lineChart.getData().add(series);
    }

    public void irAConfig() throws IOException {
        Stage stage = (Stage) config.getScene().getWindow();
        Statistics app = new Statistics();
        app.cambiarEscena(stage, "configurationView.fxml");
        stage.setTitle("Configuración");
    }

    public void irAEntrenar() throws IOException {
        Stage stage = (Stage) entrenar.getScene().getWindow();
        Statistics app = new Statistics();
        app.cambiarEscena(stage, "trainingView.fxml");
        stage.setTitle("Entrenamiento");
    }

    public void irAEstadisticas() throws IOException {
        Stage stage = (Stage) estadisticas.getScene().getWindow();
        Statistics app = new Statistics();
        app.cambiarEscena(stage, "statisticsView.fxml");
        stage.setTitle("Estadísticas");
    }

    public void irAPerfil() throws IOException {
        Stage stage = (Stage) perfil.getScene().getWindow();
        Statistics app = new Statistics();
        app.cambiarEscena(stage, "userProfileView.fxml");
        stage.setTitle("Perfil de Usuario");
    }

    public void irALogOut() throws IOException {
        Platform.exit();
    }

    @FXML
    public void initialize(ArrayList<Integer> data) {
        double promedio = calcularPromedio(data);

        xAxis.setLabel("Tiempo (segundos)");
        yAxis.setLabel("Nivel de Concentración");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Concentración");

        for (int i = 0; i < data.size(); i++) {
            series.getData().add(new XYChart.Data<>(i + 1, data.get(i)));
        }

        lineChart.getData().add(series);

        XYChart.Series<Number, Number> promedioSeries = new XYChart.Series<>();
        promedioSeries.setName("Promedio");

        for (int i = 1; i <= data.size(); i++) {
            promedioSeries.getData().add(new XYChart.Data<>(i, promedio));
        }

        lineChart.getData().add(promedioSeries);

        XYChart.Series<String, Number> seriesBar1 = new XYChart.Series<>();
        seriesBar1.setName("Focalización Visual");
        seriesBar1.getData().add(new XYChart.Data<>("Focalización Visual", 81.57));

        XYChart.Series<String, Number> seriesBar2 = new XYChart.Series<>();
        seriesBar2.setName("Desafíos con amigos");
        seriesBar2.getData().add(new XYChart.Data<>("Desafíos con amigos", 63.25));

        XYChart.Series<String, Number> seriesBar3 = new XYChart.Series<>();
        seriesBar3.setName("Focalización general");
        seriesBar3.getData().add(new XYChart.Data<>("Focalización general", 52.95));

        XYChart.Series<String, Number> seriesBar4 = new XYChart.Series<>();
        seriesBar4.setName("Concentración real");
        seriesBar4.getData().add(new XYChart.Data<>("Concentración real", 47.29));

        barChart.getData().addAll(seriesBar1, seriesBar2, seriesBar3, seriesBar4);

        Platform.runLater(() -> {
            barChart.getScene().getStylesheets().add(getClass().getResource("statisticsStyle.css").toExternalForm());
        });

        barChart.setBarGap(-80);
        barChart.setCategoryGap(0);

        barChart.setMinWidth(675);
        barChart.setMaxWidth(675);
    }

    private double calcularPromedio(ArrayList<Integer> data) {
        double suma = 0;
        for (int valor : data) {
            suma += valor;
        }
        return suma / data.size();
    }
}
