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
// PERFECTO
    public static void toXML (List<Videoxogo> videoxogos, String ruta) {
        XMLOutputFactory fabrica = XMLOutputFactory.newInstance();

        try {
            FileWriter fichero = new FileWriter(ruta);
            XMLStreamWriter creacion = fabrica.createXMLStreamWriter(fichero);

            creacion.writeStartDocument("UTF-8", "1.0");
            creacion.writeStartElement("Videoxogos");
            creacion.writeCharacters("\n");

            for (Videoxogo v : videoxogos) {
                creacion.writeStartElement("Videoxogo");
                creacion.writeAttribute("id", String.valueOf(v.getId()));
                creacion.writeCharacters("\n");

                creacion.writeStartElement("Titulo");
                creacion.writeCharacters(v.getTitulo() != null ? v.getTitulo() : "");
                creacion.writeCharacters("\n");
                creacion.writeEndElement();

                creacion.writeStartElement("Plataforma");
                creacion.writeCharacters(v.getPlataforma() != null ? v.getPlataforma() : "");
                creacion.writeCharacters("\n");
                creacion.writeEndElement();

                creacion.writeStartElement("AnoLanzamento");
                creacion.writeCharacters(String.valueOf(v.getAnoLanzamento()));
                creacion.writeCharacters("\n");
                creacion.writeEndElement();

                creacion.writeStartElement("Descripcion");
                creacion.writeCharacters(v.getDescripcion() != null ? v.getDescripcion() : "");
                creacion.writeCharacters("\n");
                creacion.writeEndElement();

                creacion.writeEndElement();

            }
            creacion.writeEndElement();
            creacion.writeEndDocument();
            creacion.flush();
            creacion.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
