package ventanas;

import javax.swing.*;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaScore extends JFrame{
	private static final long serialVersionUID = 5698851881550879542L;
	public static ArrayList<String> listaScore;

	public VentanaScore() {
		JLabel lblNewLabel = new JLabel();
//		lblNewLabel.setIcon(new ImageIcon("src/img/fondoventanainicial.png"));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setSize(262,370);
		setVisible(true);
		setResizable(false);
		listaScore = new ArrayList<String>();

	}

	public static void readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			String line = null;
			while((line = br.readLine())!= null){
				listaScore.add(line);
				}


		//	        while (line != null) {
		//	            sb.append(line);
		//	            sb.append("\n");
		//	            line = br.readLine();
		//	        }
		//	        return sb.toString();
			    } finally {
			        br.close();
			    }
	}

	public static void main(String[] args) {
		VentanaScore asd = new VentanaScore();
		try {
			readFile("C:/Users/Eva/git/Topetes/Topetes/score.txt");
			for (String string : listaScore) {
				JLabel jlscore = new JLabel();
				asd.add(jlscore);
			}
			
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
