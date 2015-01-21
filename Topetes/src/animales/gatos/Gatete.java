package animales.gatos;

import animales.Animal;
import animales.jlabels.JLabelGatete;

//import animales.jlabels.*;

public class Gatete extends Animal {

	protected int posX; // Posicion en el eje de las X de la cuadricula
	protected int posY; // Posicion en el eje de las Y de la cuadricula
	protected final int ANCHO_CUADRICULA = 3; // Ancho de la cuadricula
	protected final int ALTO_CUADRICULA = 4; // Alto de la cuadricula

	/**
	 * Constructor de la clase gatete, crea un gato accediendo al constructor de
	 * la clase padre Animal
	 * 
	 */
	public Gatete() {
		super();
		img = new JLabelGatete();
	}

	/**
	 * Metodo que mata el gato y devuelve true para acabar la partida
	 * 
	 * @return
	 */
	public boolean mataGato() {
		return true;
	}

	@Override
	public String toString() {
		return "Gato: " + super.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 60; i++) {
			Gatete g = new Gatete();
			System.out.println(g);
		}
	}
}