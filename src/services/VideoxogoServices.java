package services;

import connector.DBconnector;
import model.Videoxogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// REPETIR
public class VideoxogoServices {
    public static void creacion (Videoxogo v) {
        String sql = "INSERT INTO Videoxogo (Titulo, Plataforma, AnoLanzamento, Descripcion) VALUES  (?, ?, ?, ?)";

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,v.getTitulo());
            ps.setString(2, v.getPlataforma());
            ps.setInt(3, v.getAnoLanzamento());
            ps.setString(4, v.getDescripcion());

            ps.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
// REPETIR
    public static List<Videoxogo> videoxogos () {
        String sql = "SELECT * FROM Videoxogo";
        List<Videoxogo> videoxogoList = new ArrayList<>();

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet resultado = ps.executeQuery()){
            while (resultado.next()) {
                videoxogoList.add(resultado.getString(1),
                        resultado.getString(2),
                        resultado.getInt(3),
                        resultado.getString(4)
                        )
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
