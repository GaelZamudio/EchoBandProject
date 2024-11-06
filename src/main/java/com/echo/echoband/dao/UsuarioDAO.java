package com.echo.echoband.dao;

import com.echo.echoband.connection.DatabaseConnection;
import com.echo.echoband.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean insert(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (id_usuario, foto, nom_usuario) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setBytes(2, usuario.getFoto());
            stmt.setString(3, usuario.getNomUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public Usuario findById(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getBytes("foto"),
                        rs.getString("nom_usuario")
                );
            }
        }
        return null;
    }

    public List<Usuario> findAll() throws SQLException {
        String query = "SELECT * FROM usuario";
        List<Usuario> usuarioList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarioList.add(new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getBytes("foto"),
                        rs.getString("nom_usuario")
                ));
            }
        }
        return usuarioList;
    }

    public boolean update(Usuario usuario) throws SQLException {
        String query = "UPDATE usuario SET foto = ?, nom_usuario = ? WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBytes(1, usuario.getFoto());
            stmt.setString(2, usuario.getNomUsuario());
            stmt.setInt(3, usuario.getIdUsuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}

