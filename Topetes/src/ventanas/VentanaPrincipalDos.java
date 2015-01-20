package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import animales.topos.Topete;
import animales.topos.TipoTopo;

public class VentanaPrincipalDos {

	final int X_EJE_UNO = 47;
	final int X_EJE_DOS = 280;
	final int X_EJE_TRES = 522;
	
	final int Y_EJE_UNO = 160;
	final int Y_EJE_DOS = 330;
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

	public VentanaPrincipalDos () {

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

	/* Valores para los topos:
	 * Primera columna: 47
	 * Segunda columna: 280	
	 * Tercera columna: 522
	 * Primera fila: Fuera: 50; Dentro: 160
	 * Segunda fila: Fuera: 230; Dentro: 330
	 * Tercera fila: Fuera: 410; Dentro: 530
	 * Cuarta fila: Fuera: 590; Dentro: 720
	 * 
	 */

	public static void main(String[] args) {
		new VentanaPrincipalDos();
	}

	class MiRunnable implements Runnable {
		
		@Override
		public void run() {
		// Primera fila
			// Hueco 1
			JPanel tn1 = new JPanel();
			tn1.add(arrayTopos[0][0].getImg());
			tn1.setBounds(X_EJE_UNO, Y_EJE_UNO, 123, 141);
			tn1.setOpaque(false);     

			JPanel tc1 = new JPanel();
			tc1.add(arrayTopos[0][1].getImg());
			tc1.setBounds(X_EJE_UNO, Y_EJE_UNO, 123, 141);
			tc1.setOpaque(false);        	

			JPanel tj1 = new JPanel();
			tj1.add(arrayTopos[0][2].getImg());
			tj1.setBounds(X_EJE_UNO, Y_EJE_UNO, 123, 141);
			tj1.setOpaque(false); 
			
			// Hueco 2
			JPanel tn2 = new JPanel();
			tn2.add(arrayTopos[1][0].getImg());
			tn2.setBounds(X_EJE_DOS, Y_EJE_UNO, 123, 141);
			tn2.setOpaque(false);     

			JPanel tc2 = new JPanel();
			tc2.add(arrayTopos[1][1].getImg());
			tc2.setBounds(X_EJE_DOS, Y_EJE_UNO, 123, 141);
			tc2.setOpaque(false);        	

			JPanel tj2 = new JPanel();
			tj2.add(arrayTopos[1][2].getImg());
			tj2.setBounds(X_EJE_DOS, Y_EJE_UNO, 123, 141);
			tj2.setOpaque(false);   
	    	
			// Hueco 3
			JPanel tn3 = new JPanel();
			tn3.add(arrayTopos[2][0].getImg());
			tn3.setBounds(X_EJE_TRES, Y_EJE_UNO, 123, 141);
			tn3.setOpaque(false);     

			JPanel tc3 = new JPanel();
			tc3.add(arrayTopos[2][1].getImg());
			tc3.setBounds(X_EJE_TRES, Y_EJE_UNO, 123, 141);
			tc3.setOpaque(false);        	

			JPanel tj3 = new JPanel();
			tj3.add(arrayTopos[2][2].getImg());
			tj3.setBounds(X_EJE_TRES, Y_EJE_UNO, 123, 141);
			tj3.setOpaque(false);  

			// Segunda fila
			// Hueco 4
			JPanel tn4 = new JPanel();
			tn4.add(arrayTopos[3][0].getImg());
			tn4.setBounds(X_EJE_UNO, Y_EJE_DOS, 123, 141);
			tn4.setOpaque(false);     

			JPanel tc4 = new JPanel();
			tc4.add(arrayTopos[3][1].getImg());
			tc4.setBounds(X_EJE_UNO, Y_EJE_DOS, 123, 141);
			tc4.setOpaque(false);        	

			JPanel tj4 = new JPanel();
			tj4.add(arrayTopos[3][2].getImg());
			tj4.setBounds(X_EJE_UNO, Y_EJE_DOS, 123, 141);
			tj4.setOpaque(false); 
			
			// Hueco 5
			JPanel tn5 = new JPanel();
			tn5.add(arrayTopos[4][0].getImg());
			tn5.setBounds(X_EJE_DOS, Y_EJE_DOS, 123, 141);
			tn5.setOpaque(false);     

			JPanel tc5 = new JPanel();
			tc5.add(arrayTopos[4][1].getImg());
			tc5.setBounds(X_EJE_DOS, Y_EJE_DOS, 123, 141);
			tc5.setOpaque(false);        	

			JPanel tj5 = new JPanel();
			tj5.add(arrayTopos[4][2].getImg());
			tj5.setBounds(X_EJE_DOS, Y_EJE_DOS, 123, 141);
			tj5.setOpaque(false);   
	    	
			// Hueco 6
			JPanel tn6 = new JPanel();
			tn6.add(arrayTopos[5][0].getImg());
			tn6.setBounds(X_EJE_TRES, Y_EJE_DOS, 123, 141);
			tn6.setOpaque(false);     

			JPanel tc6 = new JPanel();
			tc6.add(arrayTopos[5][1].getImg());
			tc6.setBounds(X_EJE_TRES, Y_EJE_DOS, 123, 141);
			tc6.setOpaque(false);        	

			JPanel tj6 = new JPanel();
			tj6.add(arrayTopos[5][2].getImg());
			tj6.setBounds(X_EJE_TRES, Y_EJE_DOS, 123, 141);
			tj6.setOpaque(false); 
   
			// Tercera fila
			// Hueco 7
			JPanel tn7 = new JPanel();
			tn7.add(arrayTopos[6][0].getImg());
			tn7.setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
			tn7.setOpaque(false);     

			JPanel tc7 = new JPanel();
			tc7.add(arrayTopos[6][1].getImg());
			tc7.setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
			tc7.setOpaque(false);        	

			JPanel tj7 = new JPanel();
			tj7.add(arrayTopos[6][2].getImg());
			tj7.setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
			tj7.setOpaque(false); 
			
			// Hueco 8
			JPanel tn8 = new JPanel();
			tn8.add(arrayTopos[7][0].getImg());
			tn8.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tn8.setOpaque(false);     

			JPanel tc8 = new JPanel();
			tc8.add(arrayTopos[7][1].getImg());
			tc8.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tc8.setOpaque(false);        	

			JPanel tj8 = new JPanel();
			tj8.add(arrayTopos[7][2].getImg());
			tj8.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tj8.setOpaque(false);   
	    	
			// Hueco 9
			JPanel tn9 = new JPanel();
			tn9.add(arrayTopos[8][0].getImg());
			tn9.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tn9.setOpaque(false);     

			JPanel tc9 = new JPanel();
			tc9.add(arrayTopos[8][1].getImg());
			tc9.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tc9.setOpaque(false);        	

			JPanel tj9 = new JPanel();
			tj9.add(arrayTopos[8][2].getImg());
			tj9.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tj9.setOpaque(false);     
			
		// Cuarta fila
			// Hueco 10
			JPanel tn10 = new JPanel();
			tn10.add(arrayTopos[9][0].getImg());
			tn10.setBounds(X_EJE_UNO, Y_EJE_CUATRO, 123, 141);
			tn10.setOpaque(false);     

			JPanel tc10 = new JPanel();
			tc10.add(arrayTopos[9][1].getImg());
			tc10.setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
			tc10.setOpaque(false);        	

			JPanel tj10 = new JPanel();
			tj10.add(arrayTopos[9][2].getImg());
			tj10.setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
			tj10.setOpaque(false); 
			
			// Hueco 11
			JPanel tn11 = new JPanel();
			tn11.add(arrayTopos[10][0].getImg());
			tn11.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tn11.setOpaque(false);     

			JPanel tc11 = new JPanel();
			tc11.add(arrayTopos[10][1].getImg());
			tc11.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tc11.setOpaque(false);        	

			JPanel tj11 = new JPanel();
			tj11.add(arrayTopos[10][2].getImg());
			tj11.setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
			tj11.setOpaque(false);   
	    	
			// Hueco 12
			JPanel tn12 = new JPanel();
			tn12.add(arrayTopos[11][0].getImg());
			tn12.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tn12.setOpaque(false);     

			JPanel tc12 = new JPanel();
			tc12.add(arrayTopos[11][1].getImg());
			tc12.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tc12.setOpaque(false);        	

			JPanel tj12 = new JPanel();
			tj12.add(arrayTopos[11][2].getImg());
			tj12.setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
			tj12.setOpaque(false);     
			
			

			lp.add( tn10, new Integer(35));
			lp.add( tc10, new Integer(35));
			lp.add( tj10, new Integer(35));
			lp.add( tn11, new Integer(35));
			lp.add( tc11, new Integer(35));
			lp.add( tj11, new Integer(35));
			lp.add( tn12, new Integer(35));
			lp.add( tc12, new Integer(35));
			lp.add( tj12, new Integer(35));	

			lp.add( tn9, new Integer(35));
			lp.add( tc9, new Integer(35));
			lp.add( tj9, new Integer(35));
			lp.add( tn8, new Integer(35));
			lp.add( tc8, new Integer(35));
			lp.add( tj8, new Integer(35));
			lp.add( tn7, new Integer(35));
			lp.add( tc7, new Integer(35));
			lp.add( tj7, new Integer(35));	
			
			lp.add( tn6, new Integer(25));	
			lp.add( tc6, new Integer(25));	
			lp.add( tj6, new Integer(25));	
			lp.add( tn5, new Integer(25));	
			lp.add( tc5, new Integer(25));	
			lp.add( tj5, new Integer(25));	
			lp.add( tn4, new Integer(25));	
			lp.add( tc4, new Integer(25));	
			lp.add( tj4, new Integer(25));	
	
			lp.add( tn3, new Integer(15));	
			lp.add( tc3, new Integer(15));	
			lp.add( tj3, new Integer(15));	
			lp.add( tn2, new Integer(15));	
			lp.add( tc2, new Integer(15));	
			lp.add( tj2, new Integer(15));	
			lp.add( tn1, new Integer(15));
			lp.add( tc1, new Integer(15));
			lp.add( tj1, new Integer(15));
		}
		
		
	}
}

