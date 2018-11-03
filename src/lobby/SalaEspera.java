package lobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class SalaEspera extends JFrame{

	static int numSala=0;
	private String titulo;
	private int cantJugadores = 0;
	private Object[] lista;
	
	public SalaEspera(String nombreSala) {
		
		super("Sala Espera");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setLocationRelativeTo(null);
		
		this.titulo = nombreSala;
		numSala++;
		this.cantJugadores++;
		
		this.setVisible(true);
		JButton salir = new JButton("Salir");
		add(salir);
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cerrarVentana();
			}
		});
		
	}

	protected void cerrarVentana() {
		this.setVisible(false);
		cantJugadores--;
	}
	
	public int getCantJugadores() {
		return this.cantJugadores;
	}

	public Object[] getList() {
		
		lista = new Object[4];
		lista[0] = (this.numSala);
		lista[1] =(this.titulo);
		lista[2] = (this.cantJugadores);
		return lista;
	}

	
	public void setVisible() {
		
		this.setVisible(true);
	}
	

	
	
	
	
	
}
