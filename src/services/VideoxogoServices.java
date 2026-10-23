package services;

import connector.DBconnector;
import model.Videoxogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// PERFECTO
public class VideoxogoServices {
    public static void Creacion (Videoxogo v) {
        String sql = "INSERT INTO Videoxogo (Titulo, Plataforma, AnoLanzamento, Descripcion) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, v.getTitulo());
            ps.setString(2, v.getPlataforma());
            ps.setInt(3, v.getAnoLanzamento());
            ps.setString(4, v.getDescripcion());

            ps.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
// PERFECTO
    public static List<Videoxogo> leer () {
        String sql = "SELECT * FROM Videoxogo";
        List<Videoxogo> videoxogos = new ArrayList<>();

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet resultado = ps.executeQuery()) {

            while(resultado.next()) {
                videoxogos.add(new Videoxogo(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getInt(4),
                        resultado.getString(5)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return videoxogos;
    }
// PERFECTO
    public static List<Videoxogo> leerFiltro (String Titulo) {
        String sql = "SELECT * FROM Videoxogo WHERE Titulo = ?";
        List<Videoxogo> videoxogos = new ArrayList<>();

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, Titulo);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                videoxogos.add(new Videoxogo(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getInt(4),
                        resultado.getString(5)));
            }
            resultado.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return videoxogos;
    }

    public static void Actualizar (Videoxogo videoxogo) {
        String sql = "UPDATE Videoxogo INTO Id = ?, Titulo = ?, Plataforma = ?, AnoLanzamento = ?, Descripcion = ? WHERE Id= ?";

        try (Connection conn = DBconnector.conexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,videoxogo.getId());
            ps.setString(2, videoxogo.getTitulo());
            ps.setString(3, videoxogo.getPlataforma());
            ps.setInt(4, videoxogo.getAnoLanzamento());
            ps.setString(5, videoxogo.getDescripcion());

            int n = ps.executeUpdate();
            System.out.println(n + " líneas modificadas");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
