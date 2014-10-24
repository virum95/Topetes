package ventanas;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaInicial extends JFrame{
	private static final long serialVersionUID = -1666529138806121763L;

	public VentanaInicial() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(262,343);
		setResizable(false);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("src/img/botonEXIT.png"));
		btnNewButton.setBounds(64, 123, 121, 33);
		btnNewButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(1);				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		getContentPane().add(btnNewButton);
		
		//Imagen del cursor cambiar lo de dentro del getImage para que cambie 
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Image imagen = toolkit.getImage("src/img/mazoSinFondo.png");
		 Cursor c = toolkit.createCustomCursor(imagen , new Point(getContentPane().getX(), getContentPane().getY()), "img");
		 getContentPane().setCursor (c);
		 
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("src/img/botonSCORE.png"));
		btnNewButton_1.setBounds(64, 78, 121, 33);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon("src/img/botonPLAY.png"));
		btnNewButton_2.setBounds(64, 38, 121, 29);
		btnNewButton_2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				VentanaPrincipal ventana = new VentanaPrincipal();
				ventana.miHilo = new MiRunnable();  // Sintaxis de new para clase interna
				Thread nuevoHilo = new Thread( ventana.miHilo );
				nuevoHilo.start();
				dispose();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src/img/fondoventanainicial.png"));
		lblNewLabel.setBounds(0, 0, 254, 333);
		getContentPane().add(lblNewLabel);
		
		setVisible(true);
		repaint();
		getContentPane().validate();
		getContentPane().repaint();
	}
	
	public static void main(String[] args) {
		new VentanaInicial();
	}
}
