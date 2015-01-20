package ventanas;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class VentanaInicial2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial2 window = new VentanaInicial2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicial2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 278, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		//Imagen del cursor cambiar lo de dentro del getImage para que cambie 
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/Maso.png");
		final Cursor c = toolkit.createCustomCursor(imagen , new Point(0,0), "img");
		frame.setCursor (c);

		Image imagen1 = toolkit.getImage("src/img/Masogolpe.png");
		final Cursor c1 = toolkit.createCustomCursor(imagen1, new Point(0,0), "img");


		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);				
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

		JButton btnPlay = new JButton("");
		btnPlay.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
//				new VentanaInicial2();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
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
		
		btnPlay.setBounds(104, 70, 89, 23);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		panel.add(btnPlay);

		JLabel lblTopetes = new JLabel("TOPETES");
		lblTopetes.setBounds(55, 11, 46, 14);
		panel.add(lblTopetes);

		JLabel lblPlay = new JLabel("PLAY");
		lblPlay.setForeground(new Color(0, 0, 0));
		lblPlay.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblPlay.setBounds(126, 78, 64, 32);
		panel.add(lblPlay);

		JLabel lblScoreboard = new JLabel("SCORE");
		lblScoreboard.setForeground(Color.BLACK);
		lblScoreboard.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblScoreboard.setBounds(114, 104, 79, 32);
		panel.add(lblScoreboard);

		JLabel lblExit = new JLabel("EXIT");
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblExit.setBounds(126, 127, 64, 32);
		panel.add(lblExit);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaInicial2.class.getResource("/img/carte1l.png")));
		label_1.setBounds(10, 21, 238, 254);
		panel.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaInicial2.class.getResource("/img/fondoventanainicial.png")));
		label.setBounds(0, 0, 262, 329);
		panel.add(label);

		JButton button = new JButton("");
		button.setBounds(104, 93, 89, 23);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		panel.add(button);
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
				VentanaScore ventana = new VentanaScore();
				ventana.main(null);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
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
	
		JButton button_1 = new JButton("");
		button_1.setBounds(104, 120, 89, 23);
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(1);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
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
		panel.add(button_1);
	}
}
