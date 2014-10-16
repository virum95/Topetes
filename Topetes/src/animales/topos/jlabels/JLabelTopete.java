package animales.topos.jlabels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelTopete extends JLabel {

	private static final long serialVersionUID = 741001305416508022L;
	int id;
	
	public JLabelTopete() { 
		try {
			this.setIcon(new ImageIcon("src/img/topete1.png"));
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: topete1.png no encontrado" );
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	// TODO: movimiento de salir

}
