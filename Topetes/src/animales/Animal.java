package animales;

import java.util.Random;

import javax.swing.JLabel;

import excepciones.FueraDeCuadricula;

/**
 * Clase padre de todos los animales del juego Tiene los metodos basicos que
 * comparten todos los animales como getPosX o getPosY
 * 
 * @author Gaizka
 *
 */
public abstract class Animal {

	protected int posX; // Posicion en el eje de las X de la cuadricula
	protected int posY; // Posicion en el eje de las Y de la cuadricula
	protected final int ALTO_CUADRICULA = 3; // Ancho de la cuadricula
	protected final int ANCHO_CUADRICULA = 4; // Alto de la cuadricula
	protected long fechaCreacion; // Fecha en la que se ha creado el topo
	protected JLabel img;
	protected boolean fuera;
	protected boolean golpeado;

	/**
	 * Constructor de la clase, crea un animal con una posicion aleatoria en la
	 * cuadricula
	 * 
	 */
	public Animal() {
		Random r = new Random();
		posX = r.nextInt(ANCHO_CUADRICULA);
		posY = r.nextInt(ALTO_CUADRICULA);
		fuera = false;
	}

	/**
	 * Metodo que devuelve la posicion del animal en el eje de las X
	 * 
	 * @return Posicion en el eje de las X
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Metodo para cambiar la posicion del animal en el eje de las X
	 * 
	 * @param posX
	 *            Nueva posicion para el animal en el eje de las X
	 * @throws FueraDeCuadricula
	 *             si posX es mas grande que el ancho de la cuadricula
	 */
	public void setPosX(int posX) throws FueraDeCuadricula {
		this.posX = posX;
		if (posX > ANCHO_CUADRICULA)
			throw new FueraDeCuadricula();
	}

	/**
	 * Metodo que devuelve la posicion del animal en el eje de las Y
	 * 
	 * @return Posicion en el eje de las Y
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Metodo para cambiar la posicion del animal en el eje de las Y
	 * 
	 * @param posX
	 *            Nueva posicion para el animal en el eje de las Y
	 * @throws FueraDeCuadricula
	 *             si posY es mas grande que el alto de la cuadricula
	 */
	public void setPosY(int posY) throws FueraDeCuadricula {
		this.posY = posY;
		if (posX > ALTO_CUADRICULA)
			throw new FueraDeCuadricula();
	}

	/**
	 * Metodo para devolver la imagen del topo
	 * 
	 * @return
	 */
	public JLabel getImg() {
		return img;
	}

	/**
	 * Metodo para devolver el momento exacto en el que se creo el topo
	 * 
	 * @return fecha en la que se creo el topo
	 */
	public long getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * M�todo que permite la modificaci�n de la fecha de creacion
	 * 
	 * @param fechaCreacion
	 *            nueva fecha de creaci�n
	 */
	public void setFechaCreacion(long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * M�todo que permite modificar si el topo esta fuera
	 * 
	 * @param fuera
	 *            true si el topo esta fuera
	 */
	public void setFuera(boolean fuera) {
		this.fuera = fuera;
	}

	/**
	 * M�todo que devuelve el estado del topo
	 * 
	 * @return true si esta fuera, false si esta dentro
	 */
	public boolean isFuera() {
		return fuera;
	}

	@Override
	public String toString() {
		return "Posicion: (" + posX + "," + posY + ")";
	}

}