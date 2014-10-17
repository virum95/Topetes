package animales.topos.jlabels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ventanas.VentanaPrincipal;
import animales.topos.TipoTopo;

public class JLabelTopete extends JLabel {

	private static final long serialVersionUID = 741001305416508022L;
	int id;
	
	public JLabelTopete( TipoTopo t ) { 
		try {
			switch (t) {
			case NORMAL:
				this.setIcon(new ImageIcon("src/img/topeteNormal.png"));
				break;
			case MASAO:
				this.setIcon(new ImageIcon("src/img/topeteMasao.png"));
				break;
			default:
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
//		super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon)getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		

        g2.drawImage( img, 0, 0, 10, 30, null );
	}
	// TODO: movimiento de salir

}
