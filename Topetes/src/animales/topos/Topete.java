package animales.topos;

import excepciones.FueraDeCuadricula;
import animales.Animal;

/** Clase para definir instancias lógicas de topos con posición y puntos.
 * @author Gaizka
 *
 */
public class Topete extends Animal{
	
	protected int puntos;  	// Puntos que otorga matar al topo	
	
	
	/** Constructor de la clase, crea un topo con 10 de puntuacion,
	 *  la imagen caracteristica y una posicion aleatoria en la cuadricula
	 * 
	 */
	public Topete() {
		super();
		puntos = 10;
	}

	/** Metodo para obtener el numero de puntos que da matar al topo
	 * @return Puntos que vale el topo
	 */
	public double getPuntos() {
		return puntos;
	}

	/** Metodo para cambiar el valor de un topo
	 * @param puntos Nuevo valor para los puntos del topo
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/** Metodo que permite matar al topo y sumar la puntuacion del topo a la puntuacion total
	 * @param puntuacionActual Puntuacion actual de la partida
	 * @return Puntuacion despues de matar al topo (Puntuacion anterior + valor del topo)
	 */
	public int mataTopo( int puntuacionActual){
		return puntos + puntuacionActual;
	}
	
	@Override
	public String toString() {
		return "Topo: "+super.toString();
	}
	
	public static void main(String[] args) {
		Topete t1 = new Topete();
		System.out.println(t1);			
		System.out.println("Posicion X del topete: "+t1.getPosX());
		try {
			t1.setPosX(9);
		} catch (FueraDeCuadricula e) {
			System.out.println("Fuera de la cuadricula");
			e.printStackTrace();
		}
		try {
			t1.setPosX(2);
		} catch (FueraDeCuadricula e) {
			System.out.println("Fuera de la cuadricula");
			e.printStackTrace();
		}
		System.out.println(t1);
	}

}
