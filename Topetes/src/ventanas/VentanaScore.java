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
			String line = br.readLine();
			while(line != null){
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
			readFile("score.txt");
			for (String string : listaScore) {
				JLabel jlscore = new JLabel(string);
				asd.add(jlscore);
				jlscore.setVisible(true);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
