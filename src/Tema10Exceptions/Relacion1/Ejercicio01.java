package Tema10Exceptions.Relacion1;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int aux = 0;
		
		for (int i = 0; i < 6; i++) {
			System.out.print("Introduzca un numero: ");
			int num = scan.nextInt();		
		
			if(aux < num)
				aux = num;
		}
		
		System.out.println("El numero maximo es: " + aux);

	}

}
