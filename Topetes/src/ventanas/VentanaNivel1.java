package ventanas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.BorderFactory;

import animales.topos.TipoTopo;
import animales.topos.Topete;

public class VentanaNivel1 extends VentanaPrincipal{

	public VentanaNivel1()
	{
		VentanaPrincipal.ventana = new VentanaNivel1();
		VentanaPrincipal.ventana.setVisible(true);
	}
	
	@Override
	public void creaAnimal ()
	{
		Topete animal = null;
		do{
				animal = new Topete(TipoTopo.NORMAL); //40
		}while(getArrayPaneles(animal
				.getPosX(), animal
				.getPosY())
				.getComponents()
				.length==1);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
		setArrayAnimales(animal.getPosX(), animal.getPosY(), animal);
		getArrayPaneles(animal.getPosX(), animal.getPosY()).setLayout( new FlowLayout(FlowLayout.CENTER));
		getArrayPaneles(animal.getPosX(), animal.getPosY()).setBorder( BorderFactory.createLineBorder(Color.blue));
		getArrayPaneles(animal.getPosX(), animal.getPosY()).add(animal.getImg());
		getArrayPaneles(animal.getPosX(), animal.getPosY()).validate();
		getArrayPaneles(animal.getPosX(), animal.getPosY()).repaint();	//Repaint a los paneles para que añada otro topo
	}
	
	public static void main(String[] args) {
		VentanaNivel1 ventana = new VentanaNivel1();
		ventana.miHilo = new MiRunnable();  // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread( ventana.miHilo );
		nuevoHilo.start();
	}

}
