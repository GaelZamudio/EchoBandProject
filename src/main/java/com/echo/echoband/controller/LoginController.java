package com.echo.echoband.controller;

import com.echo.echoband.LogIn;
import com.echo.echoband.connection.DatabaseConnection;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private DatabaseConnection databaseConnection;
    private Connection cn;

    @FXML private Text txtcrear;
    @FXML private MFXTextField fieldusuario;
    @FXML private MFXPasswordField fieldcontrasena;
    @FXML private Label labelusuario;
    @FXML private Label labelcontrasena;
    @FXML private MFXButton botoniniciar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BooleanBinding camposValidos =(fieldusuario.textProperty().isNotEmpty())
                .and(fieldcontrasena.textProperty().isNotEmpty());

        botoniniciar.disableProperty().bind(camposValidos.not());
    }

    @FXML
    public void irAMenu() {
        try {
            Stage stage = (Stage) botoniniciar.getScene().getWindow();
            LogIn app = new LogIn();
            stage.setTitle("Entrenamiento");

            app.cambiarEscena(stage, "/com/echo/echoband/trainingView.fxml");

            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(LogIn.class.getResource("/com/echo/echoband/trainingStyle.css").toExternalForm());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar trainingView.fxml");
        }
    }

    public void irASignUp() throws IOException {
        Stage stage = (Stage) txtcrear.getScene().getWindow();
        LogIn app = new LogIn();
        app.cambiarEscena(stage, "signUpView.fxml");
        stage.setTitle("Sign Up");
    }

    //Métodos para la BD
    @FXML
    public void ingresar(){
        String usuario = fieldusuario.getText();
        String contrasena = fieldcontrasena.getText();

        if(!usuario.isEmpty() && !contrasena.isEmpty()){
            try{
                databaseConnection = new DatabaseConnection();
                cn = databaseConnection.getConnection();

                PreparedStatement ps = cn.prepareStatement("SELECT nom_real, ap_pat, nom_usuario\n" +
                        "FROM datos_perso\n" +
                        "WHERE nom_usuario = '"+usuario+"' AND contraseña = '"+contrasena+"';");


                // Obtener el ID del usuario recién creado
                String obtID = "SELECT id_datos FROM datos_perso WHERE nom_usuario = '"+usuario+"';";
                PreparedStatement ps2 = cn.prepareStatement(obtID);
                ps2.setString(1, usuario);  // Utilizamos PreparedStatement para evitar inyecciones SQL
                ResultSet rs = ps2.executeQuery();

                if (rs.next()) {  // Asegurarse de que haya un resultado antes de acceder a él
                    int num = rs.getInt("id_datos");
                    System.out.println("ID: " + num);
                } else {
                    System.out.println("No se encontró el ID del usuario.");
                }
                ResultSet rs1 = ps.executeQuery();
                if(rs1.next()){
                    String datos[] = new String[]{rs1.getString("nom_real"),
                            rs1.getString("ap_pat"),
                            rs1.getString("nom_usuario")};
                    System.out.println("Hola de nuevo "+datos[2]);
                    System.out.println("Perfil de "+datos[0]+" "+datos[1]);
                    irAMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión: "+e.getMessage());
            } finally {
                databaseConnection.cerrarConexion();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar los campos este cawn");
        }
    }
}
