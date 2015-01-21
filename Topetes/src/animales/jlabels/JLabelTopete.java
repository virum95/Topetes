package animales.jlabels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ventanas.VentanaPrincipal;
import animales.topos.TipoTopo;

public class JLabelTopete extends JLabel {

	private static final long serialVersionUID = 741001305416508022L;
	protected TipoTopo tipo;

	public JLabelTopete( TipoTopo t ) { 
		setBorder( BorderFactory.createLineBorder( Color.red ));
		tipo = t;
		try {
			switch (t) {
			case NORMAL:
				this.setIcon(new ImageIcon("src/img/topeteNormal.png"));
				break;
			case CASCO:
				this.setIcon(new ImageIcon("src/img/topeteCasco.png"));
				break;
			case JUGGERNAUT:
				this.setIcon(new ImageIcon("src/img/topeteJuggernaut.png"));
				break;
			}
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: topete1.png no encontrado" );
			e.printStackTrace();
		}
		setVisible(true);
		setBounds( 0, 0, 10, 30);
	}

	//	 Redefinición del paintComponent para que se escale el gráfico
	@Override
	protected void paintComponent(Graphics g) {
		setSize( (int)(VentanaPrincipal.getVentana().getWidth()*0.15), (int)(VentanaPrincipal.getVentana().getHeight()*0.25));
		//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Graphics2D g2 = (Graphics2D) g;
		// setIcon( new ImageIcon("src/img/topeteNormal.png") );
		Image img = ((ImageIcon)getIcon()).getImage();;
//		switch (tipo) {
//		case NORMAL:
//			img = new ImageIcon("src/img/topeteNormal.png").getImage();
//			break;
//		case PINCHO:
//			img = new ImageIcon("src/img/topeteMasao.png").getImage();
//			break;
//		case CASCO:
//			img = new ImageIcon("src/img/topeteCasco.png").getImage();
//			break;
//		case JUGGERNAUT:
//			img = new ImageIcon("src/img/topeteJugernautRN.png").getImage();
//			break;
//		case BOSS:
//			img = null;
//			this.setText("Boss");
//			break;
//		default:
//			img = null;
//			break;
//		}
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	

		g2.drawImage( img, 0, 0, VentanaPrincipal.getVentana().getWidth()/6, VentanaPrincipal.getVentana().getHeight()/4, null );
	}
	// TODO: movimiento de salir

}
