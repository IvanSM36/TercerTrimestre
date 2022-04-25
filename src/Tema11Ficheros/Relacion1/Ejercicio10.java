package Tema11Ficheros.Relacion1;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Agenda miAgenda = new Agenda();

		int opcion = 0;
		
		do {
			System.out.println("┌─────────────────────────────────────────┐");
			System.out.println("│  1º Añadir contacto. (nombre, telefono) |");
			System.out.println("│  2º Eliminar contacto.                  │");
			System.out.println("│  3º Mostrar todos los contactos.        │");
			System.out.println("│  0º Salir.                              │");
			System.out.println("└─────────────────────────────────────────┘");
			
			System.out.print("Introduzca una opcion: ");
			opcion = scan.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.print("Introduzca nombre del contacto: ");
				String nombre = scan.next();
				System.out.print("Introduzca numero de telefono: ");
				int numero = scan.nextInt();
				miAgenda.agregarContacto(new Contacto(nombre, numero));
				break;
			case 2:
				
				break;
			case 3:
				
				break;

			default:
				System.out.println("Introduzca una opcion entre 0-3");
				break;
			}
			
			
		}while(opcion !=0);
		
		

	}

}
