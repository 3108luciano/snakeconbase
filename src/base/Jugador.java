package base;

import GameObjects.Snake;
import medida.Medida;

public class Jugador {

	public static int size = Medida.SIZE;
	private static int idGenral=1;
	private int puntaje;
	private String nombreJugador;
	
	Snake snake;
	public Jugador(String nombreJugador) {
		snake = new Snake(80 / size, 80 / size, idGenral++);
		this.nombreJugador=nombreJugador;
	}
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	
	public String getNombre() {
		return this.nombreJugador;
	}
	
	
}
