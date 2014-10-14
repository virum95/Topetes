package ventanas;
import javax.swing.*;

import animales.topos.Topete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


public class VentanaPrincipal extends JFrame{


	private static final long serialVersionUID = 1096374592905539346L;

	static JPanel arrayPaneles [][]= new JPanel [4][3];
	static ArrayList <Topete> arrayDeTopos = new ArrayList<>();
	MiRunnable miHilo = null;  // Hilo principal del juego

	public VentanaPrincipal() {


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
							arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
							arrayDeTopos.remove(0);
							arrayPaneles[k][l].repaint();
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
		JLabel labelTopo = new JLabel("TOPO");
		arrayDeTopos.add(labelTopo);
		Random r = new Random();
		int x = r.nextInt(4);
		int y = r.nextInt(3);
		arrayPaneles[x][y].add(labelTopo);
		arrayPaneles[x][y].validate();
		System.out.println("-->" + x +" "+ y + "<--" );
		arrayPaneles[x][y].repaint();	//Repaint a los paneles para que añada otro topo
		System.out.println("asdf");


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
