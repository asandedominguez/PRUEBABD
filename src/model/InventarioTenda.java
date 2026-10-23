package model;
// REPETIR
public class InventarioTenda {
    public int Id;
    public Integer IdVideoxogo;
    public Float PrezoMayorista;
    public Float PrezoVenta;
    public int PorcentaxeOferta;

    public InventarioTenda(Integer IdVideoxogo, Float PrezoMayorista, Float PrezoVenta, int PorcentaxeOferta) {
        this.IdVideoxogo = IdVideoxogo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public InventarioTenda(int Id, Integer IdVideoxogo, Float PrezoMayorista, Float PrezoVenta, int PorcentaxeOferta) {
        this.Id = Id;
        this.IdVideoxogo = IdVideoxogo;
        this.PrezoMayorista = PrezoMayorista;
        this.PrezoVenta = PrezoVenta;
        this.PorcentaxeOferta = PorcentaxeOferta;
    }

    public int getId() {
        return Id;
    }

    public Integer getIdVideoxogo() {
        return IdVideoxogo;
    }

    public Float getPrezoMayorista() {
        return PrezoMayorista;
    }

    public Float getPrezoVenta() {
        return PrezoVenta;
    }

    public int getPorcentaxeOferta() {
        return PorcentaxeOferta;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setIdVideoxogo(Integer idVideoxogo) {
        IdVideoxogo = idVideoxogo;
    }

    public void setPrezoMayorista(Float prezoMayorista) {
        PrezoMayorista = prezoMayorista;
    }

    public void setPrezoVenta(Float prezoVenta) {
        PrezoVenta = prezoVenta;
    }

    public void setPorcentaxeOferta(int porcentaxeOferta) {
        PorcentaxeOferta = porcentaxeOferta;
    }
}
