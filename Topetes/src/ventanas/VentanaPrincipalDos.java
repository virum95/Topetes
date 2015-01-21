package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import javax.swing.*;

import animales.Animal;
import animales.gatos.Gatete;
import animales.topos.Topete;
import animales.topos.TipoTopo;

public class VentanaPrincipalDos {

	final int X_EJE_UNO = 47;
	final int X_EJE_DOS = 280;
	final int X_EJE_TRES = 522;

	final int Y_EJE_UNO = 160;
	final int Y_EJE_DOS = 336;
	final int Y_EJE_TRES = 530;
	final int Y_EJE_CUATRO = 710;


	static JFrame miVentana;
	static JPanel p1;
	static JPanel p2;
	static JPanel p3;
	static JPanel p4;
	static JPanel p5;
	static JPanel p6;
	static JPanel p7;
	static JLayeredPane lp;

	static JPanel panelImagen0;
	static JPanel panelImagen1;
	static JPanel panelImagen2;
	static JPanel panelImagen3;
	static JPanel panelImagen4;
	
	static String nombreJugador;

	private Animal[][] arrayAnimales = new Animal[12][4];
	private static JPanel[][] arrayPaneles = new JPanel[12][4];
	private boolean[] ocupado = new boolean[12];
	protected static int eliminados;
	protected static int puntuacion;

