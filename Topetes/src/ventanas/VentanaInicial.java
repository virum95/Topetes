package ventanas;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

public class VentanaInicial {

	private JFrame frame;
	static Thread t;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial window = new VentanaInicial();
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
	public VentanaInicial() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 278, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel principal
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Imagen del cursor cambiar lo de dentro del getImage para que cambie
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/Maso.png");
		final Cursor c = toolkit.createCustomCursor(imagen, new Point(7, 25),
				"img");
		frame.setCursor(c);

		Image imagen1 = toolkit.getImage("src/img/Masogolpe.png");
		final Cursor c1 = toolkit.createCustomCursor(imagen1, new Point(7, 25),
				"img");

		// Cambia el cursor cada vez que se clica
		frame.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
			}
		});

		// Label de TOPETES (arriba del todo)
		JLabel lblTopetes = new JLabel("TOPETES");
		lblTopetes.setFont(new Font("Stencil", Font.PLAIN, 37));
		lblTopetes.setBounds(46, 0, 202, 49);
		panel.add(lblTopetes);

		// Label de PLAY
		JLabel lblPlay = new JLabel("PLAY");
		lblPlay.setForeground(new Color(0, 0, 0));
		lblPlay.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblPlay.setBounds(126, 78, 64, 32);
		panel.add(lblPlay);

		// Label de SCORE
		JLabel lblScoreboard = new JLabel("SCORE");
		lblScoreboard.setForeground(Color.BLACK);
		lblScoreboard.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblScoreboard.setBounds(119, 104, 74, 32);
		panel.add(lblScoreboard);

		// Label de EXIT
		JLabel lblExit = new JLabel("EXIT");
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("Stencil", Font.PLAIN, 17));
		lblExit.setBounds(126, 127, 64, 32);
		panel.add(lblExit);

		// Label con el cartel
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaInicial.class
				.getResource("/img/carte1l.png")));
		label_1.setBounds(10, 21, 238, 254);
		panel.add(label_1);

		// Label con el fondo de la ventana
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaInicial.class
				.getResource("/img/fondoventanainicial.png")));
		label.setBounds(0, 0, 262, 329);
		panel.add(label);

		// Los botones estan invisibles detras de los dibujos y los de arriba
		// son jlabels
		// Boton de play
		JButton btnPlay = new JButton("");
		btnPlay.setBounds(104, 78, 89, 23);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		panel.add(btnPlay);

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				t = new Thread(new Runnable() {
					@Override
					public void run() {
						new VentanaPrincipalDos(frame);
					}

				});
				t.start();
				frame.setCursor(c);
				frame.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
			}
		});

		// Boton de scoreboard
		JButton button = new JButton("");
		button.setBounds(104, 104, 89, 32);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
				VentanaScore.main(null);
				frame.dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
			}
		});

		// Boton de Exit
		JButton button_1 = new JButton("");
		button_1.setBounds(104, 136, 89, 23);
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				System.exit(1);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
			}
		});
		panel.add(button_1);
	}
}