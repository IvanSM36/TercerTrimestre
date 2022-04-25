package Tema11Ficheros.Relacion1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio09 {

	public static void main(String[] args) {
		
		/*  if (args.length != 2) {
		      System.out.println("Uso del programa: FichEjercicio06 FICHERO PALABRA");
		      System.exit(-1);
		    }*/
		        
		  try {
			  BufferedReader br = new BufferedReader(new FileReader(args[0]));
		      String palabra = "a";
		      String linea = "";
		      int i = 0;
		      int repeticiones = 0;
		      
		      while ((linea = br.readLine()) != null) {
		        
		        while ((i = linea.indexOf(palabra)) != -1) {
		          linea = linea.substring(i + palabra.length(), linea.length());
		          repeticiones++;
		        }
		      }
		      
		      br.close();
		      
		      System.out.println("La palabra " + palabra + " aparece " + repeticiones + " veces en el fichero.");
			} catch (FileNotFoundException fnfe) {
				System.out.println("No se encuentra el fichero.");
			} catch (IOException ioe) {
				System.out.println("No se puede leer el fichero.");
			}
	}

}
