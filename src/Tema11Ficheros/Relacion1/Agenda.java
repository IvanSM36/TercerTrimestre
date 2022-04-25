package Tema11Ficheros.Relacion1;

import java.util.ArrayList;

public class Agenda {

	// Atributo
	private ArrayList<Contacto> listaContactos;

	// Constructores
	public Agenda() {

	}

	public Agenda(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	// Getters and Setters
	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	// Metodos

	public void agregarContacto(Contacto c) {
		listaContactos.add(c);
	}

	public void eliminarContacto(Contacto c) {
		listaContactos.remove(c);
	}

	public void mostrarContactos() {
		for(int i = 0; i < listaContactos.size(); i++) {
			System.out.println(listaContactos.toString());
		}
	}

}
