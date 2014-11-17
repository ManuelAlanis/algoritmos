import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.applet.*;


public class EsteticaApplet extends Applet implements ActionListener{
	Perro[] perros = new Perro[10];
	//JFrame marco;
	//JPanel panel;
	JTextField text1;
	JButton boton1;
	boolean ban=false;
	JLabel background;
	ImageIcon bg;
	
	public void init(){
		//marco=new JFrame("Practica9");
		//panel = new JPanel();
		//panel.
		setLayout(null);
		//panel.setFocusable(true);
		//marco.

		text1=new JTextField("5");
		boton1=new JButton("Inicio");
		boton1.addActionListener(this);
		text1.setBounds(10,10,100,50);
		boton1.setBounds(150,10,100,50);
		bg=new ImageIcon("estetica.jpg");
		bg=new ImageIcon(bg.getImage().getScaledInstance(960,500,Image.SCALE_DEFAULT));
		background=new JLabel(bg);
		background.setBounds(0,0,960,500);
		
		add(text1);
		add(boton1);
		add(background);
		//marco.getContentPane().add(panel);
		//marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(960,500);
		//setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		int tope=0;
		if(ban!=false)
		for(int i=0;i<perros.length;i++){
			remove(perros[i].label);
		}
		ban=true;
		//Metodo isDigit regresa -1 si el valor no es int, si lo es regresa dicho valor
		tope=isDigitTodo(text1.getText());
		//Inicializacion de arreglo si el valor ingresado es valido
		if(tope>-1&&tope<=8){
			perros = new Perro[tope];
			for(int i=0;i<tope;i++){
				perros[i]= new Perro();
				//acomodo de elementos en orden aleatorio de tamaños
				perros[i].label.setBounds((i+1)*(perros[i].ancho+(perros[i].ancho)/3)-100,310-perros[i].tama+perros[i].tamaMin,perros[i].ancho,perros[i].tama+50);
				add(perros[i].label);
				setComponentZOrder(perros[i].label,0);
			}
			add(background);
			validate();
			repaint();
			//acomodo por tamaño en multithread
			Thread one = new Thread(new mueve(perros));
			one.start();
		}
	}
	
	//Metodo isDigit regresa -1 si el valor no es int, si lo es regresa dicho valor
	public int isDigitTodo(String cad)  
	{  
	    try  
	    {  
			return Integer.parseInt(cad); 
	    }  
	    catch(Exception e){};  
	    {  
			return -1;  
	    }  
	}  
	
	public void start(){
		EsteticaApplet sim = new EsteticaApplet();
	}

}