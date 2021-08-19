package interfazGrafica;

public class Arista {
	Vertice vertice1;
	Vertice vertice2;
	
	public Arista(Vertice vertice1, Vertice vertice2) {
		this.vertice1=vertice1;
		this.vertice2=vertice2;
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}
	
	
}
