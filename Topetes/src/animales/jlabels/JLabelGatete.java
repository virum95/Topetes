package animales.jlabels;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**	Clase para dar una imagen al gato
 * @author Gaizka
 *
 */
public class JLabelGatete extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 765237937940630316L;

	public JLabelGatete() { 
		setVisible(true);
		setIcon(new ImageIcon("src/img/gatete.png"));
		setBounds( 0, 0, 10, 30);
	}

	// Redefinición del paintComponent para que se escale y se rote el gráfico
//	@Override
//	protected void paintComponent(Graphics g) {
//		//			super.paintComponent(g);   // En este caso no nos sirve el pintado normal de un JLabel
//		Image img = ((ImageIcon)getIcon()).getImage();
//		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
//		// Escalado más fino con estos 3 parámetros:
//		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
//		// Dibujado de la imagen
//		g2.drawImage( img, 0, 0, VentanaPrincipal.getVentana().getWidth()/6, VentanaPrincipal.getVentana().getHeight()/4, null );
//	}
	// TODO: movimiento de salir

}

