package ventanas;

import javax.swing.*;

import animales.Animal;
import animales.gatos.Gatete;
import animales.topos.TipoTopo;
import animales.topos.Topete;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

/**
 * Deprecated
 * 
 * @author Gaizka
 *
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel arrayPaneles[][] = new JPanel[4][3]; // Array de paneles
															// que contienen los
															// jlabel de los
															// topos
	protected Animal arrayAnimales[][] = new Animal[4][3]; // Array que va a
															// contener los
															// topos
	protected MiRunnable miHilo = null; // Hilo principal del juego
	protected int puntuacion;
	protected int eliminados;
	protected boolean mazo;
	protected boolean sigo;
	protected static VentanaPrincipal ventana;
	protected JPanel panelMain = new JPanel();
	protected JPanel panelDePaneles = new JPanel();
	protected JLabel jlPutn;
	protected boolean gatoMuerto = false;

	public void setArrayAnimales(int posX, int posY, Animal animal) {
		this.arrayAnimales[posX][posY] = animal;
	}

	public JPanel getArrayPaneles(int posX, int posY) {
		return arrayPaneles[posX][posY];
	}

	public Animal getArrayAnimales(int posX, int posY) {
		return arrayAnimales[posX][posY];
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

	public void creaTodo() {
		// mazo = true;
		ventana = getVentana();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Inicializaci�n del panel
		for (int i2 = 0; i2 < arrayAnimales.length; i2++) {
			for (int j2 = 0; j2 < arrayAnimales[i2].length; j2++) {
				arrayAnimales[i2][j2] = null;
			}
			ventana.add(panelMain);
			panelMain.validate();
			panelMain.repaint();
			panelMain.setLayout(new BorderLayout());
		}
		eliminados = 0;
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(3);
		gridLayout.setRows(4);
		panelDePaneles.setLayout(gridLayout);

		JPanel jlpuntuacion = new JPanel();
		jlPutn = new JLabel("Puntuacion: " + puntuacion);

		jlpuntuacion.add(jlPutn);
		panelMain.add(panelDePaneles, BorderLayout.CENTER);
		panelMain.add(jlpuntuacion, BorderLayout.NORTH);

		// Imagen del cursor cambiar lo de dentro del getImage para que cambie
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image imagen = toolkit.getImage("src/img/mazoSinFondo.png");
		Cursor c = toolkit.createCustomCursor(imagen,
				new Point(panelMain.getX(), panelMain.getY()), "img");
		panelMain.setCursor(c);

		ventana.setSize(new Dimension(700, 715));

		panelMain.validate();
		panelMain.repaint();

		for (int i = 0; i < gridLayout.getRows(); i++) {
			for (int j = 0; j < gridLayout.getColumns(); j++) {
				arrayPaneles[i][j] = new JPanel();
				arrayPaneles[i][j].setBorder(BorderFactory
						.createLineBorder(Color.BLACK));

				panelDePaneles.add(arrayPaneles[i][j]);

				panelMain.repaint();
				final int k = i;
				final int l = j;
				arrayPaneles[i][j].addMouseListener(new MouseListener() {
					// Metodo que golpea al topo y le resta vidas, si las vidas
					// estan a 0 lo mata
					@Override
					public void mouseClicked(MouseEvent e) {

					}

					@Override
					public void mouseEntered(MouseEvent e) {
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						try {
							if (arrayAnimales[k][l] instanceof Topete) {
								((Topete) arrayAnimales[k][l]).pegaTopo();
								if (((Topete) arrayAnimales[k][l]).getVidas() == 0) {
									puntuacion += ((Topete) arrayAnimales[k][l])
											.getPuntos();
									jlPutn.setText("Puntuacion: " + puntuacion);
									arrayPaneles[k][l]
											.remove(arrayPaneles[k][l]
													.getComponent(0));
									arrayAnimales[k][l] = null;
									arrayPaneles[k][l].repaint();
								}
							} else {
								arrayPaneles[k][l].remove(arrayPaneles[k][l]
										.getComponent(0));
								arrayAnimales[k][l] = null;
								arrayPaneles[k][l].repaint();
								gatoMuerto = true;

							}
						} catch (ArrayIndexOutOfBoundsException a) {
							// System.out.println("NO HAY JLABEL");
						} catch (IndexOutOfBoundsException e12) {
						} catch (NullPointerException e2) {
							// System.out.println("No hay topo aqui");
							// golpes fallados
						}
					}

					@Override
					public void mouseReleased(MouseEvent e) {
					}

				});

			}
		}
		ventana.setVisible(true);
	}

	public boolean isGatoMuerto() {
		return gatoMuerto;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	/**
	 * Crea un topo, cada tipo tiene una probabilidad de salir 
	 */
	public void creaAnimal() {
		Animal animal = null;
		do {
			Random r = new Random();
			int i = r.nextInt(100);
			if (i < 61) {
				animal = new Topete(TipoTopo.NORMAL); // 40
			} else if (i > 60 && i < 71) {
				animal = new Gatete();
			} else if (i > 70 && i < 91) {
				animal = new Topete(TipoTopo.CASCO);// 15
			} else if (i > 90) {
				animal = new Topete(TipoTopo.JUGGERNAUT);// 15
			}
		} while (getArrayPaneles(animal.getPosX(), animal.getPosY())
				.getComponents().length == 1); // Evita que si ya hay un topo en
												// el espacio seleccionado, se
												// cree otro
		setArrayAnimales(animal.getPosX(), animal.getPosY(), animal);
		getArrayPaneles(animal.getPosX(), animal.getPosY()).setLayout(
				new FlowLayout(FlowLayout.CENTER));
		getArrayPaneles(animal.getPosX(), animal.getPosY()).setBorder(
				BorderFactory.createLineBorder(Color.blue));
		getArrayPaneles(animal.getPosX(), animal.getPosY())
				.add(animal.getImg());
		getArrayPaneles(animal.getPosX(), animal.getPosY()).validate();
		getArrayPaneles(animal.getPosX(), animal.getPosY()).repaint(); // Repaint
																		// a los
																		// paneles
																		// para
																		// que
																		// a�ada
																		// otro
																		// topo
	}

	public boolean estamosLLenos() {
		for (int i = 0; i < arrayAnimales.length; i++) {
			for (int j = 0; j < arrayAnimales[i].length; j++) {
				if (arrayAnimales[i][j] == null)
					return false;
			}
		}
		return true;
	}

	/**
	 * Metodo que mira que topo lleva demasiado tiempo y lo elimina si se pasa
	 * 
	 * @param maxTiempo
	 *            Maximo del tiempo que puede estar el topo en la pantalla
	 * @return
	 */
	public boolean quitaAnimal(long maxTiempo) {
		boolean acaba = false;
		for (int i = 0; i < arrayAnimales.length; i++) {
			for (int j = 0; j < arrayAnimales[i].length; j++) {
				if (arrayAnimales[i][j] != null) {
					if (System.currentTimeMillis()
							- arrayAnimales[i][j].getFechaCreacion() >= maxTiempo) {
						if (arrayAnimales[i][j] instanceof Topete)
							eliminados++;
						arrayPaneles[i][j].remove(arrayPaneles[i][j]
								.getComponent(0));
						arrayAnimales[i][j] = null;
						arrayPaneles[i][j].repaint();
						if (getVentana().eliminados > 2)
							acaba = true;
					}
				}
			}
		}
		return acaba;
	}

	public void borraVentana() {
		ventana.dispose();
	}

	public static void escribeScore(int puntos) {
		try {
			String score = Integer.toString(puntos);
			Writer output = null;
			File file = new File("score.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write(score);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		getVentana().creaTodo();

		ventana.miHilo = new MiRunnable(); // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread(ventana.miHilo);
		nuevoHilo.start();

	}

	public static VentanaPrincipal getVentana() {
		if (ventana == null) {
			ventana = new VentanaPrincipal();
		}
		return ventana;
	}
}

/**
 * @author rubensancor Clase robada a andoni para el hilo :D
 */
class MiRunnable implements Runnable {
	boolean sigo = true;
	@Override
	public void run() {
		while (sigo) {
			if (!VentanaPrincipal.getVentana().estamosLLenos()) {
				VentanaPrincipal.getVentana().creaAnimal();
			}
			try {
				Thread.sleep(1200);
			} catch (Exception e) {
			}

			if (VentanaPrincipal.getVentana().quitaAnimal(4000)
					|| VentanaPrincipal.getVentana().isGatoMuerto() == true)
				acaba();
		}
		JOptionPane.showInputDialog(null,
				"Fin del Juego. Tu puntuacion final ha sido de "
						+ VentanaPrincipal.getVentana().puntuacion
						+ ". Introduce el nombre del jugador:", "Game Over",
				JOptionPane.INFORMATION_MESSAGE);
		if (JOptionPane.showConfirmDialog(null, "�Jugar Otra vez?",
				"GAME OVER", JOptionPane.YES_NO_OPTION) == 1) {
			System.exit(0);
		} else {
			VentanaPrincipal.getVentana().borraVentana();
			VentanaPrincipal.getVentana().puntuacion = 0;

		}
	}

	// private int calculoTiempo() {
	// int tiempo = 6000;
	// // if(puntuacion<)
	//
	// }

	/**
	 * Ordena al hilo detenerse en cuanto sea posible
	 */
	public void acaba() {
		sigo = false;

	}
}