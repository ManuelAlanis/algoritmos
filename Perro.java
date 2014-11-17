import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.applet.*;
public class Perro extends Applet{
		int tama;//tamaño del perro
		JLabel label;
		ImageIcon image;
		
		//En el caso de querer modificar los tamaños de las imagenes usar estas tres variables
		//favor de utilizar un multiplo de 3 para mejores resultados
		int ancho=90;
		//tamaño minimo de cada imagen
		int tamaMin=30;
		//tamaño maximo que alcanzara una imagen... ignore el - tamaMin
		int tamaMax=80-tamaMin;
		
		
		public Perro(){
			Random ran = new Random();
			tama=tamaMin+ran.nextInt(tamaMax);//Tamano inicializado desde 30~(30+80)
			image=new ImageIcon("dog"+ran.nextInt(10)+".png");//Seleccion aleatoria de labels dog0~dog9
			image= new ImageIcon(image.getImage().getScaledInstance(ancho,tama+50,Image.SCALE_DEFAULT));//redimension de la imagen
			label=new JLabel(image);
			
		}
	}
	