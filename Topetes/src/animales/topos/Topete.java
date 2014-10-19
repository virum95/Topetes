package animales.topos;


import ventanas.VentanaPrincipal;
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
		puntos = 10;
		fechaCreacion = System.currentTimeMillis();
		tipo = t;
		switch (t) {
		case NORMAL:
			vidas = 1;
			break;
		case MASAO:
			vidas = 2;			
			break;
		case CASCO:
			vidas = 3;
			break;
		case JUGGERNAUT:
			vidas = 5;			
			break;
		case BOSS:
			vidas = 10;			
			break;
		default:
			break;
		}
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
	/** Metodo que resta una vida al topo
	 * 
	 */
	public boolean pegaTopo() {
		vidas--;
		if(vidas == 0) return mataTopo();
		else return false;

	}
	
	/** Metodo que permite matar al topo y devolver un
	 * @param puntuacionActual Puntuacion actual de la partida
	 * @return Puntuacion despues de matar al topo (Puntuacion anterior + valor del topo)
	 */
	public boolean mataTopo(){
		switch (tipo) {
		case NORMAL:
			VentanaPrincipal.puntuacion+=5;
			break;
		case MASAO:
			VentanaPrincipal.puntuacion+=15;
			break;
		case CASCO:
			VentanaPrincipal.puntuacion+=25;
			break;
		case JUGGERNAUT:
			VentanaPrincipal.puntuacion+=50;
			break;
		case BOSS:
			VentanaPrincipal.puntuacion+=500;
			break;
		default:
			break;
		}
		return true;
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
