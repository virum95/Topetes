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
						con = DriverManager.getConnection("jdbc:sqlite:bin/Score");
					}finally{

					}
					Statement stmt = con.createStatement();
					obtenerPuntuacion(stmt);
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


	public static void obtenerPuntuacion(Statement stmt) throws SQLException{
		ResultSet rs = stmt.executeQuery("SELECT * FROM TABLA ORDER BY PUNTUACION DESC");
		while(rs.next()){
			listaNombre.add(rs.getString(2));
			listaScore.add(Integer.parseInt(rs.getString(3)));
		}
		rs.close();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setBounds(100, 100, 275, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Stencil", Font.ITALIC, 16));
		lblScore.setBounds(95, 11, 92, 33);
		panel.add(lblScore);

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 262, 343);
		lblNewLabel.setIcon(new ImageIcon(VentanaScore.class.getResource("/img/fondoventanainicial.png")));
		panel.add(lblNewLabel);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/mazo.png");
		Cursor c = toolkit.createCustomCursor(imagen , new Point(frame.getX(), frame.getY()), "img");
		frame.setCursor (c);

		listaNombre = new ArrayList<String>();
		listaScore = new ArrayList<Integer>();
	}
}
