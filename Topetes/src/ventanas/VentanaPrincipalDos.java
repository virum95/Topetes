package ventanas;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

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

    static JPanel panelImagen0;
    static JPanel panelImagen1;
    static JPanel panelImagen2;
    static JPanel panelImagen3;
    static JPanel panelImagen4;
    
    static JLabel fondo0 = new JLabel(new ImageIcon("src/img/panel0.png"));
    
    static Topete normal1 = new Topete(TipoTopo.CASCO);
    static Topete normal2 = new Topete(TipoTopo.CASCO);
    static Topete normal3 = new Topete(TipoTopo.JUGGERNAUT);
    static Topete normal4 = new Topete(TipoTopo.CASCO);
    static Topete normal5 = new Topete(TipoTopo.CASCO);
    static Topete normal6 = new Topete(TipoTopo.CASCO);
    static Topete normal7 = new Topete(TipoTopo.CASCO);
    static Topete normal8 = new Topete(TipoTopo.CASCO);
    static Topete normal9 = new Topete(TipoTopo.NORMAL);
    
    
    public VentanaPrincipalDos () {
    	
    	// Crear ventana inicial
        miVentana = new JFrame("Prueba de paneles de Swing");        
        // Acabar de crear y hacer visible ventana
        miVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        miVentana.setSize( 720, 760 );
        miVentana.addMouseListener( new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX()+" ,"+e.getY());
				
			}
		});

        
        
        // Creación de los fondos 
        p1 = new JPanel();
			JLabel imagen1 = new JLabel( new ImageIcon("src/img/panel0.png"));
        	p1.setBounds(0, 0, miVentana.getHeight(), miVentana.getWidth());
        	p1.add(imagen1);
//        	p1.setBorder(BorderFactory.createLineBorder(Color.RED));
        	p1.setOpaque(false);
        	
//        p2 = new JPanel();
//			JLabel imagen2 = new JLabel( new ImageIcon("src/img/panel1.png"));
//    		p2.setBounds(0, miVentana.getHeight()/4, miVentana.getWidth(), miVentana.getHeight());
//    		p2.add(imagen2);
////			p2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        	p2.setOpaque(false);
//
//        p3 = new JPanel();
//			JLabel imagen3 = new JLabel( new ImageIcon("src/img/panel2.png"));
//    		p3.setBounds(0, miVentana.getHeight()/2, miVentana.getWidth(), 760);
//    		p3.add(imagen3);
////			p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        	p3.setOpaque(false);
//
//		p4 = new JPanel();
//			JLabel imagen4 = new JLabel( new ImageIcon("src/img/panel3.png"));
//    		p4.setBounds(0, 3*miVentana.getHeight()/4, miVentana.getWidth(), 760);
//    		p4.add(imagen4);
////			p4.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
//        	p4.setOpaque(false);
//
//		p5 = new JPanel();
//			JLabel imagen5 = new JLabel( new ImageIcon("src/img/panel4.png"));
//	    	p5.setBounds(0, 705, 740, 760);
//	    	p5.add(imagen5);
////			p5.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
//        	p5.setOpaque(false);

        	// Creación de los topos
        	

//        	panelImagen1 = new JPanel();
//        		panelImagen1.setBounds(0, 0, 740, 760);
//        		normal1.getImg().setBounds(0, 0, normal1.getImg().getWidth(), normal1.getImg().getHeight());


        		panelImagen1.add(normal1.getImg());
//        		panelImagen1.add(normal3.getImg());
//        		panelImagen1.add(normal9.getImg());
        	


		JLayeredPane lp = new JLayeredPane();
		
		miVentana.setLayeredPane( lp );
//        			
//		lp.add( p5, new Integer(40) );
//		lp.add( p4, new Integer(30) );
//		lp.add( p3, new Integer(20) );
//		lp.add( p2, new Integer(10) );
//		lp.add(panelImagen1, new Integer(5));
		lp.add( p1, new Integer(0) );
		

        miVentana.setLocationRelativeTo(null);  // Centrar en pantalla
        miVentana.setVisible(true);
        
       
    }
	
    public static void main(String[] args) {
		new VentanaPrincipalDos();
	}
	
}
