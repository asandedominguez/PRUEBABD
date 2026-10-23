package services;

import connector.DBconnector;
import model.InventarioTenda;
import model.Videoxogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {


    public static void createInventarioTenda(InventarioTenda it) {
        String sql = "INSERT INTO InventarioTenda (IdVideoxogo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBconnector.conexion();
             PreparedStatement toInsert = conn.prepareStatement(sql))
        {
            toInsert.setInt(1, it.getIdVideoxogo());
            toInsert.setDouble(2, it.getPrezoMayorista());
            toInsert.setDouble(3, it.getPrezoVenta());
            toInsert.setInt(4, it.getPorcentaxeOferta());
            toInsert.executeUpdate();
            System.out.println("InventarioTenda pra id : " + it.getIdVideoxogo() + " inserido");

        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public static List<InventarioTenda> readInventarioTendas (){
        String sql = "SELECT * FROM InventarioTenda";
        List<InventarioTenda> toRet = new ArrayList<>();
        try (Connection conn = DBconnector.conexion();
             PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet rs = toRead.executeQuery();
        ){
            while (rs.next()) {
                toRet.add(new InventarioTenda(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro lendo da base de datos: " + e.getMessage());
        }
        return toRet;
    }

    public static InventarioTenda readInventarioPorIDXogo (int id){
        String sql = "SELECT * FROM InventarioTenda WHERE idvideoxogo = ?";
        List<InventarioTenda> toRet = new ArrayList<>();
        try (Connection conn = DBconnector.conexion();
             PreparedStatement toRead = conn.prepareStatement(sql);
        ){
            toRead.setInt(1,id);
            ResultSet rs = toRead.executeQuery();
            while (rs.next()) {
                toRet.add(new InventarioTenda(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDouble(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        )
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro lendo da base de datos: " + e.getMessage());
        }
        return toRet.getFirst();
    }


    public static void updateInventarioTenda(InventarioTenda it) {
        String sql = "UPDATE InventarioTenda SET IdVideoxogo = ?, PrezoMayorista = ?, PrezoVenta = ?, PorcentaxeOferta = ? WHERE Id = ?";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, it.getIdVideoxogo());
            ps.setDouble(2, it.getPrezoMayorista());
            ps.setDouble(3, it.getPrezoVenta());
            ps.setInt(4, it.getPorcentaxeOferta());
            ps.setInt(5, it.getId());

            int n = ps.executeUpdate();
            System.out.println("Actualizáronse " + n + "InventarioTendas");

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
