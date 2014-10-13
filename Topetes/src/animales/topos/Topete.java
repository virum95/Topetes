package animales.topos;
import java.util.Random;

/** Clase para definir instancias lógicas de topos con posición y puntos.
 * @author Gaizka
 *
 */
public class Topete {
	
	protected double puntos;  	// Puntos que otorga matar al topo
	protected int posX;			// Posicion en el eje de las X de la cuadricula 
	protected int posY;			// Posicion en el eje de las Y de la cuadricula
	protected final int ANCHO_CUADRICULA = 3;	// Ancho de la cuadricula
	protected final int ALTO_CUADRICULA = 4;	// Alto de la cuadricula
	
	
	/** Constructor de la clase, crea un topo con 10 de puntuacion,
	 *  la imagen caracteristica y una posicion aleatoria en la cuadricula
	 * 
	 */
	public Topete() {
		Random r = new Random();
		puntos = 10;
		posX = r.nextInt(ANCHO_CUADRICULA);
		posY = r.nextInt(ALTO_CUADRICULA);		
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
	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}

	/** Metodo que devuelve la posicion del topo en el eje de las X
	 * @return Posicion en el eje de las X
	 */
	public int getPosX() {
		return posX;
	}

	/** Metodo para cambiar la posicion del topo en el eje de las X
	 * @param posX Nueva posicion para el topo en el eje de las X
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/** Metodo que devuelve la posicion del topo en el eje de las Y
	 * @return Posicion en el eje de las Y
	 */
	public int getPosY() {
		return posY;
	}

	/** Metodo para cambiar la posicion del topo en el eje de las Y
	 * @param posX Nueva posicion para el topo en el eje de las Y
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	@Override
	public String toString() {
		return "Posicion: ("+posX+","+posY+")";		
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 60; i++){
			Topete t1 = new Topete();
			System.out.println(t1);			
		}
	}

}
