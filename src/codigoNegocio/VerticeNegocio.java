package codigoNegocio;

import java.util.HashSet;

public class VerticeNegocio 
{
	private int vertice;
	private HashSet<Integer> vecinos;
	
	public VerticeNegocio(int vertice) 
	{
		verificarVertice(vertice);
		this.vertice = vertice;
		this.vecinos = new HashSet<Integer>();
	}

	public void agregarArista(int i) 
	{
		if(i == vertice) 
		{
			throw new IllegalArgumentException("El vertice no puede formar un ciclo: " + i);
		}
		verificarVertice(i);
		vecinos.add(i);
	}

	public void eliminarArista(int i) 
	{
		verificarVertice(i);
		vecinos.remove(i);
	}

	public boolean existeArista(int i) 
	{
		verificarVertice(i);
		return vecinos.contains(i);
	}
	
	public int grado() 
	{
		return vecinos.size();
	}
	
	@SuppressWarnings("unchecked")
	public HashSet<Integer> vecinos()
	{
		return (HashSet<Integer>) vecinos.clone();
	}
	
	public int numeroVertice() {
		return vertice;
	}

	@Override
	public String toString() {
		return "VerticeNegocio [vertice=" + vertice + ", vecinos=" + vecinos + "]";
	}

	private void verificarVertice(int i)
	{
		if( i < 0 ) 
		{
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		}
	}
	
}