	public VentanaPrincipalDos () {

		puntuacion = 0;
		eliminados = 0;
		// Crear ventana inicial
		miVentana = new JFrame("Prueba de paneles de Swing");        
		// Acabar de crear y hacer visible ventana
		miVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		miVentana.setSize( 700, 755);
		miVentana.setResizable(false);
		lp = new JLayeredPane();

		for (int i = 0; i < arrayAnimales.length; i++) {
			for (int j = 0; j < arrayAnimales[i].length; j++) {
				if(j==0)
					arrayAnimales[i][j] = new Topete(TipoTopo.NORMAL);
				if(j==1)
					arrayAnimales[i][j] = new Topete(TipoTopo.CASCO);
				if(j==2)
					arrayAnimales[i][j] = new Topete(TipoTopo.JUGGERNAUT);
				if(j==3)
					arrayAnimales[i][j] = new Gatete();
			}
		}

		for (int i = 0; i < ocupado.length; i++) {
			ocupado[i]=false;
		}

//		Click de raton muestra coordenadas
//		lp.addMouseListener( new MouseAdapter() {
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println(e.getX()+" ,"+e.getY());
//
//			}
//		});

		//        Redimensionar paneles

		// Creación de los fondos 
		p1 = new JPanel();
		JLabel imagen1 = new JLabel( new ImageIcon("src/img/panel0.png"));
		p1.setBounds(-7, -7, miVentana.getWidth(), miVentana.getHeight());
		p1.add(imagen1);
		p1.setBorder(BorderFactory.createLineBorder(Color.RED));
		p1.setOpaque(false);

		p2 = new JPanel();
		JLabel imagen2 = new JLabel( new ImageIcon("src/img/panel1.png"));
		p2.setBounds(-7, 159, miVentana.getWidth(), miVentana.getHeight());
		p2.add(imagen2);
		imagen2.repaint();
		//			p2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		p2.setOpaque(false);

		p3 = new JPanel();
		JLabel imagen3 = new JLabel( new ImageIcon("src/img/panel2.png"));
		p3.setBounds(-7, 336, miVentana.getWidth(), miVentana.getHeight());
		p3.add(imagen3);
		//			p3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p3.setOpaque(false);

		p4 = new JPanel();
		JLabel imagen4 = new JLabel( new ImageIcon("src/img/panel3.png"));
		p4.setBounds(-7, 528, miVentana.getWidth(), miVentana.getHeight());
		p4.add(imagen4);
		//			p4.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		p4.setOpaque(false);

		p5 = new JPanel();
		JLabel imagen5 = new JLabel( new ImageIcon("src/img/panel4.png"));
		p5.setBounds(-7, 709, miVentana.getWidth(), miVentana.getHeight());
		p5.add(imagen5);
		//			p5.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		p5.setOpaque(false);

		// Creación de los topos
		MiRunnable miHilo = new VentanaPrincipalDos.MiRunnable();
		Thread elHilo = new Thread( miHilo );
		try {
			SwingUtilities.invokeAndWait(elHilo);
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}


		miVentana.setLayeredPane( lp );
		lp.add( p5, new Integer(40) );
		lp.add( p4, new Integer(30) );
		lp.add( p3, new Integer(20) );
		lp.add( p2, new Integer(10) );
		lp.add( p1, new Integer(0) );

		//		miVentana.setLocation(2000, 100);
		miVentana.setLocationRelativeTo(null);  // Centrar en pantalla
		miVentana.setVisible(true);

		MiRunnable2 miHilo2 = new VentanaPrincipalDos.MiRunnable2();
//		Thread elHilo2 = new Thread( miHilo2 );
//		elHilo2.start();

						miHilo2.saleTopo(arrayPaneles[0][0]);
						miHilo2.saleTopo(arrayPaneles[2][1]);
						miHilo2.saleTopo(arrayPaneles[3][2]);
						miHilo2.saleTopo(arrayPaneles[7][3]);
						try {
							Thread.sleep(7000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						miHilo2.entraTopo(arrayPaneles[0][0]);
						miHilo2.entraTopo(arrayPaneles[2][1]);
						miHilo2.entraTopo(arrayPaneles[3][2]);
						miHilo2.entraTopo(arrayPaneles[7][3]);
	}

	public Animal[][] getArrayAnimales() {
		return arrayAnimales;
	}

	public static JPanel[][] getArrayPaneles() {
		return arrayPaneles;
	}

	public boolean[] getOcupado() {
		return ocupado;
	}

	public boolean estamosLlenos(){
		for (int i = 0; i < ocupado.length; i++) {
			if(!ocupado[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new VentanaPrincipalDos();

	}

	class MiRunnable implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < arrayPaneles.length; i++) {
				for (int j = 0; j < arrayPaneles[i].length; j++) {
					arrayPaneles[i][j] = new JPanel();
					arrayPaneles[i][j].add(arrayAnimales[i][j].getImg());
					switch (i) {
					case 0:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_UNO, 123, 141);
						break;
					case 1:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_UNO, 123, 141);
						break;
					case 2:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_UNO, 123, 141);
						break;
					case 3:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_DOS, 123, 141);
						break;
					case 4:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_DOS, 123, 141);
						break;
					case 5:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_DOS, 123, 141);
						break;
					case 6:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_TRES, 123, 141);
						break;
					case 7:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_TRES, 123, 141);
						break;
					case 8:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_TRES, 123, 141);
						break;
					case 9:
						arrayPaneles[i][j].setBounds(X_EJE_UNO, Y_EJE_CUATRO, 123, 141);
						break;
					case 10:
						arrayPaneles[i][j].setBounds(X_EJE_DOS, Y_EJE_CUATRO, 123, 141);
						break;
					case 11:
						arrayPaneles[i][j].setBounds(X_EJE_TRES, Y_EJE_CUATRO, 123, 141);
						break;
					default:
						break;
					}
					arrayPaneles[i][j].setOpaque(false);     
				}
			}

			for (int i = 0; i < arrayPaneles.length; i++) {
				for (int j = 0; j < arrayPaneles[i].length; j++) {
					if (i < 3) 
						lp.add( arrayPaneles[i][j], new Integer(5));
					else if (i < 6)
						lp.add( arrayPaneles[i][j], new Integer(15));
					else if (i < 9)
						lp.add( arrayPaneles[i][j], new Integer(25));
					else 
						lp.add( arrayPaneles[i][j], new Integer(35));

				}
			}
		}
	}
	class MiRunnable2 implements Runnable {

		private boolean sigue = true;

		@Override
		public void run() {
			while(sigue){
				if(!estamosLlenos()){
					creaAnimal();
					try {
						Thread.sleep( 1200 );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				for (int i = 0; i < arrayAnimales.length; i++) {
					for (int j = 0; j < arrayAnimales[i].length; j++) {
						// Si el topo está más tiempo del que puede estar fuera
						if( getArrayAnimales()[i][j].getFechaCreacion() != 0 ){
							if( System.currentTimeMillis() - getArrayAnimales()[i][j].getFechaCreacion() >= 3000){
								quitaAnimal( i, j ); // Quitamos el topo
								getArrayAnimales()[i][j].setFechaCreacion(0); // Ponemos la fecha de creacion a 0
								// Sumamos uno a los eliminados si son menos de dos
								if( eliminados < 200 )
									eliminados++;
								else
									acaba();
							}
						}
					}
				}

				//TODO: Golpe de maso quita topo y suma puntuacion

			}

			nombreJugador = 
					JOptionPane.showInputDialog(null,
			"Fin del Juego. Tu puntuacion final ha sido de "+VentanaPrincipal.getVentana().puntuacion+". Introduce el nombre del jugador:",
			"Game Over",
			JOptionPane.INFORMATION_MESSAGE);


		}
		
		public void cargaEnBD()
		{
			try {
				Class.forName("org.sqlite.JDBC");
				Connection con = null;
				try {
					con = DriverManager.getConnection("jdbc:sqlite:bin/Score");
				}finally{

				}
				Statement stmt = con.createStatement();
				String string = "INSERT INTO TABLA VALUES ('"+nombreJugador+"', "+VentanaPrincipal.getVentana().puntuacion+")";
				stmt.executeUpdate(string);
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		public void creaAnimal () {
			int j = 0;
			int i;
			do{
				Random r = new Random();
				i = r.nextInt(100);
				if(i<71){
					j = 0; //40
				}else if (i>70 && i <91) {
					j = 1;//15
				}else if (i>90) {
					j = 2;//15
				}
				i = r.nextInt(12);
			}while(getOcupado()[i]);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
			saleTopo(getArrayPaneles()[i][j]);
			ocupado[i] = true;
			getArrayAnimales()[i][j].setFechaCreacion(System.currentTimeMillis());
			getArrayAnimales()[i][j].setFuera(true);
		}

		public void quitaAnimal( int panel, int animal){
			entraTopo(getArrayPaneles()[panel][animal]);
			getArrayAnimales()[panel][animal].setFuera(false);
			ocupado[panel] = false;
		}

		public void saleTopo( JPanel j ){
			int posInicial = (int)j.getLocation().getY();
			saleTopoRec(j, posInicial);
		}

		private void saleTopoRec( JPanel j, int posInicial ){
			int posActual = (int)j.getLocation().getY();
			if(  posInicial - posActual >= 135 ){
			}else {
				j.setLocation((int)j.getLocation().getX(), posActual-1);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				saleTopoRec(j, posInicial);
			}
		}

		public void entraTopo( JPanel j ){
			int posInicial = (int)j.getLocation().getY();
			entraTopoRec(j, posInicial);
			
		}

		/** Metodo recursivo que hace que los topos vuelvan a entrar
		 * @param j
		 * @param posInicial
		 */
		private void entraTopoRec( JPanel j, int posInicial ){
			int posActual = (int)j.getLocation().getY();
			if(  posActual - posInicial >= 135 ){
			}else {
				j.setLocation((int)j.getLocation().getX(), posActual+1);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				entraTopoRec(j, posInicial);
			}
		}
		public void acaba(){
			sigue = false;
		}

	}

}



