package codigoNegocio;

import java.util.ArrayList;

public class Grafo {
	private ArrayList<VerticeNegocio> vecinos;

	// Constructor
	public Grafo(int n) 
	{
		if(n < 0) {
			throw new IllegalArgumentException("La cantidad de vertices del grafo debe ser igual o mayor a 0");
		}
		
		vecinos = new ArrayList<VerticeNegocio>();
		for (int i = 0; i < n; ++i)
			vecinos.add(new VerticeNegocio(i));
	}

	//Agregar arista
	public void agregarArista(int i, int j) 
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		vecinos.get(i).agregarArista(j);
		vecinos.get(j).agregarArista(i);
	}
	
	//Eliminar arista
	public void eliminarArista(int i, int j) 
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		vecinos.get(i).eliminarArista(j);
		vecinos.get(j).eliminarArista(i);
	}

	//Consultar si existe arista
	public boolean existeArista(int i, int j) 
	{
		verificarVertice(i);
		verificarVertice(j);
		
		return vecinos.get(i).existeArista(j);
	}

	//Agregar vertice
	public void agregarVertice() 
	{
		vecinos.add(new VerticeNegocio(vecinos.size()));
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<VerticeNegocio> listaVertices()
	{
		return (ArrayList<VerticeNegocio>) vecinos.clone();
	}
	
	//Cantidad de vertices
	public int vertices() 
	{
		return vecinos.size();
	}
	
	// Verifica que sea un vertice valido
	private void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= vertices() )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	private void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

}
