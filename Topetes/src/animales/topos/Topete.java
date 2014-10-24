package animales.topos;


import excepciones.FueraDeCuadricula;
import animales.Animal;
import animales.topos.jlabels.JLabelTopete;

/** Clase para definir instancias lógicas de topos con posición y puntos.
 * @author Gaizka
 *
 */
public class Topete extends Animal{
	
	protected int puntos;  	// Puntos que otorga matar al topo	
	long fechaCreacion;
	protected int vidas; // Numero de vidas que tiene el topo
	protected JLabelTopete img; // TODO: Imagen para cada topo
	protected TipoTopo tipo;
	
	
	/** Constructor de la clase, crea un topo con 10 de puntuacion,
	 *  la imagen caracteristica y una posicion aleatoria en la cuadricula
	 * 
	 */
	public Topete( TipoTopo t) {
		super();
		img = new JLabelTopete(t);
		fechaCreacion = System.currentTimeMillis();
		tipo = t;
		switch (t) {
		case NORMAL:
			vidas = 1;
			puntos = 5;
			break;
//		case PINCHO:
//			vidas = 1;		
//			puntos = 0;
//			break;
		case CASCO:
			vidas = 3;
			puntos = 25;
			break;
		case JUGGERNAUT:
			vidas = 5;	
			puntos = 50;
			break;
		case BOSS:
			vidas = 10;
			puntos = 500;
			break;
		default:
			break;
		}
	}

	/** Metodo para obtener el numero de puntos que da matar al topo
	 * @return Puntos que vale el topo
	 */
	public int getPuntos() {
		return puntos;
	}

	/** Metodo para cambiar el valor de un topo
	 * @param puntos Nuevo valor para los puntos del topo
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	/** Metodo para devolver la imagen del topo
	 * @return
	 */
	public JLabelTopete getImg() {
		return img;
	}
	
	/** Metodo para devolver las vidas del topo
	 * @return
	 */
	public int getVidas() {
		return vidas;
	}
	
	/** Metodo para devolver el momento exacto en el que se creo el topo
	 * @return
	 */
	public long getFechaCreacion() {
		return fechaCreacion;
	}
	
	
	/** Metodo que le resta vida al topo
	 * @return devuelve true si el topo es un topo pincho y false si no lo es
	 */
	public boolean pegaTopo() {
		vidas--;
		if(tipo == TipoTopo.PINCHO)
			{
			return true;
			}
		else return false;
	}
	
	
	@Override
	public String toString() {
		return "Topo: "+super.toString();
	}
	
	public static void main(String[] args) {
		Topete t1 = new Topete(TipoTopo.NORMAL);			
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
