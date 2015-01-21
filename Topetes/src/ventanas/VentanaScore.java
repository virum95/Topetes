package ventanas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class VentanaScore {

	private JFrame frame;
	public static ArrayList<String> listaNombre;
	public static ArrayList<Integer> listaScore;
	public static JLabel label;
	public static JLabel label_1;
	public static JLabel label_2;
	public static JLabel label_3;
	public static JLabel label_4;
	public static JLabel label_5;
	public static JLabel label_6;
	public static JLabel label_7;
	public static JLabel label_8;
	public static JLabel label_9;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaScore window = new VentanaScore();
					window.frame.setVisible(true);
					Class.forName("org.sqlite.JDBC");
					Connection con = null;
					try {
						con = DriverManager
								.getConnection("jdbc:sqlite:bin/Score");
					} finally {

					}
					Statement stmt = con.createStatement();
					obtenerPuntuacion(stmt);
					try {
						label.setText(listaNombre.get(0));
						label_5.setText(listaScore.get(0).toString());
						label_1.setText(listaNombre.get(1));
						label_6.setText(listaScore.get(1).toString());
						label_2.setText(listaNombre.get(2));
						label_7.setText(listaScore.get(2).toString());
						label_3.setText(listaNombre.get(3));
						label_8.setText(listaScore.get(3).toString());
						label_4.setText(listaNombre.get(4));
						label_9.setText(listaScore.get(4).toString());
					} catch (Exception e) {
						System.out.println("No hay tantas puntuaciones.");
					}

					stmt.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaScore() {
		initialize();
	}

	public static void obtenerPuntuacion(Statement stmt) throws SQLException {
		ResultSet rs = stmt
				.executeQuery("SELECT * FROM TABLA ORDER BY PUNTUACION DESC");
		while (rs.next()) {
			listaNombre.add(rs.getString(1));
			listaScore.add(Integer.parseInt(rs.getString(2)));
		}
		rs.close();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setBounds(100, 100, 275, 380);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Imagen del cursor cambiar lo de dentro del getImage para que cambie
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/Maso.png");
		final Cursor c = toolkit.createCustomCursor(imagen, new Point(7, 25),
				"img");
		frame.setCursor(c);

		Image imagen1 = toolkit.getImage("src/img/Masogolpe.png");
		final Cursor c1 = toolkit.createCustomCursor(imagen1, new Point(7, 25),
				"img");

		// Panel principal
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Label SCORE de arriba
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Stencil", Font.ITALIC, 26));
		lblScore.setBounds(73, 11, 113, 33);
		panel.add(lblScore);

		// Labels de carga de las puntuaciones
		label = new JLabel();
		label.setBounds(27, 50, 64, 14);
		panel.add(label);

		label_1 = new JLabel();
		label_1.setBounds(27, 80, 64, 14);
		panel.add(label_1);

		label_2 = new JLabel();
		label_2.setBounds(27, 110, 63, 14);
		panel.add(label_2);

		label_3 = new JLabel();
		label_3.setBounds(27, 140, 63, 14);
		panel.add(label_3);

		label_4 = new JLabel();
		label_4.setBounds(27, 170, 63, 14);
		panel.add(label_4);

		label_5 = new JLabel();
		label_5.setBounds(147, 50, 91, 14);
		panel.add(label_5);

		label_6 = new JLabel();
		label_6.setBounds(147, 80, 91, 14);
		panel.add(label_6);

		label_7 = new JLabel();
		label_7.setBounds(147, 110, 91, 14);
		panel.add(label_7);

		label_8 = new JLabel();
		label_8.setBounds(147, 140, 91, 14);
		panel.add(label_8);

		label_9 = new JLabel();
		label_9.setBounds(147, 170, 91, 14);
		panel.add(label_9);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(VentanaScore.class
				.getResource("/img/cartelbueno.png")));
		label_10.setBounds(157, 195, 102, 74);
		panel.add(label_10);

		// Boton invisible del cartel de BACK
		JButton btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(179, 195, 57, 59);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
				frame.dispose();
				VentanaInicial.main(null);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
			}
		});
		
		JLabel lblReset = new JLabel("");
		lblReset.setIcon(new ImageIcon(VentanaScore.class.getResource("/img/reset.png")));
		lblReset.setBounds(5, 195, 81, 80);
		panel.add(lblReset);
		
		//Boton Reset
		JButton btnReset = new JButton("");
		btnReset.setBounds(5, 208, 74, 46);
		btnReset.setOpaque(false);
		btnReset.setContentAreaFilled(false);
		btnReset.setBorderPainted(false);
		panel.add(btnReset);
		btnReset.addMouseListener(new MouseAdapter()  {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setCursor(c);
				try {
					Class.forName("org.sqlite.JDBC");
					Connection con = null;
					try {
						con = DriverManager
								.getConnection("jdbc:sqlite:bin/Score");
					} finally {

					}
					Statement stmt = con.createStatement();
					String s1 = "DELETE FROM TABLA";
					stmt.executeUpdate(s1);
					stmt.close();
					con.close();
					obtenerPuntuacion(stmt);				
				} catch (Exception a) {
				}
				frame.repaint();
				frame.revalidate();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setCursor(c1);
				
			}
		});
		

		// Jlabel con la imagen de fondo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 262, 343);
		lblNewLabel.setIcon(new ImageIcon(VentanaScore.class
				.getResource("/img/fondoventanainicial.png")));
		panel.add(lblNewLabel);

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

		listaNombre = new ArrayList<String>();
		listaScore = new ArrayList<Integer>();
	}
}