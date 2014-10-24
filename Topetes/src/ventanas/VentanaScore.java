package ventanas;

import javax.swing.*;
import java.awt.BorderLayout;

public class VentanaScore extends JFrame{
	public VentanaScore() {
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gorka\\git\\TopetesT\\Topetes\\src\\img\\fondoventanainicial.png"));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

}
