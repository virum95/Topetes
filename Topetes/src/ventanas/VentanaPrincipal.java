package ventanas;
import javax.swing.*;

import animales.topos.TipoTopo;
import animales.topos.Topete;
import animales.topos.jlabels.JLabelTopete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class VentanaPrincipal extends JFrame{


	private static final long serialVersionUID = 1096374592905539346L;

	static JPanel arrayPaneles [][] = new JPanel [4][3]; // Array de paneles que contienen los jlabel de los topos
	static int arrayAlternativo [][] = new int [4][3];	//Array alternativo con el numero de veces clicadas en ese panel
	static Topete arrayTopos[][] = new Topete[4][3]; //Array que va a contener los topos
	MiRunnable miHilo = null;  // Hilo principal del juego
	public static int puntuacion;

	public VentanaPrincipal() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		// Inicialización del panel
		for (int i2 = 0; i2 < arrayAlternativo.length; i2++) {
			for (int j2 = 0; j2 < arrayAlternativo[i2].length; j2++) {
				arrayAlternativo[i2][j2] = 0;
			}

		}
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(3);
		gridLayout.setRows(4);
		setLayout(gridLayout);
		setVisible(true);
		setSize(new Dimension(400,600));

		for(int i=0; i<gridLayout.getRows(); i++)
		{
			for(int j=0 ; j<gridLayout.getColumns(); j++)
			{
				arrayPaneles [i][j] = new JPanel();
				arrayPaneles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(arrayPaneles[i][j]);
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
					public void mouseReleased(MouseEvent e) {
						try{
							//							if(e.getComponent() instanceof JLabelTopete){
							JLabel temp = (JLabel) e.getComponent();
							for (int i = 0; i<arrayPaneles.length; i++) {
								for (int j= 0; j<arrayPaneles[i].length; j++) {
									if(arrayPaneles[i][j].equals(temp))
										arrayTopos[i][j].pegaTopo();

									System.out.println(arrayTopos[i][j].getVidas());
									//									if(topete.getVidas()<=0){
									//										arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
									//										arrayDeTopos.remove(0);
									//										arrayPaneles[k][l].repaint();
									//										arrayAlternativo[k][l] = 0;
									//									}
								}

							}
						}catch(ArrayIndexOutOfBoundsException a)
						{
							System.out.println("NO HAY JLABEL");
						} catch(IndexOutOfBoundsException e12){

						}
					}

				}
						);

			}
		}
	}


	public static void creaTopo ()
	{
		Topete topo;
		do{

			topo = new Topete(TipoTopo.NORMAL);

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
			}
		}
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

			if(VentanaPrincipal.arrayTopos.size()<12)
				VentanaPrincipal.creaTopo();

			try {
				Thread.sleep( 1000 );
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
