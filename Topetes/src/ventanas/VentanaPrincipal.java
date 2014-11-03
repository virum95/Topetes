package ventanas;
import javax.swing.*;

import animales.Animal;
import animales.gatos.Gatete;
import animales.topos.TipoTopo;
import animales.topos.Topete;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class VentanaPrincipal {

	public static JPanel arrayPaneles [][] = new JPanel [4][3]; // Array de paneles que contienen los jlabel de los topos
	static Animal arrayAnimales[][] = new Animal[4][3]; //Array que va a contener los topos
	MiRunnable miHilo = null;  // Hilo principal del juego
	public static int puntuacion;
	public static int eliminados;
	public static boolean mazo;
	public static JFrame ventana;
	public JPanel panelMain = new JPanel();
	public JPanel panelDePaneles = new JPanel();
	public JLabel jlPutn; 

	public VentanaPrincipal() {
		mazo = true;
		ventana = new JFrame();
		ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// Inicialización del panel
		for (int i2 = 0; i2 < arrayAnimales.length; i2++) {
			for (int j2 = 0; j2 < arrayAnimales[i2].length; j2++) {
				arrayAnimales[i2][j2] = null;
			}
			ventana.add(panelMain);
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

		ventana.setVisible(true);
		ventana.setSize(new Dimension(700,715));
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
					// Metodo que golpea al topo y le resta vidas, si las vidas estan a 0 lo mata
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
						try{
							if(mazo){
								if(arrayAnimales[k][l] instanceof Topete){
									Topete topo = (Topete)arrayAnimales[k][l];
									if(topo.pegaTopo()){
										mazo = false;
									}
									if(topo.getVidas() == 0){
										puntuacion+= topo.getPuntos();
										jlPutn.setText("Puntuacion: "+ puntuacion);
										arrayAnimales[k][l] = null;
										arrayPaneles[k][l].repaint();
										panelMain.repaint();
									}
								} else if( arrayAnimales[k][l] instanceof Gatete ) {
							
								}
								arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
								arrayAnimales[k][l] = null;
								arrayPaneles[k][l].repaint();
								panelMain.repaint();

							}
						}catch(ArrayIndexOutOfBoundsException a)
						{
							//							System.out.println("NO HAY JLABEL");
						} catch(IndexOutOfBoundsException e12){
						}catch (NullPointerException e2) {
							//							System.out.println("No hay topo aqui");
							//TODO resta uno o algo parecido a un contador de golpes fallados
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) { 
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
	public static void creaAnimal () {//TODO: Revisar Probabilidades y añadir pincho 
		Animal animal = null;
		do{
			Random r = new Random();
			int i = r.nextInt(100);
			if(i<40){
				animal = new Topete(TipoTopo.NORMAL); //40
			}else if (i>40 && i<71) {
				animal = new Gatete(); 
				System.out.println( "Creando gato");
			}else if (i>70 && i <91) {
				animal = new Topete(TipoTopo.CASCO);//15
			}else if (i>90) {
				animal = new Topete(TipoTopo.JUGGERNAUT);//15
			}
		}while(arrayPaneles[animal.getPosX()][animal.getPosY()].getComponents().length==1);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
		arrayAnimales[animal.getPosX()][animal.getPosY()]=animal;
		arrayPaneles[animal.getPosX()][animal.getPosY()].add(animal.getImg());
		arrayPaneles[animal.getPosX()][animal.getPosY()].validate();
		arrayPaneles[animal.getPosX()][animal.getPosY()].repaint();	//Repaint a los paneles para que añada otro topo
	}

	public static boolean estamosLLenos(){
		for (int i = 0; i < arrayAnimales.length; i++) {
			for (int j = 0; j < arrayAnimales[i].length; j++) {
				if(arrayAnimales[i][j]==null)
					return false;
			}
		}
		return true;
	}

	/** Metodo que mira que topo lleva demasiado tiempo y lo elimina si se pasa
	 * @param maxTiempo Maximo del tiempo que puede estar el topo en la pantalla
	 * @return
	 */
	public static boolean quitaAnimal(long maxTiempo){
		boolean acaba = false;
		for (int i = 0; i < arrayAnimales.length; i++) {
			for (int j = 0; j < arrayAnimales[i].length; j++) {
				if(arrayAnimales[i][j]!=null){
					if(System.currentTimeMillis() - arrayAnimales[i][j].getFechaCreacion() >= maxTiempo){
						if(arrayAnimales[i][j] instanceof Topete)
							eliminados++;
						arrayPaneles[i][j].remove(arrayPaneles[i][j].getComponent(0));
						arrayAnimales[i][j] = null;
						arrayPaneles[i][j].repaint();
						if (VentanaPrincipal.eliminados>2) 
							acaba = true;
					}
				}
			}
		}
		return acaba;
	}

	public static  void borraVentana() {
		ventana.dispose();
	}

	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.miHilo = new MiRunnable();  // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread( ventana.miHilo );
		nuevoHilo.start();

	}

	public static JFrame getVentana() {
		return ventana;
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
				VentanaPrincipal.creaAnimal();}
			try {
				Thread.sleep( 1200 );
			} catch (Exception e) {
			}

			if(VentanaPrincipal.quitaAnimal(1000))
				acaba();
		}
		String player = JOptionPane.showInputDialog(null,
				"Fin del Juego. Fin del Juego. Tu puntuacion final ha sido de "+VentanaPrincipal.puntuacion+". Introduce el nombre del jugador:", 
				"Game Over",
				JOptionPane.INFORMATION_MESSAGE);
		if(JOptionPane.showConfirmDialog(null, 
				"¿Jugar Otra vez?",
				"GAME OVER",
				JOptionPane.YES_NO_OPTION) == 1){
			System.exit(0);			
		} else {
			VentanaPrincipal.borraVentana();
			VentanaPrincipal.puntuacion = 0;
			VentanaPrincipal.main(null);
		}
	}


	//	private int calculoTiempo() {
	//		int tiempo = 6000;
	////		if(puntuacion<)
	//		
	//	}

	/** Ordena al hilo detenerse en cuanto sea posible
	 */
	public void acaba() {
		sigo = false;

	}

}
