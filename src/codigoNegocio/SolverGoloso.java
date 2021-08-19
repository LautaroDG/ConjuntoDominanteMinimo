package codigoNegocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import controller.AristaTO;

public class SolverGoloso 
{
	private Grafo grafo;
	private ArrayList<VerticeNegocio> listaDeVertices;
	private Comparator<VerticeNegocio> comparador;
	private ArrayList<AristaTO> aristasTO;
	private Integer size;
	private Set<Integer> CDM;
	@SuppressWarnings("unused")
	private boolean noHayAristas;

	public SolverGoloso(Grafo grafo, Comparator<VerticeNegocio> comparador) 
	{
		if(grafo == null) 
		{
			throw new IllegalArgumentException("El grafo no puede ser null");
		}
		if(comparador == null) 
		{
			throw new IllegalArgumentException("El comparator no puede ser null");
		}
		
		this.grafo = grafo;
		this.listaDeVertices = grafo.listaVertices();
		this.comparador = comparador;
	}
	
	public SolverGoloso(ArrayList<AristaTO> aristasTO,Integer size) 
	{
		this.size = size;
		this.noHayAristas = false;
		this.aristasTO = aristasTO;
		this.CDM = new HashSet<Integer>();
		setearGrafo(this.size, this.aristasTO);
		this.listaDeVertices = grafo.listaVertices();
		this.comparador = new ComparatorPorGrado();
		this.CDM= resolver();
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
		
		Set<Integer> CDM = new HashSet<Integer>();
		
		Set<Integer> verticesAlcanzados = new HashSet<Integer>();
		
		Collections.sort(listaDeVertices, comparador);
		
		for(VerticeNegocio vertice : listaDeVertices) 
		{
			//Si ya se llega a todos los vertices
			if(verticesAlcanzados.size() == grafo.vertices())
				break;
			Set<Integer> vecinosVertice = vertice.vecinos();
			verticesAlcanzados.addAll(vecinosVertice);
			verticesAlcanzados.add(vertice.numeroVertice());
			CDM.add(vertice.numeroVertice());		
		}
		
		long fin = System.currentTimeMillis();
		
		double tiempo = (fin - (double) inicio)/1000;
		
		//System.out.println("Goloso: " + tiempo + " segundos");
		//System.out.println(CDM);
		return CDM;
	
	}

	public Set<Integer> getCDM() {
		return CDM;
	}
	
	
	
}
