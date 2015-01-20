package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import animales.topos.Topete;
import animales.topos.TipoTopo;

public class VentanaPrincipalDos {

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

	static Topete normal1 = new Topete(TipoTopo.NORMAL);
	static Topete casco1 = new Topete(TipoTopo.CASCO);
	static Topete jugg1 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal2 = new Topete(TipoTopo.NORMAL);
	static Topete casco2 = new Topete(TipoTopo.CASCO);
	static Topete jugg2 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal3 = new Topete(TipoTopo.NORMAL);
	static Topete casco3 = new Topete(TipoTopo.CASCO);
	static Topete jugg3 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal4= new Topete(TipoTopo.NORMAL);
	static Topete casco4 = new Topete(TipoTopo.CASCO);
	static Topete jugg4 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal5 = new Topete(TipoTopo.NORMAL);
	static Topete casco5 = new Topete(TipoTopo.CASCO);
	static Topete jugg5 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal6 = new Topete(TipoTopo.NORMAL);
	static Topete casco6 = new Topete(TipoTopo.CASCO);
	static Topete jugg6 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal7 = new Topete(TipoTopo.NORMAL);
	static Topete casco7 = new Topete(TipoTopo.CASCO);
	static Topete jugg7 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal8 = new Topete(TipoTopo.NORMAL);
	static Topete casco8 = new Topete(TipoTopo.CASCO);
	static Topete jugg8 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal9 = new Topete(TipoTopo.NORMAL);
	static Topete casco9 = new Topete(TipoTopo.CASCO);
	static Topete jugg9 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal10 = new Topete(TipoTopo.NORMAL);
	static Topete casco10 = new Topete(TipoTopo.CASCO);
	static Topete jugg10 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal11 = new Topete(TipoTopo.NORMAL);
	static Topete casco11 = new Topete(TipoTopo.CASCO);
	static Topete jugg11 = new Topete(TipoTopo.JUGGERNAUT);
	static Topete normal12 = new Topete(TipoTopo.NORMAL);
	static Topete casco12 = new Topete(TipoTopo.CASCO);
	static Topete jugg12 = new Topete(TipoTopo.JUGGERNAUT);


