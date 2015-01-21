package ventanas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
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

public class VentanaPrincipalDos{

	protected final int X_EJE_UNO = 47;
	protected final int X_EJE_DOS = 280;
	protected final int X_EJE_TRES = 522;

	protected final int Y_EJE_UNO = 160;
	protected final int Y_EJE_DOS = 336;
	protected final int Y_EJE_TRES = 530;
	protected final int Y_EJE_CUATRO = 710;

	protected final int MAX_TOPOS_PERDIDOS = 3;
	protected final int TIEMPO_FUERA_TOPO = 3; //Tiempo en segundos


	protected static JFrame miVentana;
	protected static JPanel p1;
	protected static JPanel p2;
	protected static JPanel p3;
	protected static JPanel p4;
	protected static JPanel p5;
	protected static JLayeredPane lp;

	protected static JPanel panelImagen0;
	protected static JPanel panelImagen1;
	protected static JPanel panelImagen2;
	protected static JPanel panelImagen3;

	protected static JLabel x1 = new JLabel( new ImageIcon("src/img/x.png"));
	protected static JLabel x2 = new JLabel( new ImageIcon("src/img/x.png"));
	protected static JLabel x3 = new JLabel( new ImageIcon("src/img/x.png"));
	protected static JPanel px1;
	protected static JPanel px2;
	protected static JPanel px3;
	protected static JPanel pPuntuacion;
	protected static JLabel lPuntuacion;


	static String nombreJugador;

	protected Animal[][] arrayAnimales = new Animal[12][4];
	protected static JPanel[][] arrayPaneles = new JPanel[12][4];
	protected boolean[] ocupado = new boolean[12];

	protected static int eliminados;
	protected static int puntuacion;
	protected static boolean sigue= true;
	protected static JFrame ventanaInicial;


