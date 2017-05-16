import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.print.DocFlavor.URL;
//import java.awt.event.MouseEvent;
import javax.swing.*;

public class Fracciones extends JFrame{
	
	JTextField txt, txt2, txt3;                         //cadena de numeros
	JPanel pBotones,pRes, pIzq, pDer;  //Paneles
	JButton boton;                          //Botones
	JLabel img;
	private String resultado;              
	private boolean nvOperacion=true;           //indica incio de operacion 
	private float res;
	private Image imag;
	public java.net.URL fondo;
	
	public Fracciones(){ 
	
	    //Panel principal
		super();
		setSize(900,630);
		setLocation(250,70);
		setTitle("Calculadora de Fracciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//Panel Principal***********************************
		JPanel panel = (JPanel)this.getContentPane();
		panel.setLayout(new BorderLayout());
	//	panel.setBackground(Color.lightGray);
		

//     Primer Panel*****************************Izquierda*****	
		pIzq = new JPanel();
		pIzq.setLayout(new GridLayout(1,2));
	//	pIzq.setLocation(600, 20);
	    ImageIcon imagen= new ImageIcon("/home/angelica/Imágenes/fracciones/fracc.jpg");
		img=new JLabel(imagen);
		img.setSize(20,50);
		//img.setBounds(20,20, 100,100);	
		txt=new JTextField("Izq", 7);
		txt.setFont(new Font ("Comic Sans", Font.BOLD,15));
		txt.setHorizontalAlignment(JTextField.RIGHT);
		txt.setBounds(100, 17, 100, 17);
		
		pIzq.add(BorderLayout.NORTH,img);
		pIzq.add(BorderLayout.SOUTH,txt);		
		pIzq.setBackground(Color.GREEN);
		panel.add(BorderLayout.WEST, pIzq);

//      Panel de Botones***********************Abajo***********
		pBotones = new JPanel();
		pBotones.setLayout(new GridLayout(5,10,10,10));

		///creacion de botones///
		for (int d = 2; d <= 10; d++) {
			for (int n=1; n<=10;n++){
				if(n<=d){
				boton=new JButton("1/" + d);
				boton=new JButton(n+"/"+d);
				boton.setBackground(Color.gray);
				boton.setForeground(Color.cyan);
				boton.setBorderPainted(true);
				boton.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						JButton bot =(JButton)e.getSource();
						numero(bot.getText());
						}}
					);
			pBotones.add(boton);
			pBotones.setBackground(Color.lightGray);
			}}	}
		  boton= new JButton("CE");
		  boton.setForeground(Color.orange);
		  boton.setBackground(Color.darkGray);
		  boton.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					JButton bot =(JButton)e.getSource();
					pulsacion(bot.getText());
					}}
				);
		 //operadores("CE");
		  pBotones.add(boton);
		  panel.add("South", pBotones);
	  
		  
	
//		Panel segundo**********************centro*************
	    pDer = new JPanel();
	    pDer.setLayout(new GridLayout(5,1,7,7));
	    operadores("+");
	    operadores("x");
		operadores("-");
		operadores("/");
		operadores("=");
		ImageIcon imgen= new ImageIcon("fracc.gpj");
		img=new JLabel(imgen);
		img.setSize(80,10);	
		txt3 =new JTextField("centro",7);
		txt3.setBounds(0,0, 100,17);
		txt3.setFont(new Font ("Comic Sans", Font.BOLD,15));
		txt3.setHorizontalAlignment(JTextField.RIGHT);
		
		pDer.add(img);
		pDer.add(txt3);
		pDer.setBackground(Color.ORANGE);
		panel.add(BorderLayout.CENTER, pDer);
	
		//Panel resultado************************derecha**************
	   
		pRes= new JPanel();
		pRes.setLayout(new GridLayout( 1,2,280,20));
		ImageIcon igen= new ImageIcon("fracc.gpj");
		img=new JLabel(igen);
		img.setSize(80,100);	
		txt2 =new JTextField("Derecha", 7);
		txt2.setBounds(0,10,10,170);
		txt2.setFont(new Font ("Comic Sans", Font.BOLD,15));
		txt2.setHorizontalAlignment(JTextField.RIGHT);
		
		pRes.add(txt2);
		pRes.add(img);
	    pRes.setBackground(Color.lightGray);
		panel.add(BorderLayout.EAST,pRes);
		
		validate();
	
	}
	
	//Metodo para crear botones de operaciones con escuchadores************
		public void operadores(String operacion){
			JButton bt=new JButton(operacion);
			bt.setForeground(Color.orange);
			bt.setBackground(Color.gray);
			bt.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					JButton bot =(JButton)e.getSource();
					pulsacion(bot.getText());
					}}
				);
			pDer.add(bt);
		}
		
		//Metodo para las operaciones**************************
		public void numero(String digito){
			if(txt.getText().equals("0")||nvOperacion){
				txt.setText(digito);				
			}
			else{
				txt.setText(txt.getText()+digito);
			}
			nvOperacion=false;
		}
       //teclas de pulsacion*******************************
		public void pulsacion(String tecla){
			if(tecla.equals("CE")){
				calcular();}
			else if(tecla.equals("=")){
				txt.setText("");
				nvOperacion=true;}
			else{
				resultado=tecla;
				if((res>0)&&!nvOperacion){
					calcular();
				}else{
					res=new Float(txt.getText());
				}
				
			}
			nvOperacion=true;
		}
		
		//Calcular operaciones**************************
		public void calcular(){
			if(resultado.equals("+")){
				res += new Float(txt.getText());
			}else if(resultado.equals("x")){
				res *= new Float(txt.getText());
			}else if(resultado.equals("-")){
				res -= new Float(txt.getText());
			}else if(resultado.equals("/")){
				res /= new Float(txt.getText());
			}
			txt3.setText(""+res);
			resultado="";
		}
}