package base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.beans.IntrospectionException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import GameObjects.Snake;
import TecladoEvento.InputTeclado;
import base.Sala.Puntaje;
import medida.Medida;

public class Sala extends JFrame{

	private int ANCHO = Medida.ANCHO;
	private int LARGO = Medida.LARGO;
	
	/**
	 * el ultimo parametro es el Id de la snake, lo hardcodie porque el idgeneral de
	 * GameObject no incrementaba, como son diferentes, puedo saber cuando se chocan
	 * snake
	 */
	
	InputTeclado InputTeclado = new InputTeclado();	
	ArrayList<Jugador> jugadores = new ArrayList<>();
	JPanel contentPane;
	Tablero laminaJuego;

	public Sala() {
		super("Game");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, Medida.ANCHO_VENTANA, Medida.LARGO_VENTANA);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		laminaJuego = new Tablero();
		laminaJuego.setBounds(ANCHO/4, 0, Medida.ANCHO_VENTANA, Medida.LARGO_VENTANA);
		contentPane.add(laminaJuego);
		
		JLabel titulo = new JLabel("SCORE");
		titulo.setBounds(40, 5, 120, 40);
		contentPane.add(titulo);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(5,30, 100,40);
		contentPane.add(nombre);
		
		JLabel puntaje = new JLabel("Puntos");
		puntaje.setBounds(70,30, 100, 40);
		contentPane.add(puntaje);
		
		JList<String> lista = new JList<>();
		lista.setBounds(5,70, 100,30);
		lista.setBackground(Color.BLUE);
		contentPane.add(lista);

		//seTFocusable para que maneje los inputs dentro del panel 
		this.addKeyListener(InputTeclado);
		setFocusable(true);
		setVisible(true);
		setResizable(false);
		
		//AGREGAR JUGADORES
		añadirJugador();
		añadirJugadorBot();
	}
	
	private void añadirJugador() {
		Jugador JugadorRobot= new Jugador("C++");
		jugadores.add(JugadorRobot);
		laminaJuego.agregarSnake(jugadores.get(jugadores.size()-1).getSnake());
	}
	
	private void añadirJugadorBot() {
		Jugador JugadorDefecto= new Jugador("BOT");
		jugadores.add(JugadorDefecto);
		laminaJuego.agregarSnake(jugadores.get(jugadores.size()-1).getSnake());
	}
	
	/**
	 * Inicia la partida
	 */
	
	public void start() {
		
		//AGREGAR SNAKE, CON FOR EACH JUGADOR AGREGANDOLE LA SNAKE
		//FPS
		long nextGameTick = System.currentTimeMillis();
		long sleepTime = 0;
		
		while (true) {
			/*
			 * Actualizar llama a move del Escenario, y repaint. 
			 * */
			laminaJuego.actualizar(InputTeclado.direccion);
			
			//FPS
			nextGameTick += Medida.SKIP_TICKS;
			sleepTime = nextGameTick- System.currentTimeMillis();
			
			if(sleepTime>=0) {
				
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.getMessage();
					System.out.println("ERROR SLEEP");
				}
			} else
				System.out.println("NO LLEGUE AL FPS");
		}
	}

	class Puntaje extends JPanel {
	
		/*
		 * PANEL DE LA VENTANA DE PUNTAJE
		 * FALTA TERMINAR, EN CLASE APARTE
		 * 
		 * */
		private JLabel puntaje;

		public Puntaje() {

			
			this.setLayout(new BorderLayout());
			puntaje = new JLabel("PLAYER-PUNTAJE");

			
			
			add(puntaje);
//			setBounds(0, 0, ANCHO/4, LARGO);
			setBackground(Color.LIGHT_GRAY);

		}
	}
}
	
	
