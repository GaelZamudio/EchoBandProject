package com.echo.echoband.dao;

import com.echo.echoband.connection.DatabaseConnection;
import com.echo.echoband.model.DatosPerso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosPersoDAO {
    public boolean insert(DatosPerso datos) throws SQLException {
        String query = "INSERT INTO datos_perso (nom_real, nom_usuario, ap_pat, ap_mat, contraseña, correo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, datos.getNomReal());
            stmt.setString(2, datos.getNomUsuario());
            stmt.setString(3, datos.getApPat());
            stmt.setString(4, datos.getApMat());
            stmt.setString(5, datos.getContraseña());
            stmt.setString(6, datos.getCorreo());
            return stmt.executeUpdate() > 0;
        }
    }

    public DatosPerso findById(int id) throws SQLException {
        String query = "SELECT * FROM datos_perso WHERE id_datos = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DatosPerso(
                        rs.getInt("id_datos"),
                        rs.getString("nom_real"),
                        rs.getString("nom_usuario"),
                        rs.getString("ap_pat"),
                        rs.getString("ap_mat"),
                        rs.getString("contraseña"),
                        rs.getString("correo")
                );
            }
        }
        return null;
    }

    public List<DatosPerso> findAll() throws SQLException {
        String query = "SELECT * FROM datos_perso";
        List<DatosPerso> datosList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                datosList.add(new DatosPerso(
                        rs.getInt("id_datos"),
                        rs.getString("nom_real"),
                        rs.getString("nom_usuario"),
                        rs.getString("ap_pat"),
                        rs.getString("ap_mat"),
                        rs.getString("contraseña"),
                        rs.getString("correo")
                ));
            }
        }
        return datosList;
    }

    public boolean update(DatosPerso datos) throws SQLException {
        String query = "UPDATE datos_perso SET nom_real = ?, nom_usuario = ?, ap_pat = ?, ap_mat = ?, contraseña = ?, correo = ? WHERE id_datos = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, datos.getNomReal());
            stmt.setString(2, datos.getNomUsuario());
            stmt.setString(3, datos.getApPat());
            stmt.setString(4, datos.getApMat());
            stmt.setString(5, datos.getContraseña());
            stmt.setString(6, datos.getCorreo());
            stmt.setInt(7, datos.getIdDatos());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM datos_perso WHERE id_datos = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