	public VentanaPrincipalDos () {

		// Crear ventana inicial
		miVentana = new JFrame("Prueba de paneles de Swing");        
		// Acabar de crear y hacer visible ventana
		miVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		miVentana.setSize( 700, 755);
		miVentana.setResizable(false);
		lp = new JLayeredPane();
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
			tn1.add(normal1.getImg());
			tn1.setBounds(47, 160, 123, 141);
			tn1.setOpaque(false);     

			JPanel tc1 = new JPanel();
			tc1.add(casco1.getImg());
			tc1.setBounds(47, 160, 123, 141);
			tc1.setOpaque(false);        	

			JPanel tj1 = new JPanel();
			tj1.add(jugg1.getImg());
			tj1.setBounds(47, 160, 123, 141);
			tj1.setOpaque(false); 
			
			// Hueco 2
			JPanel tn2 = new JPanel();
			tn2.add(normal2.getImg());
			tn2.setBounds(280, 160, 123, 141);
			tn2.setOpaque(false);     

			JPanel tc2 = new JPanel();
			tc2.add(casco2.getImg());
			tc2.setBounds(280, 160, 123, 141);
			tc2.setOpaque(false);        	

			JPanel tj2 = new JPanel();
			tj2.add(jugg2.getImg());
			tj2.setBounds(280, 160, 123, 141);
			tj2.setOpaque(false);   
	    	
			// Hueco 3
			JPanel tn3 = new JPanel();
			tn3.add(normal3.getImg());
			tn3.setBounds(522, 160, 123, 141);
			tn3.setOpaque(false);     

			JPanel tc3 = new JPanel();
			tc3.add(casco3.getImg());
			tc3.setBounds(522, 160, 123, 141);
			tc3.setOpaque(false);        	

			JPanel tj3 = new JPanel();
			tj3.add(jugg3.getImg());
			tj3.setBounds(522, 160, 123, 141);
			tj3.setOpaque(false);  

			// Segunda fila
			// Hueco 4
			JPanel tn4 = new JPanel();
			tn4.add(normal4.getImg());
			tn4.setBounds(47, 335, 123, 141);
			tn4.setOpaque(false);     

			JPanel tc4 = new JPanel();
			tc4.add(casco4.getImg());
			tc4.setBounds(47, 335, 123, 141);
			tc4.setOpaque(false);        	

			JPanel tj4 = new JPanel();
			tj4.add(jugg4.getImg());
			tj4.setBounds(47, 335, 123, 141);
			tj4.setOpaque(false); 
			
			// Hueco 5
			JPanel tn5 = new JPanel();
			tn5.add(normal5.getImg());
			tn5.setBounds(280, 335, 123, 141);
			tn5.setOpaque(false);     

			JPanel tc5 = new JPanel();
			tc5.add(casco5.getImg());
			tc5.setBounds(280, 335, 123, 141);
			tc5.setOpaque(false);        	

			JPanel tj5 = new JPanel();
			tj5.add(jugg5.getImg());
			tj5.setBounds(280, 335, 123, 141);
			tj5.setOpaque(false);   
	    	
			// Hueco 6
			JPanel tn6 = new JPanel();
			tn6.add(normal6.getImg());
			tn6.setBounds(522, 335, 123, 141);
			tn6.setOpaque(false);     

			JPanel tc6 = new JPanel();
			tc6.add(casco6.getImg());
			tc6.setBounds(522, 335, 123, 141);
			tc6.setOpaque(false);        	

			JPanel tj6 = new JPanel();
			tj6.add(jugg6.getImg());
			tj6.setBounds(522, 335, 123, 141);
			tj6.setOpaque(false); 
   
			// Tercera fila
			// Hueco 7
			JPanel tn7 = new JPanel();
			tn7.add(normal7.getImg());
			tn7.setBounds(47, 530, 123, 141);
			tn7.setOpaque(false);     

			JPanel tc7 = new JPanel();
			tc7.add(casco7.getImg());
			tc7.setBounds(47, 530, 123, 141);
			tc7.setOpaque(false);        	

			JPanel tj7 = new JPanel();
			tj7.add(jugg7.getImg());
			tj7.setBounds(47, 530, 123, 141);
			tj7.setOpaque(false); 
			
			// Hueco 8
			JPanel tn8 = new JPanel();
			tn8.add(normal8.getImg());
			tn8.setBounds(280, 530, 123, 141);
			tn8.setOpaque(false);     

			JPanel tc8 = new JPanel();
			tc8.add(casco8.getImg());
			tc8.setBounds(280, 530, 123, 141);
			tc8.setOpaque(false);        	

			JPanel tj8 = new JPanel();
			tj8.add(jugg8.getImg());
			tj8.setBounds(280, 530, 123, 141);
			tj8.setOpaque(false);   
	    	
			// Hueco 9
			JPanel tn9 = new JPanel();
			tn9.add(normal9.getImg());
			tn9.setBounds(522, 530, 123, 141);
			tn9.setOpaque(false);     

			JPanel tc9 = new JPanel();
			tc9.add(casco9.getImg());
			tc9.setBounds(522, 530, 123, 141);
			tc9.setOpaque(false);        	

			JPanel tj9 = new JPanel();
			tj9.add(jugg9.getImg());
			tj9.setBounds(522, 530, 123, 141);
			tj9.setOpaque(false);     
			
		// Cuarta fila
			// Hueco 10
			JPanel tn10 = new JPanel();
			tn10.add(normal10.getImg());
			tn10.setBounds(47, 720, 123, 141);
			tn10.setOpaque(false);     

			JPanel tc10 = new JPanel();
			tc10.add(casco10.getImg());
			tc10.setBounds(47, 720, 123, 141);
			tc10.setOpaque(false);        	

			JPanel tj10 = new JPanel();
			tj10.add(jugg10.getImg());
			tj10.setBounds(47, 720, 123, 141);
			tj10.setOpaque(false); 
			
			// Hueco 11
			JPanel tn11 = new JPanel();
			tn11.add(normal11.getImg());
			tn11.setBounds(280, 720, 123, 141);
			tn11.setOpaque(false);     

			JPanel tc11 = new JPanel();
			tc11.add(casco11.getImg());
			tc11.setBounds(280, 720, 123, 141);
			tc11.setOpaque(false);        	

			JPanel tj11 = new JPanel();
			tj11.add(jugg11.getImg());
			tj11.setBounds(280, 720, 123, 141);
			tj11.setOpaque(false);   
	    	
			// Hueco 12
			JPanel tn12 = new JPanel();
			tn12.add(normal12.getImg());
			tn12.setBounds(522, 720, 123, 141);
			tn12.setOpaque(false);     

			JPanel tc12 = new JPanel();
			tc12.add(casco12.getImg());
			tc12.setBounds(522, 720, 123, 141);
			tc12.setOpaque(false);        	

			JPanel tj12 = new JPanel();
			tj12.add(jugg12.getImg());
			tj12.setBounds(522, 720, 123, 141);
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

