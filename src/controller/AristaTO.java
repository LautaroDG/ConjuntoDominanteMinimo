package controller;

public class AristaTO {
	private Integer vertice1;
	private Integer vertice2;
	
	public AristaTO( Integer vertice1,	 Integer vertice2) 
	{
		this.vertice1= vertice1;
		this. vertice2= vertice2;
	}

	public Integer getVertice1() {
		return vertice1;
	}

	public void setVertice1(Integer vertice1) {
		this.vertice1 = vertice1;
	}

	public Integer getVertice2() {
		return vertice2;
	}

	public void setVertice2(Integer vertice2) {
		this.vertice2 = vertice2;
	}

	@Override
	public String toString() {
		return "AristaTO [vertice1=" + vertice1 + ", vertice2=" + vertice2 + "]";
	}

}
