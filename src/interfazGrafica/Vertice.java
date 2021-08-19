package interfazGrafica;

import org.eclipse.swt.graphics.Point;

public class Vertice {

	private Integer numero;
	private Point coordenada;
	
	public Vertice (Point coordenada, Integer numero) {
		
		this.coordenada= coordenada;
		this.numero= numero;
		
	}

	public Point getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Point coordenada) {
		this.coordenada = coordenada;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	

	@Override
	public String toString() {
		return "Vertice [numero= " + numero + ", coordenada= " + coordenada.x + " - " + coordenada.y +  "]";
	}
	
	
	
}

