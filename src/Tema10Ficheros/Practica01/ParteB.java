package Tema10Ficheros.Practica01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParteB {

	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File("xml/Arboles.xml"));
			String valor =loopNodeXml(documento.getDocumentElement());

			BufferedWriter bw = new BufferedWriter(new FileWriter("src/Tema11Ficheros/Ficheros/nodos.txt"));
			bw.write("valor" + valor);
			bw.close();


		} catch (ParserConfigurationException pce) {
			// TODO Auto-generated catch block
			pce.printStackTrace();
		} catch (SAXException saxe) {
			// TODO Auto-generated catch block
			saxe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}

	}

	public static String loopNodeXml(Node n) {
		String valor = " ";

		// Obtenemos sus hijos
		NodeList hijos = n.getChildNodes();
		for (int i = 0; i < hijos.getLength(); i++) {
			// Obtenemos el hijo i
			Node hijo = hijos.item(i);

			// Si es un nodo
			if (hijo.getNodeType() == Node.ELEMENT_NODE) {

				// Recorremos el hijo recursivamente
				loopNodeXml(hijo);
				// Atributos
				if (hijo.getAttributes() != null && hijo.getAttributes().getLength() > 0) {
					NamedNodeMap atributos = hijo.getAttributes();
					for (int j = 0; j < atributos.getLength(); j++) {
						Node attr = atributos.item(j);
						// Recorremos el atributo recursivamente
						loopNodeXml(attr);
					}
				}

				// si el nodo es un texto y no esta vacio
			} else if (hijo.getNodeType() == Node.TEXT_NODE && !hijo.getTextContent().trim().isEmpty()) {
				// Mostramos el contenido
				valor = hijo.getTextContent();
				System.out.println("Valor: " + valor);
			}

		}
		return valor;
	}
}
