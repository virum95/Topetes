package ventanas;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class VentanaPrincipalDos{
	  static JFrame miVentana;
	    static JPanel p1;
	    static JPanel p2;
	    static JPanel p3;
	    static JPanel p4;
	    static JPanel p5;
	    static JPanel p6;
	    static JPanel p7;
	public VentanaPrincipalDos ()
	{
//		JFrame frame = new JFrame();
//		
// 		JLayeredPane lp = new JLayeredPane();
//
// 		JPanel panel1 = new JPanel();
//			JLabel imagen1 = new JLabel(new ImageIcon("src/img/panel0.png"));
//			panel1.add(imagen1);
//		JPanel panel2 = new JPanel();
//			JLabel imagen2 = new JLabel(new ImageIcon("src/img/panel1.png"));
//			panel2.add(imagen2);
//		JPanel panel3 = new JPanel();
//			JLabel imagen3 = new JLabel(new ImageIcon("src/img/panel2.png"));
//			panel3.add(imagen3);
//		JPanel panel4 = new JPanel();
//			JLabel imagen4 = new JLabel(new ImageIcon("src/img/panel3.png"));
//			panel4.add(imagen4);
//		JPanel panel5 = new JPanel();
//			JLabel imagen5 = new JLabel(new ImageIcon("src/img/panel4.png"));
//			panel5.add(imagen5);
//
//			frame.setLayeredPane(lp);
//			
//			lp.add(panel5, new Integer(4));
//			lp.add(panel4, new Integer(3));
//			lp.add(panel3, new Integer(2));
//			lp.add(panel2, new Integer(1));
//			lp.add(panel1, new Integer(0));
//			
//			frame.setVisible(true);
		
		miVentana = new JFrame();
		 p1 = new JPanel();
     	p1.setName( "p1" );
			p1.setBorder( BorderFactory.createMatteBorder( 2, 5, 2, 5, Color.green ) );
			p1.setBounds( 10, 10, 400, 150 );
     p2 = new JPanel();
     	p2.setName( "p2" );
 		Border b2 = BorderFactory.createBevelBorder( BevelBorder.RAISED );
 		p2.setBorder( b2 );
			p2.setBounds( 30, 30, 400, 150 );
     p3 = new JPanel();
     	p3.setName( "p3" );
 		Border b3 = BorderFactory.createEtchedBorder();
 		p3.setBorder( b3 );
			p3.setBounds( 50, 50, 400, 150 );
		p4 = new JPanel();
			p4.setName( "p4" );
 		p4.setBorder( BorderFactory.createLineBorder( Color.red ) );
			p4.setBounds( 70, 70, 400, 150 );
		p5 = new JPanel();
			p5.setName( "p5" );
 		p5.setBorder( BorderFactory.createLoweredBevelBorder() );
			p5.setBounds( 90, 90, 400, 150 );
		p6 = new JPanel();
 		p6.setName( "p6" );
 		p6.setBorder( BorderFactory.createRaisedBevelBorder() );
			p6.setBounds( 110, 110, 400, 150 );
		p7 = new JPanel();
			p7.setName( "p7" );
 		Border b7 = BorderFactory.createCompoundBorder(
                 BorderFactory.createTitledBorder("Nombre de panel"),
                 BorderFactory.createEmptyBorder(5,5,5,5));
     		p7.setBorder( b7 );
 		p7.setBounds( 130, 130, 400, 150 );
 	miVentana.getContentPane().setName( "princ" );
 			
		p1.add( new JLabel("[CRISTAL] Ejemplo de panel con borde matte (verde)") );
		p1.setOpaque( false );
		p2.add( new JLabel("[2] Ejemplo de panel con borde Bevel") );
		p3.add( new JLabel("[3] Ejemplo de panel con borde etched") );
		p4.add( new JLabel("[4] Ejemplo de panel con borde line (rojo)") );
		p5.add( new JLabel("[5] Ejemplo de panel con borde lowered") );
		p6.add( new JLabel("[6] Ejemplo de panel con borde raised") );
		p7.add( new JLabel(new ImageIcon("src/img/panel0.png")));

		JLayeredPane lp = new JLayeredPane();
		
		miVentana.setLayeredPane( lp );
		p7.setOpaque( false );
     			
		lp.add( p7, new Integer(7) );
		lp.add( p6, new Integer(6) );
		lp.add( p5, new Integer(5) );
		lp.add( p4, new Integer(-4) );
		lp.add( p3, new Integer(3) );
		lp.add( p2, new Integer(2) );

		JPanel cristal = new JPanel();
		cristal.setLayout( null );
		miVentana.setGlassPane( cristal );
		cristal.add( p1 );
		cristal.setOpaque( false );
		cristal.setVisible( true );
		
     miVentana.setSize( 600, 500 );
     miVentana.setLocationRelativeTo(null);  // Centrar en pantalla
     miVentana.setVisible(true);
	}
	

	
	public static void main(String[] args) {
		new VentanaPrincipalDos();
	}
	
	
}
