package animales.gatos;

public class Gatete {

	protected int posX;			// Posicion en el eje de las X de la cuadricula 
	protected int posY;			// Posicion en el eje de las Y de la cuadricula
	protected final int ANCHO_CUADRICULA = 3;	// Ancho de la cuadricula
	protected final int ALTO_CUADRICULA = 4;	// Alto de la cuadricula
	
	/** Constructor de la clase gatete, crea un gato accediendo al
	 * constructor de la clase padre Animal
	 * 
	 */
	public Gatete() {
		super();
	}
	
	/** Metodo que mata el gato y devuelve true para acabar la partida
	 * @return
	 */
	public boolean mataGato(){
		return true;
	}
	
	@Override
	public String toString() {
		return "Gato: "+super.toString();
	}
}
