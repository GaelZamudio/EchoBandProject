package com.echo.echoband.dao;

import com.echo.echoband.connection.DatabaseConnection;
import com.echo.echoband.model.Logro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogroDAO {
    public boolean insert(Logro logro) throws SQLException {
        String query = "INSERT INTO logro (id_logro, porcentaje_usua, categoria, desc_logr, fecha_logr) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, logro.getIdLogro());
            stmt.setInt(2, logro.getPorcentajeUsua());
            stmt.setString(3, logro.getCategoria());
            stmt.setString(4, logro.getDescLogr());
            stmt.setTimestamp(5, Timestamp.valueOf(logro.getFechaLogr()));
            return stmt.executeUpdate() > 0;
        }
    }

    public Logro findById(int id) throws SQLException {
        String query = "SELECT * FROM logro WHERE id_logro = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Logro(
                        rs.getInt("id_logro"),
                        rs.getInt("porcentaje_usua"),
                        rs.getString("categoria"),
                        rs.getString("desc_logr"),
                        rs.getTimestamp("fecha_logr").toLocalDateTime()
                );
            }
        }
        return null;
    }

    public List<Logro> findAll() throws SQLException {
        String query = "SELECT * FROM logro";
        List<Logro> logroList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                logroList.add(new Logro(
                        rs.getInt("id_logro"),
                        rs.getInt("porcentaje_usua"),
                        rs.getString("categoria"),
                        rs.getString("desc_logr"),
                        rs.getTimestamp("fecha_logr").toLocalDateTime()
                ));
            }
        }
        return logroList;
    }

    public boolean update(Logro logro) throws SQLException {
        String query = "UPDATE logro SET porcentaje_usua = ?, categoria = ?, desc_logr = ?, fecha_logr = ? WHERE id_logro = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, logro.getPorcentajeUsua());
            stmt.setString(2, logro.getCategoria());
            stmt.setString(3, logro.getDescLogr());
            stmt.setTimestamp(4, Timestamp.valueOf(logro.getFechaLogr()));
            stmt.setInt(5, logro.getIdLogro());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM logro WHERE id_logro = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
