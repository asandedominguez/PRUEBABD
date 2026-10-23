package model;
// REPETIR
public class InventarioTenda {
    private int id;
    private int idVideoxogo;
    private double prezoMayorista;
    private double prezoVenta;
    private int porcentaxeOferta;

    public InventarioTenda(int idVideoxogo, double prezoMayorista, double prezoVenta, int porcentaxeOferta) {
        this.idVideoxogo = idVideoxogo;
        this.prezoMayorista = prezoMayorista;
        this.prezoVenta = prezoVenta;
        this.porcentaxeOferta = porcentaxeOferta;
    }
    public InventarioTenda(int id, int idVideoxogo, double prezoMayorista, double prezoVenta, int porcentaxeOferta) {
        this.id = id;
        this.idVideoxogo = idVideoxogo;
        this.prezoMayorista = prezoMayorista;
        this.prezoVenta = prezoVenta;
        this.porcentaxeOferta = porcentaxeOferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrezoMayorista() {
        return prezoMayorista;
    }

    public void setPrezoMayorista(double prezoMayorista) {
        this.prezoMayorista = prezoMayorista;
    }

    public double getPrezoVenta() {
        return prezoVenta;
    }

    public void setPrezoVenta(double prezoVenta) {
        this.prezoVenta = prezoVenta;
    }

    public int getPorcentaxeOferta() {
        return porcentaxeOferta;
    }

    public void setPorcentaxeOferta(int porcentaxeOferta) {
        this.porcentaxeOferta = porcentaxeOferta;
    }

    public int getIdVideoxogo() {
        return idVideoxogo;
    }

    public void setIdVideoxogo(int idVideoxogo) {
        this.idVideoxogo = idVideoxogo;
    }
}