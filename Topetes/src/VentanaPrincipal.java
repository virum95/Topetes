import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;


public class VentanaPrincipal extends JFrame{

	static JPanel arrayPaneles [][]= new JPanel [4][3];
	ArrayList <JLabel> arrayDeTopos = new ArrayList<>();
	public VentanaPrincipal() {
	
		arrayDeTopos = new ArrayList<>();
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(3);
		gridLayout.setRows(4);
		setLayout(gridLayout);
		setVisible(true);
		setSize(new Dimension(400,600));
		
		for(int i=0; i<gridLayout.getRows(); i++)
		{
			for(int j=0 ; j<gridLayout.getColumns(); j++)
			{
				arrayPaneles [i][j] = new JPanel();
				arrayPaneles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(arrayPaneles[i][j]);
				int k = i;
				int l = j;
				arrayPaneles[i][j].addMouseListener(new MouseListener ()
				{

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
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						try{
						System.out.println("ENTRA EN EL PANEL"+k+l);
						arrayPaneles[k][l].remove(arrayPaneles[k][l].getComponent(0));
						arrayDeTopos.remove(0);
						arrayPaneles[k][l].repaint();
						}catch(ArrayIndexOutOfBoundsException a)
						{
							System.out.println("NO HAY JLABEL");
						} catch(IndexOutOfBoundsException e12){
							
						}
						}
					
				}
				);
				
			}
		}
	}
	
	public void creaTopo ()
	{
		JLabel labelTopo = new JLabel("TOPO");
		arrayDeTopos.add(labelTopo);
		Random r = new Random();
		arrayPaneles[r.nextInt(4)][r.nextInt(3)].add(labelTopo);
	}
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.creaTopo();
	}
	
	
}
