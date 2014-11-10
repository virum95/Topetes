package ventanas;

import java.util.Random;

import animales.topos.TipoTopo;
import animales.topos.Topete;

public class VentanaNivel1 extends VentanaPrincipal{

	public static void creaAnimal ()
	{
		Topete animal = null;
		do{
				animal = new Topete(TipoTopo.NORMAL); //40
		}while(arrayPaneles[animal.getPosX()][animal.getPosY()].getComponents().length==1);  //Evita que si ya hay un topo en el espacio seleccionado, se cree otro 
		arrayAnimales[animal.getPosX()][animal.getPosY()]=animal;
		arrayPaneles[animal.getPosX()][animal.getPosY()].add(animal.getImg());
		arrayPaneles[animal.getPosX()][animal.getPosY()].validate();
		arrayPaneles[animal.getPosX()][animal.getPosY()].repaint();	//Repaint a los paneles para que añada otro topo
	}
	
	public static void main(String[] args) {
		VentanaNivel1 ventana = new VentanaNivel1();
		ventana.miHilo = new MiRunnable();  // Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread( ventana.miHilo );
		nuevoHilo.start();
	}

}
