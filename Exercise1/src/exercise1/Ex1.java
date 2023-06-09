/*
------------------------------------------------------------------------------------------------------------------------
Exercise: Exercici 1
Author: Jesus Castillo Benito
Date: <fecha>
Description: Una pel·lícula es caracteritza per un títol, el nom del director i l'any d'estrena. Escriviu un
             programa que sigui capaç d'emmagatzemar tres registres d'aquest tipus dins un fitxer i després
             recuperar aquesta informació del fitxer per mostrar-la per la finestra de text.
             Plantegeu la solució emprant les classes FileWriter i FileReader.
------------------------------------------------------------------------------------------------------------------------
*/

package exercise1;

import exercise1.io.FEscritura;
import exercise1.io.FLectura;

public class Ex1 {
    //String usado para hacer saltos de linea en un fichero, proporcionado por el profesor Miquel Mascaro Portells
    private String endLine = System.getProperty("line.separator"); // == \n
    private String fichero = "peliculas.txt";

    //Metodo que arranca el programa desde fuera del metodo main para no tener que usar "static" en ciertas acciones o
    //metodos

    //Esto seria como nuestro metodo main
    private void start() {
        //Instancias de objetos de las clases FEscritura y FLectura
        FEscritura writer = new FEscritura();
        FLectura reader = new FLectura();

        //Array de objetos de la clase Pelicula
        Pelicula [] peliculas = new Pelicula[3];
        peliculas[0] = new Pelicula("Torrente, el brazo tonto de la ley","Santiago Segura", 1998);
        peliculas[1] = new Pelicula("Iron Man","Jon Favreau", 2008);
        peliculas[2] = new Pelicula("Coco","Adrian Molina", 2017);

        writer.abrirEscritura(fichero);
        //Bucle que recorre el array de objetos de la clase Pelicula y escribe en el fichero los datos de cada objeto
        for (int i = 0; i < peliculas.length; i++) {
            writer.escribir("Titulo: " + peliculas[i].getTitulo() + " | Director:" + peliculas[i].getDirector() +
            " | Estreno: " + peliculas[i].getFecha() + endLine);
        }
        writer.cerrarEscritura();

        reader.abrirLectura(fichero);
        reader.leer();
        reader.cerrarLectura();
    }

    public static void main(String[] args) {
        new Ex1().start();
    }
}
