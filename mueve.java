import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.applet.*;

public class mueve extends Applet implements Runnable{
	Perro[] perros;
	public void run(){
		Perro aux;
		int min;
		
		//topepe-1 debido a que el ultimo ya estaria en su pos
		for(int i=0; i < perros.length-1; i++){
			min=i;
			for(int j=i+1; j < perros.length; j++){
				//Comparacion de tamaño, elemento menor hasta el momento y elemento actual en revision
				if(perros[min].tama>=perros[j].tama){
					min=j;//Encuentra un valor menor
				}
			}
			
			//Animacion
			repaint();
			sube(perros[i],1,2);
			sube(perros[min],1,1);
			acomoda(perros[min],i,min,1,1);
			acomoda(perros[i],i,min,-1,2);
			
			//Acomodo de arreglo
			aux=perros[i];
			perros[i]=perros[min];
			perros[min]=aux;
			
		}
	}
	public mueve(Perro[] perros){
		this.perros=perros;
		//Elementos empleados para ordenar arreglo	
			
	}
	//Animacion 1
	public void sube(Perro perro, int cntrl, int tmp){
		//cntrl
		//-1 baja
		//1 sube
		//tmp
		//multiplo para distancia de subida
		
		for(int i=0;i<15;i++){
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){}
			perro.label.setLocation(perro.label.getX(),perro.label.getY()-5*cntrl*tmp);
			
		}
	
	}
	
	//Animacion 2
	public void acomoda(Perro perro,int a,int b,int cntrl,int tmp){
		//cntrl
		//1 izquierda
		//-1 derecha
		
		int mov=b-a;
		int des=(perro.ancho+(perro.ancho)/3)/10;
		for(int j=0;j<mov;j++)
		for(int i=0;i<10;i++){
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){}
			perro.label.setLocation(perro.label.getX()-des*cntrl,perro.label.getY());
			
		}
		sube(perro,-1,tmp);
	}
}