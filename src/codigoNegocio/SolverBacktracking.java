package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import controller.AristaTO;

public class SolverBacktracking 
{
	private Grafo grafo;
	//CDM a retornar
	private Set<Integer> CDM;
	//Distintos conjuntos dominantes
	private HashSet<Integer> actual;
	
	private List<VerticeNegocio> listaDeVertices;
	
	private Set<Integer> verticesAlcanzados;
	private ArrayList<AristaTO> aristasTO;
	private Integer size;
	
	
	public SolverBacktracking(Grafo grafo) 
	{
		if(grafo == null) 
		{
			throw new IllegalArgumentException("El grafo no puede ser null");
		}
		this.grafo = grafo;
		this.CDM = new HashSet<Integer>();
	}
	
	public SolverBacktracking(ArrayList<AristaTO> aristasTO,Integer size) 
	{
		this.size = size;
		this.aristasTO = aristasTO;
		setearGrafo(this.size, this.aristasTO);
		this.CDM = new HashSet<Integer>();
		this.CDM = resolver();
	}
	
	public void setearGrafo(Integer size,ArrayList<AristaTO> aristasTO) 
	{
		this.grafo = new Grafo(size);
		for(int i=0; i<aristasTO.size(); i++)
		{
			grafo.agregarArista(aristasTO.get(i).getVertice1(),aristasTO.get(i).getVertice2());
		}
	}
	
	public Set<Integer> resolver()
	{
		long inicio = System.currentTimeMillis();
		
		this.actual = new HashSet<Integer>();
		//CDM empieza valiendo el conjunto de vertices entero
		for (int i = 0; i < grafo.vertices(); i++) {
			CDM.add(i);
		}
		
		this.listaDeVertices = grafo.listaVertices();
		this.verticesAlcanzados = new HashSet<Integer>();
		
		generarDesde(0);
		
		long fin = System.currentTimeMillis();
		
		double tiempo = (fin - (double) inicio)/1000;
		
		//System.out.println("Backtracking: " + tiempo + " segundos");
		
		//System.out.println(CDM);
		
		return CDM;
	}

	@SuppressWarnings("unchecked")
	private void generarDesde(int i) 
	{
		if(i == grafo.vertices())
		{
			if(verticesAlcanzados.size() == grafo.vertices() && actual.size() < CDM.size()) 
			{
				this.CDM = (HashSet<Integer>) actual.clone();
			}
		}else if(verticesAlcanzados.size() == grafo.vertices()) 
		{
			if(this.CDM.size() > this.actual.size()) {
				this.CDM = (HashSet<Integer>) actual.clone();
			}
			return;
		}
		else
		{
			//Agrega a vertices alcanzados los vecinos del vertice y ese mismo vertice
			verticesAlcanzados.addAll(listaDeVertices.get(i).vecinos());
			verticesAlcanzados.add(listaDeVertices.get(i).numeroVertice());	
			actual.add(listaDeVertices.get(i).numeroVertice());
			generarDesde(i+1);
			
			//Remueve de la posible solucion (actual) el vertice y se setea con los
			//alcanzables de los vertices restantes
			actual.remove(listaDeVertices.get(i).numeroVertice());

			verticesAlcanzados.clear();
			for(Integer indice : actual) 
			{
				verticesAlcanzados.addAll(listaDeVertices.get(indice).vecinos());
				verticesAlcanzados.add(indice);
			}
			generarDesde(i+1);
		}
	}
	public Set<Integer> getCDM() {
		return CDM;
	}
}
