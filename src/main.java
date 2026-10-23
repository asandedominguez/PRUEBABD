import model.InventarioTenda;
import model.Videoxogo;
import services.FileServices;
import services.VideoxogoServices;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Videoxogo v1 = new Videoxogo("h", "r",2, "d");
        InventarioTenda i1 = new InventarioTenda(v1.getId(), 2, 3, 4);

        VideoxogoServices.Creacion(v1);
        VideoxogoServices.leer();

        List<Videoxogo> videoxogos = VideoxogoServices.leer();
        for (Videoxogo v : videoxogos) {
            System.out.println(v.getId());
        }

        FileServices.toXML(videoxogos, "fichero");
        FileServices.Seralizar(videoxogos, "hola");
        FileServices.deserializar("adios");



    }
}
