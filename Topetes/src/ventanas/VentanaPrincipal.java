package ventanas;
import javax.swing.*;

import animales.topos.TipoTopo;
import animales.topos.Topete;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class VentanaPrincipal extends JFrame{


	private static final long serialVersionUID = 1096374592905539346L;

	public static JPanel arrayPaneles [][] = new JPanel [4][3]; // Array de paneles que contienen los jlabel de los topos
	static Topete arrayTopos[][] = new Topete[4][3]; //Array que va a contener los topos
	MiRunnable miHilo = null;  // Hilo principal del juego
	public static int puntuacion;
	public static int eliminados;
	public JPanel panelMain = new JPanel();
	public JPanel panelDePaneles = new JPanel();
	public JLabel jlPutn; 
	
	public VentanaPrincipal() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// Inicialización del panel
		for (int i2 = 0; i2 < arrayTopos.length; i2++) {
			for (int j2 = 0; j2 < arrayTopos[i2].length; j2++) {
				arrayTopos[i2][j2] = null;
			}
			add(panelMain);
			panelMain.validate();
			panelMain.repaint();
			panelMain.setLayout(new BorderLayout());
		}
		eliminados = 0;
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(3);
		gridLayout.setRows(4);
		panelDePaneles.setLayout(gridLayout);
		
		JPanel jlpuntuacion = new JPanel();
		jlPutn = new JLabel("Puntuacion: "+ puntuacion);
		
		jlpuntuacion.add(jlPutn);
		panelMain.add(panelDePaneles,BorderLayout.CENTER);
		panelMain.add(jlpuntuacion, BorderLayout.NORTH);
		
		
		//Imagen del cursor cambiar lo de dentro del getImage para que cambie 
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Image imagen = toolkit.getImage("src/img/mazoSinFondo.png");
		 Cursor c = toolkit.createCustomCursor(imagen , new Point(panelMain.getX(), panelMain.getY()), "img");
		 panelMain.setCursor (c);
		  
		setVisible(true);
		setSize(new Dimension(400,715));
		panelMain.validate();
		panelMain.repaint();
		
		

		for(int i=0; i<gridLayout.getRows(); i++)
		{
			for(int j=0 ; j<gridLayout.getColumns(); j++)
			{
				arrayPaneles [i][j] = new JPanel();
				arrayPaneles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

				panelDePaneles.add(arrayPaneles[i][j], BorderLayout.CENTER);

				panelMain.repaint();
				final int k = i;
				final int l = j;
				
				

				arrayPaneles[i][j].addMouseListener(new MouseListener ()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
					}

					@Override
					public void mouseEntered(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
					}

					@Override
					public void mouseReleased(MouseEvent e) { // Metodo que golpea al topo y le resta vidas, si las vidas estan a 0 lo mata
						try{
							if(arrayTopos[k][l].pegaTopo() != 0){
								arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
								puntuacion+= arrayTopos[k][l].getPuntos();
								jlPutn.setText("Puntuacion: "+ puntuacion);
								arrayTopos[k][l] = null;
								arrayPaneles[k][l].repaint();
								panelMain.repaint();
							}		
						}catch(ArrayIndexOutOfBoundsException a)
						{
							System.out.println("NO HAY JLABEL");
						} catch(IndexOutOfBoundsException e12){
						}catch (NullPointerException e2) {
							System.out.println("No hay topo aqui");
							//TODO resta uno o algo parecido a un contador de golpes fallados
						}
					}

				}
						);

			}
		}
	}


	public static int getPuntuacion() {
		return puntuacion;
	}


	/**
	 * Crea un topo, cada tipo tiene una probabilidad de salir
	 * TODO a medida que el juego avanza tienen que cambiar las probabilidades
	 */
	public static void creaTopo () 
	{
		Topete topo = null;
		do{
			Random r = new Random();
			int i = r.nextInt(100);
			if(i<70)
				topo = new Topete(TipoTopo.NORMAL); //40
			else if (i>70 && i <91) {
				topo = new Topete(TipoTopo.CASCO);//15
			}else if (i>90) {
				topo = new Topete(TipoTopo.JUGGERNAUT);//15
				System.out.println("JUGERNAUT");
			}
		}while(arrayPaneles[topo.getPosX()][topo.getPosY()].getComponents().length==1);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
		arrayTopos[topo.getPosX()][topo.getPosY()]=topo;
		arrayPaneles[topo.getPosX()][topo.getPosY()].add(topo.getImg());
		arrayPaneles[topo.getPosX()][topo.getPosY()].validate();
		arrayPaneles[topo.getPosX()][topo.getPosY()].repaint();	//Repaint a los paneles para que añada otro topo
	}

	public static boolean estamosLLenos(){
		for (int i = 0; i < arrayTopos.length; i++) {
			for (int j = 0; j < arrayTopos[i].length; j++) {
				if(arrayTopos[i][j]==null)
					return false;
			}
		}
		return true;
	}

	/** Metodo que mira que topo lleva demasiado tiempo y lo elimina si se pasa
	 * @param maxTiempo Maximo del tiempo que puede estar el topo en la pantalla
	 * @return
	 */
	public static int quitaTopo(long maxTiempo){
		for (int i = 0; i < arrayTopos.length; i++) {
			for (int j = 0; j < arrayTopos[i].length; j++) {
				if(arrayTopos[i][j]!=null){
					if(System.currentTimeMillis()- arrayTopos[i][j].getFechaCreacion()>=maxTiempo){
						arrayPaneles[i][j].remove(arrayPaneles[i][j].getComponent(0));
						arrayTopos[i][j] = null;
						arrayPaneles[i][j].repaint();
						eliminados++;
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.miHilo = new MiRunnable();  // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread( ventana.miHilo );
		nuevoHilo.start();

	}
}


/**
 * @author rubensancor
 * Clase robada a anoni para el hilo :D
 */
class MiRunnable implements Runnable {
	boolean sigo = true;

	@Override
	public void run() {
		while (sigo) {
			
			if(!VentanaPrincipal.estamosLLenos()){
				VentanaPrincipal.creaTopo();}
			
			System.out.println(VentanaPrincipal.eliminados);
			VentanaPrincipal.quitaTopo(6000);
			if (VentanaPrincipal.eliminados>2) {
				acaba();
				//TODO cuando acaba no tiene que dejar matar mas topos.
			}

			try {
				Thread.sleep( 1200 );
			} catch (Exception e) {
			}
		}
	}
	/** Ordena al hilo detenerse en cuanto sea posible
	 */
	public void acaba() {
		sigo = false;

	}

}
