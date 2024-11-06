package com.echo.echoband.controller;

import com.echo.echoband.Training;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class TrainingController {

    @FXML private MFXButton entrenar;
    @FXML private MFXButton estadisticas;
    @FXML private MFXButton amigos;
    @FXML private MFXButton perfil;
    @FXML private MFXButton liga;
    @FXML private MFXButton config;
    @FXML private MFXButton cerrar;
    @FXML private MFXButton calor;
    @FXML private Label idNombre;
    @FXML private Label idUsuario;
    @FXML private Connection cn;
    @FXML private int num;

    public void probarActualizacionLabels() {
        Platform.runLater(() -> {
            if (idNombre != null && idUsuario != null) {
                idNombre.setText("Holaaaa");
                idUsuario.setText("juanito123");
                System.out.println("Labels actualizados correctamente.");
            } else {
                System.out.println("Los Labels no están correctamente inicializados.");
            }
        });
    }

    public void obtenerDatosPorID(Connection cn, int id) {
        idNombre.setText("Holaaaa");
        idUsuario.setText("Usuario");
        // Consulta SQL para obtener los datos del usuario
        String query = "SELECT nom_real, ap_pat, nom_usuario FROM datos_perso WHERE id_datos = ?";

        try {
            // Preparar la consulta
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, id);  // Asignamos el ID del usuario como parámetro

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Si hay resultados, los asignamos a nuestras variables
            if (rs.next()) {
                final String nombre = rs.getString("nom_real");
                final String apellidoPaterno = rs.getString("ap_pat");
                final String nombreUsuario = rs.getString("nom_usuario");
                System.out.println("Nombre: "+nombre+" "+apellidoPaterno+" "+nombreUsuario);

                // Usar Platform.runLater para actualizar la UI en el hilo de JavaFX
                Platform.runLater(() -> {
                    // Asegurarnos de que los Labels están siendo actualizados correctamente
                    if (idNombre != null && idUsuario != null) {
                        idNombre.setText(nombre + " " + apellidoPaterno);  // Actualizar el Label de nombre
                        idUsuario.setText(nombreUsuario);  // Actualizar el Label de nombre de usuario
                    } else {
                        System.out.println("Los Labels no están inicializados correctamente.");
                    }
                });

            } else {
                System.out.println("No se encontró el usuario con ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
    }

    public void irAConfig() throws IOException {
        Stage stage = (Stage) config.getScene().getWindow();
        Training app = new Training();
        app.cambiarEscena(stage, "configurationView.fxml");
        stage.setTitle("Configuración");
    }

    public void irAEntrenar() throws IOException {
        Stage stage = (Stage) entrenar.getScene().getWindow();
        Training app = new Training();
        app.cambiarEscena(stage, "trainingView.fxml");
        stage.setTitle("Entrenamiento");
    }

    public void irAEstadisticas() throws IOException {
        Stage stage = (Stage) estadisticas.getScene().getWindow();
        Training app = new Training();
        app.cambiarEscena(stage, "statisticsView.fxml");
        stage.setTitle("Estadísticas");
    }

    public void irAPerfil() throws IOException {
        Stage stage = (Stage) perfil.getScene().getWindow();
        Training app = new Training();
        app.cambiarEscena(stage, "userProfileView.fxml");
        stage.setTitle("Perfil de Usuario");
    }

    public void irALogOut() throws IOException {
        Platform.exit();
    }

    public void irACalor() throws IOException {
        Stage stage = (Stage) perfil.getScene().getWindow();
        Training app = new Training();
        app.cambiarEscena(stage, "entrarEnCalorView.fxml");
        stage.setTitle("Entrar en Calor");
    }
}
