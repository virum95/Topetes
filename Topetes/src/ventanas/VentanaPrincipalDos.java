package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import ops.MundoJuego;
import animales.topos.Topete;
import animales.topos.TipoTopo;

public class VentanaPrincipalDos {

	final int X_EJE_UNO = 47;
	final int X_EJE_DOS = 280;
	final int X_EJE_TRES = 522;

	final int Y_EJE_UNO = 160;
	final int Y_EJE_DOS = 335;
	final int Y_EJE_TRES = 530;
	final int Y_EJE_CUATRO = 710;


	static JFrame miVentana;
	static JPanel p1;
	static JPanel p2;
	static JPanel p3;
	static JPanel p4;
	static JPanel p5;
	static JPanel p6;
	static JPanel p7;
	static JLayeredPane lp;

	static JPanel panelImagen0;
	static JPanel panelImagen1;
	static JPanel panelImagen2;
	static JPanel panelImagen3;
	static JPanel panelImagen4;

	private Topete[][] arrayTopos = new Topete[12][3];
	private static JPanel[][] arrayPaneles = new JPanel[12][3];

	public VentanaPrincipalDos () {

		MundoJuego m = new MundoJuego(arrayTopos, arrayPaneles);

		// Crear ventana inicial
		miVentana = new JFrame("Prueba de paneles de Swing");        
		// Acabar de crear y hacer visible ventana
		miVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		miVentana.setSize( 700, 755);
		miVentana.setResizable(false);
		lp = new JLayeredPane();

		for (int i = 0; i < arrayTopos.length; i++) {
			for (int j = 0; j < arrayTopos[i].length; j++) {
				if(j==0)
					arrayTopos[i][j] = new Topete(TipoTopo.NORMAL);
				if(j==1)
					arrayTopos[i][j] = new Topete(TipoTopo.CASCO);
				if(j==2)
					arrayTopos[i][j] = new Topete(TipoTopo.JUGGERNAUT);

			}
		}

		lp.addMouseListener( new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX()+" ,"+e.getY());

			}
		});

		//        Redimensionar paneles

		// Creación de los fondos 
		p1 = new JPanel();
		JLabel imagen1 = new JLabel( new ImageIcon("src/img/panel0.png"));
		p1.setBounds(-7, -7, miVentana.getWidth(), miVentana.getHeight());
		p1.add(imagen1);
		p1.setBorder(BorderFactory.createLineBorder(Color.RED));
		p1.setOpaque(false);

		p2 = new JPanel();
		JLabel imagen2 = new JLabel( new ImageIcon("src/img/panel1.png"));
		p2.setBounds(-7, 159, miVentana.getWidth(), miVentana.getHeight());
		p2.add(imagen2);
		imagen2.repaint();
		//			p2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		p2.setOpaque(false);

		p3 = new JPanel();
		JLabel imagen3 = new JLabel( new ImageIcon("src/img/panel2.png"));
		p3.setBounds(-7, 336, miVentana.getWidth(), miVentana.getHeight());
		p3.add(imagen3);
		//			p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p3.setOpaque(false);

		p4 = new JPanel();
		JLabel imagen4 = new JLabel( new ImageIcon("src/img/panel3.png"));
		p4.setBounds(-7, 528, miVentana.getWidth(), miVentana.getHeight());
		p4.add(imagen4);
		//			p4.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		p4.setOpaque(false);

		p5 = new JPanel();
		JLabel imagen5 = new JLabel( new ImageIcon("src/img/panel4.png"));
		p5.setBounds(-7, 709, miVentana.getWidth(), miVentana.getHeight());
		p5.add(imagen5);
		//			p5.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		p5.setOpaque(false);

		// Creación de los topos
		MiRunnable miHilo = new VentanaPrincipalDos.MiRunnable();
		Thread elHilo = new Thread( miHilo );
		try {
			SwingUtilities.invokeAndWait(elHilo);
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}


		miVentana.setLayeredPane( lp );
		lp.add( p5, new Integer(40) );
		lp.add( p4, new Integer(30) );
		lp.add( p3, new Integer(20) );
		lp.add( p2, new Integer(10) );
		lp.add( p1, new Integer(0) );

		//		miVentana.setLocation(2000, 100);
		miVentana.setLocationRelativeTo(null);  // Centrar en pantalla
		miVentana.setVisible(true);


	}

	public Topete[][] getArrayTopos() {
		return arrayTopos;
	}

	public static void main(String[] args) {
		new VentanaPrincipalDos();
	}

	class MiRunnable implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < arrayPaneles.length; i++) {
				for (int j = 0; j < arrayPaneles[i].length; j++) {
					arrayPaneles[i][j] = new JPanel();
					arrayPaneles[i][j].add(arrayTopos[i][j].getImg());
					switch (i) {
					case 0:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_UNO, 123, 141);
						break;
					case 1:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_UNO, 123, 141);
						break;
					case 2:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_UNO, 123, 141);
						break;
					case 3:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_DOS, 123, 141);
						break;
					case 4:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_DOS, 123, 141);
						break;
					case 5:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_DOS, 123, 141);
						break;
					case 6:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
						break;
					case 7:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
						break;
					case 8:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
						break;
					case 9:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_CUATRO, 123, 141);
						break;
					case 10:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_CUATRO, 123, 141);
						break;
					case 11:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_CUATRO, 123, 141);
						break;
					default:
						break;
					}
					arrayPaneles[i][j].setOpaque(false);     
				}
			}

			for (int i = 0; i < arrayPaneles.length; i++) {
				for (int j = 0; j < arrayPaneles[i].length; j++) {
					if (i < 3) 
						lp.add( arrayPaneles[i][j], new Integer(5));
					else if (i < 6)
						lp.add( arrayPaneles[i][j], new Integer(15));
					else if (i < 9)
						lp.add( arrayPaneles[i][j], new Integer(25));
					else 
						lp.add( arrayPaneles[i][j], new Integer(35));

				}
			}
		}
	}
}

