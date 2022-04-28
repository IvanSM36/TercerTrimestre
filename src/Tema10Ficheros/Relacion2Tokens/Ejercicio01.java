package Tema10Ficheros.Relacion2Tokens;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ejercicio01 {

	public static void main(String[] args) {
		String[] resultado;
		String empleado = "csv/Empleados.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(empleado));
			String linea = null;
			while ((linea = br.readLine()) != null) {
				resultado = linea.split(";");
				//Recorro el array y muestro el contenido
				for(int i = 0; i <resultado.length; i++) {
					//System.out.println(resultado[i]);
				}
				resultado = linea.split(";");

				for(int i = 0; i <resultado.length; i+=2) {
					System.out.println("Nombre: " + resultado[1] + "\tEdad: " + resultado[2] );
					System.out.println();
				}
			}

		} catch (FileNotFoundException fne) {
			// TODO Auto-generated catch block
			fne.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}

	}

}