	public VentanaPrincipalDos (JFrame frame) {

		ventanaInicial = frame;
		puntuacion = 0;
		eliminados = 0;
		lPuntuacion = new JLabel("Puntuación: "+puntuacion);
		lPuntuacion.setFont(new Font("Stencil", Font.PLAIN, 14));
		pPuntuacion = new JPanel();
		pPuntuacion.setBounds(5, 5, 200, 100);
		pPuntuacion.add(lPuntuacion);
		pPuntuacion.setOpaque(false);

		// Crear ventana inicial
		miVentana = new JFrame("Topetes");        
		// Acabar de crear y hacer visible ventana
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		miVentana.setSize( 700, 755);
		miVentana.setResizable(false);
		lp = new JLayeredPane();
		miVentana.setLayeredPane( lp );


		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/Maso.png");
		final Cursor c = toolkit.createCustomCursor(imagen , new Point(7,25), "img");
		miVentana.setCursor (c);

		Image cursor = toolkit.getImage("src/img/Masogolpe.png");
		final Cursor c1 = toolkit.createCustomCursor(cursor, new Point(7,25), "img");


		final MiRunnable2 miHilo2 = new VentanaPrincipalDos.MiRunnable2();
		final MiRunnable3 miHilo3 = new VentanaPrincipalDos.MiRunnable3();

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

				if(arrayAnimales[i][j] instanceof Topete)
				{
					final int a = i;
					final int b = j;
					arrayAnimales[i][j].getImg().addMouseListener(new MouseAdapter()
					{

						@Override
						public void mousePressed(MouseEvent arg0) {
							miVentana.setCursor(c1);
							((Topete)arrayAnimales[a][b]).pegaTopo();

							if(((Topete)arrayAnimales[a][b]).getVidas() == 0){
								miHilo3.quitaAnimal(a,b);
								getArrayAnimales()[a][b].setFechaCreacion(0); // Ponemos la fecha de creacion a 0
								puntuacion+=((Topete)arrayAnimales[a][b]).getPuntos();
								lPuntuacion.setText("Puntuación: "+puntuacion);
								if(((Topete)arrayAnimales[a][b]).getTipo() == TipoTopo.NORMAL)
									((Topete)arrayAnimales[a][b]).setVidas(1);
								if(((Topete)arrayAnimales[a][b]).getTipo() == TipoTopo.CASCO)
									((Topete)arrayAnimales[a][b]).setVidas(2);
								if(((Topete)arrayAnimales[a][b]).getTipo() == TipoTopo.JUGGERNAUT)
									((Topete)arrayAnimales[a][b]).setVidas(3);

							}
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							miVentana.setCursor(c);
						}

					});
				}
				if(arrayAnimales[i][j] instanceof Gatete)
				{

					arrayAnimales[i][j].getImg().addMouseListener(new MouseAdapter()
					{
						@Override
						public void mousePressed(MouseEvent arg0) {
							sigue = false;
							miVentana.setCursor(c1);
						}

						@Override
						public void mouseReleased(MouseEvent arg0) {
							miVentana.setCursor(c);
						}

					});
				}
			}
		}

		for (int i = 0; i < ocupado.length; i++) {
			ocupado[i]=false;
		}

		//				Click de raton muestra coordenadas
		//		miVentana.addMouseListener( new MouseAdapter() {
		//
		//			@Override
		//			public void mousePressed(MouseEvent e) {
		//				System.out.println(e.getX()+", "+e.getY());
		//			}
		//
		//		});

		px1 = new JPanel();
		px1.setBounds(560, 10, 70, 70);
		px1.add(x1);
		px1.setOpaque(false);
		px2 = new JPanel();
		px2.setBounds(580, 12, 70, 70);
		px2.add(x2);
		px2.setOpaque(false);
		px3 = new JPanel();
		px3.setBounds(600, 14, 70, 70);
		px3.add(x3);
		px3.setOpaque(false);
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


		lp.add( pPuntuacion, new Integer(60) );
		lp.add( p5, new Integer(40) );
		lp.add( p4, new Integer(30) );
		lp.add( p3, new Integer(20) );
		lp.add( p2, new Integer(10) );
		lp.add( p1, new Integer(0) );

		//		miVentana.setLocation(2000, 100);
		miVentana.setLocationRelativeTo(null);  // Centrar en pantalla
		miVentana.setVisible(true);

		Thread elHilo2 = new Thread( miHilo2 );
		elHilo2.start();

		Thread elHilo3 = new Thread( miHilo3 );
		elHilo3.start();
	}

	/** Método que devuelve el array de Animales
	 * @return array de animales
	 */
	public Animal[][] getArrayAnimales() {
		return arrayAnimales;
	}

	/** Método que devuelve el array de los paneles
	 * @return array que contiene los paneles
	 */
	public static JPanel[][] getArrayPaneles() {
		return arrayPaneles;
	}

	/** Método que devuelve el array de las casillas ocupadas
	 * @return array de las casillas ocupadas
	 */
	public boolean[] getOcupado() {
		return ocupado;
	}

	/** Metodo que comprueba si todas las casillas estan llenas
	 * @return true	 - Todas las casillas llenas
	 * 		   false - Hay alguna casilla que no esta llena
	 */
	public boolean estamosLlenos(){
		for (int i = 0; i < ocupado.length; i++) {
			if(!ocupado[i])
				return false;
		}
		return true;
	}


	/** Clase que permite lanzar un hilo para introducir todos los animales en 
	 * 	la ventana. Se hace en un hilo para que el hilo principal espere a que 
	 * 	esten todos creados
	 * @author Gaizka
	 *
	 */
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

		@Override
		public void run() {
			while(sigue){
				if(1200-puntuacion>=100)
				{
					if(!estamosLlenos()){
						creaAnimal();
						try {
							Thread.sleep( 200 );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				else{
					int tiempo = 1200 - puntuacion*2;
					if( tiempo < 0 )
						tiempo = 1;
					if(!estamosLlenos()){
						creaAnimal();
						try {
							Thread.sleep( tiempo );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			acaba();
		}



		public void acaba(){
			sigue = false;
		}


		/**	Método que hace que salga un animal. Elige aleatoriamente uno de los topos
		 * 	Las posibilidades son:
		 * 		60% para el topo normal
		 * 		20% para el topo con casco
		 * 		10% para el gato y para el topo negro
		 */
		public void creaAnimal() {

			int j = 0;
			int i;
			do{
				Random r = new Random();
				i = r.nextInt(100);
				if(i<61){
					j = 0; //60
				} else if (i>60 && i<71){
					j = 3; //10
				}else if (i>70 && i <91) {
					j = 1;//20
				}else if (i>90) {
					j = 2;//10
				}
				i = r.nextInt(12);
			}while(getOcupado()[i]);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
			saleTopo(i, j);
			ocupado[i] = true;
			getArrayAnimales()[i][j].setFechaCreacion(System.currentTimeMillis());
			getArrayAnimales()[i][j].setFuera(true);
		}

		/**	Método que hace que los topos se muevan hacia arriba. LLama a un metodo 
		 * 	recursivo para que el movimiento sea poco a poco
		 * @param j
		 */
		public void saleTopo( int panel, int animal ){
			JPanel j = getArrayPaneles()[panel][animal];
			Animal a = getArrayAnimales()[panel][animal];
			int posInicial = (int)j.getLocation().getY();
			saleTopoRec(j, posInicial, a);
		}

		public void saleTopoRec( JPanel j, int posInicial, Animal a){
			int posActual = (int)j.getLocation().getY();
			if(  posInicial - posActual >= 135 ){
			}else {
				j.setLocation((int)j.getLocation().getX(), posActual-1);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				saleTopoRec(j, posInicial, a);
			}
		}

	}

	class MiRunnable3 implements Runnable {

		/**	Método que quita un animal de pantalla	
		 * @param panel		El panel en el que se encuentra el animal a quitar
		 * @param animal	El animal que se quiere quitar
		 */
		public void quitaAnimal( int panel, int animal){
			entraTopo(panel, animal);
			getArrayAnimales()[panel][animal].setFuera(false);
			ocupado[panel] = false;
		}

		public void entraTopo( int panel, int animal ){
			JPanel j = getArrayPaneles()[panel][animal];
			Animal a = getArrayAnimales()[panel][animal];
			int posInicial = (int)j.getLocation().getY();
			entraTopoRec(j, posInicial, a);

		}

		/** Metodo recursivo que hace que los topos vuelvan a entrar
		 * @param j
		 * @param posInicial
		 */
		public void entraTopoRec( JPanel j, int posInicial, Animal a ){
			int posActual = (int)j.getLocation().getY();
			if(  posActual - posInicial >= 135 ){
			}else {
				j.setLocation((int)j.getLocation().getX(), posActual+1);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				entraTopoRec(j, posInicial, a);
			}
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
				if (nombreJugador == null) {
					nombreJugador="Player";
				}
				String string = "INSERT INTO TABLA VALUES ('"+nombreJugador+"', "+puntuacion+")";
				stmt.executeUpdate(string);
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		@Override
		public void run() {
			while(sigue){
				if(!estamosLlenos()){
					for (int i = 0; i < arrayAnimales.length; i++) {
						for (int j = 0; j < arrayAnimales[i].length; j++) {
							// Si el topo está más tiempo del que puede estar fuera
							if( getArrayAnimales()[i][j].getFechaCreacion() != 0 ){
								if( System.currentTimeMillis() - getArrayAnimales()[i][j].getFechaCreacion() >= ( TIEMPO_FUERA_TOPO*1000 -puntuacion*2 )){
									quitaAnimal( i, j ); // Quitamos el topo
									getArrayAnimales()[i][j].setFechaCreacion(0); // Ponemos la fecha de creacion a 0
									// Sumamos uno a los eliminados si son menos de dos
									if(!(getArrayAnimales()[i][j] instanceof Gatete)){
										if (eliminados < MAX_TOPOS_PERDIDOS ) {
											eliminados++;
											if(eliminados == 1)
												lp.add( px1, new Integer(60) );
											if(eliminados == 2)
												lp.add( px2, new Integer(61) );
											if(eliminados == 3)
												lp.add( px3, new Integer(62) );
										}
										if((getArrayAnimales()[i][j] instanceof Gatete) || eliminados >= MAX_TOPOS_PERDIDOS)
											acaba();

									}
								}
							}
						}
					}
				}

			}
			nombreJugador =
					JOptionPane.showInputDialog(null,
							"Fin del Juego. Tu puntuacion final ha sido de "+puntuacion+". Introduce el nombre del jugador:",
							"Game Over",
							JOptionPane.INFORMATION_MESSAGE);
			cargaEnBD();
			miVentana.dispose();
			ventanaInicial.setVisible(true);
			sigue = true;
		}

		public void acaba(){
			sigue = false;
		}
	}
}
