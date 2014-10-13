package animales;

import java.util.Random;

import excepciones.FueraDeCuadricula;

/** Clase padre de todos los animales del juego
 * Tiene los metodos basicos que comparten todos los animales
 * como getPosX o getPosY
 * @author Gaizka
 *
 */
public abstract class Animal {

	protected int posX;			// Posicion en el eje de las X de la cuadricula 
	protected int posY;			// Posicion en el eje de las Y de la cuadricula
	protected final int ANCHO_CUADRICULA = 3;	// Ancho de la cuadricula
	protected final int ALTO_CUADRICULA = 4;	// Alto de la cuadricula

	/** Constructor de la clase, crea un animal con 
	 *  una posicion aleatoria en la cuadricula
	 * 
	 */
	public Animal() {
		Random r = new Random();
		posX = r.nextInt(ANCHO_CUADRICULA);
		posY = r.nextInt(ALTO_CUADRICULA);		
	}
	
	/** Metodo que devuelve la posicion del animal en el eje de las X
	 * @return Posicion en el eje de las X
	 */
	public int getPosX() {
		return posX;
	}

	/** Metodo para cambiar la posicion del animal en el eje de las X
	 * @param posX Nueva posicion para el animal en el eje de las X
	 * @throws FueraDeCuadricula si posX es mas grande que el ancho de la cuadricula
	 */
	public void setPosX(int posX) throws FueraDeCuadricula {
		this.posX = posX;		
		if(posX > ANCHO_CUADRICULA) throw new FueraDeCuadricula();
	}

	/** Metodo que devuelve la posicion del animal en el eje de las Y
	 * @return Posicion en el eje de las Y
	 */
	public int getPosY() {
		return posY;
	}

	/** Metodo para cambiar la posicion del animal en el eje de las Y
	 * @param posX Nueva posicion para el animal en el eje de las Y
	 * @throws FueraDeCuadricula si posY es mas grande que el alto de la cuadricula
	 */
	public void setPosY(int posY) throws FueraDeCuadricula {
		this.posY = posY;
		if(posX > ALTO_CUADRICULA) throw new FueraDeCuadricula();
	}
	
	@Override
	public String toString() {
		return "Posicion: ("+posX+","+posY+")";		
	}
	
}
