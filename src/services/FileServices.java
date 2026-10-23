package services;

import model.Videoxogo;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;
// PERFECTO
public class FileServices {
    public static void Seralizar (List<Videoxogo> videoxogos, String ruta) {
        File escritura = new File(ruta);
        try (FileOutputStream f_salida = new FileOutputStream(escritura); ObjectOutputStream o_salida = new ObjectOutputStream(f_salida)) {
            o_salida.writeObject(videoxogos);
            System.out.println("Fichero serializado en: " + ruta);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
// PERFECTO
    public static List<Videoxogo> deserializar (String ruta) {
        File escritura = new File(ruta);
        List<Videoxogo> videoxogos = null;

        try (FileInputStream f_entrada = new FileInputStream(escritura); ObjectInputStream o_entrada = new ObjectInputStream(f_entrada)) {
            videoxogos = (List<Videoxogo>) o_entrada.readObject();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return videoxogos;
    }
// REPETIR
    public static void toXML (List<Videoxogo> videoxogoList, String ruta) {
        XMLOutputFactory fabrica = XMLOutputFactory.newInstance();

        try (FileWriter f_escritura = new FileWriter(ruta) ) {
            XMLStreamWriter escribir = fabrica.createXMLStreamWriter(f_escritura);

            escribir.writeStartDocument("UTF-8", "1.0");
            escribir.writeStartElement("Videoxogos");
            escribir.writeCharacters("\n");
            escribir.writeCharacters(" ");

            for (Videoxogo v: videoxogoList) {
                escribir.writeStartElement("Id");
                escribir.writeAttribute("Id", String.valueOf(v.getId()));
                escribir.writeCharacters("\n");
                escribir.writeCharacters(" ");
                escribir.writeEndElement();

                escribir.writeStartElement("Titulo");
                escribir.writeCharacters(v.getTitulo() != null ? v.getTitulo() : "");
                escribir.writeCharacters("\n");
                escribir.writeEndElement();

                escribir.writeStartElement("Plataforma");
                escribir.writeCharacters(v.getPlataforma() != null ? v.getPlataforma() : "");
                escribir.writeCharacters("\n");
                escribir.writeEndElement();

                escribir.writeStartElement("AnoLanzamento");
                escribir.writeCharacters(String.valueOf(v.getAnoLanzamento()));
                escribir.writeCharacters("\n");
                escribir.writeEndElement();

                escribir.writeStartElement("Descripcion");
                escribir.writeCharacters(v.getDescripcion() != null ? v.getDescripcion() : "");
                escribir.writeCharacters("\n");
                escribir.writeEndElement();
            }
            escribir.writeEndElement();
            escribir.writeEndDocument();
            escribir.flush();
            escribir.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
