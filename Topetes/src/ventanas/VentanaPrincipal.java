package ventanas;
import javax.swing.*;

import animales.topos.Topete;
import animales.topos.jlabels.JLabelTopete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class VentanaPrincipal extends JFrame{


	private static final long serialVersionUID = 1096374592905539346L;

	static JPanel arrayPaneles [][] = new JPanel [4][3];
	static int arrayAlternativo [][] = new int [4][3];	//Array alternativo con el numero de veces clicadas en ese panel
	static ArrayList <JLabelTopete> arrayDeTopos = new ArrayList<>();
	MiRunnable miHilo = null;  // Hilo principal del juego

	public VentanaPrincipal() {
		// Inicialización del panel
		for (int i2 = 0; i2 < arrayAlternativo.length; i2++) {
			for (int j2 = 0; j2 < arrayAlternativo[i2].length; j2++) {
				arrayAlternativo[i2][j2] = 0;
			}

		}
		arrayDeTopos = new ArrayList<>();
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
					public void mouseReleased(MouseEvent e) {
						try{
							System.out.println("ENTRA EN EL PANEL"+k+l);
							arrayAlternativo[k][l]++;
							if(arrayAlternativo[k][l]==2){
								arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
								arrayDeTopos.remove(0);
								arrayPaneles[k][l].repaint();
								arrayAlternativo[k][l] = 0;
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
		JLabelTopete labelTopo = new JLabelTopete();
		arrayDeTopos.add(new JLabelTopete());
		Random r = new Random();
		int x;
		int y;
		do{
			x = r.nextInt(4);
			y = r.nextInt(3);
		}while(arrayPaneles[x][y].getComponents().length==1); //Evita que si ya hay un topo en el espacio seleccionado, se cree otro
		arrayPaneles[x][y].add(labelTopo);
		arrayPaneles[x][y].validate();
		arrayPaneles[x][y].repaint();	//Repaint a los paneles para que añada otro topo
		System.out.println(arrayDeTopos.size());



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
