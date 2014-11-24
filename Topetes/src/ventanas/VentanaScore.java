package ventanas;

import javax.swing.*;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VentanaScore extends JFrame{
	private static final long serialVersionUID = 5698851881550879542L;
	private static VentanaScore ventana;
	public static ArrayList<String> listaNombre;
	public static ArrayList<Integer> listaScore;
	public static ArrayList<JLabel> listaLabel;

	public static VentanaScore getventana() {
		if(ventana == null){
			ventana = new VentanaScore();
			JLabel lblNewLabel = new JLabel();
//			lblNewLabel.setIcon(new ImageIcon("src/img/fondoventanainicial.png"));
			ventana.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
			ventana.setSize(262,370);
			ventana.setVisible(true);
			ventana.setResizable(false);
			listaScore = new ArrayList<Integer>();
			listaNombre = new ArrayList<String>();
			listaLabel = new ArrayList<JLabel>();
			ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		return ventana;

	}

	public static void obtenerPuntuacion(Statement stmt) throws SQLException{
		ResultSet rs = stmt.executeQuery("SELECT * FROM TABLA ORDER BY PUNTUACION DESC");
		while(rs.next()){
			listaNombre.add(rs.getString(2));
			listaScore.add(Integer.parseInt(rs.getString(3)));
			System.out.println(listaNombre);
			System.out.println(listaScore);
		}
		rs.close();
	}
	
	public void anyadeJlabel() {
	
		

	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		getventana();
		Class.forName("org.sqlite.JDBC");
		Connection con = null;
		try {
		con = DriverManager.getConnection("jdbc:sqlite:bin/Score");
		}finally{
			
		}
		Statement stmt = con.createStatement();
		obtenerPuntuacion(stmt);
		stmt.close();
		con.close();

	}
}
