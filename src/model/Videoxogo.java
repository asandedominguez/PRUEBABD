package model;

import java.io.Serializable;
// REPETIR
public class Videoxogo implements Serializable {

    public int Id;
    public String Titulo;
    public String Plataforma;
    public int AnoLanzamento;
    public String Descripcion;

    public Videoxogo(String Titulo, String Plataforma, int AnoLanzamento, String Descripcion) {
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzamento;
        this.Descripcion = Descripcion;
    }

    public Videoxogo(int Id, String Titulo, String Plataforma, int AnoLanzamento, String Descripcion) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzamento;
        this.Descripcion = Descripcion;
    }

    public int getId() {
        return Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public int getAnoLanzamento() {
        return AnoLanzamento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setPlataforma(String plataforma) {
        Plataforma = plataforma;
    }

    public void setAnoLanzamento(int anoLanzamento) {
        AnoLanzamento = anoLanzamento;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
