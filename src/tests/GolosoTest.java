package tests;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import codigoNegocio.ComparatorPorGrado;
import codigoNegocio.Grafo;
import codigoNegocio.SolverGoloso;
import codigoNegocio.VerticeNegocio;

public class GolosoTest<T> {
	
	private Grafo grafo;
	
	private SolverGoloso solverGoloso;
	
	private Comparator<VerticeNegocio> comparador;

	@Before
	public void inicializar()
	{
		this.grafo = new Grafo (6);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 4);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(3, 2);
		grafo.agregarArista(3, 5);
		grafo.agregarArista(2, 1);
		
		this.comparador = new ComparatorPorGrado();
		
		this.solverGoloso = new SolverGoloso(grafo, comparador);
	}
	
	@Test
	public void solucionTest() 
	{	
		Set<Integer> solucion = solverGoloso.resolver();
		
		int tamanioSolucionEsperada = 2;
		
		assertEquals(tamanioSolucionEsperada, solucion.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void grafoNullTest() 
	{	
		this.grafo = null;
		
		this.solverGoloso = new SolverGoloso(grafo, comparador);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void comparatorNullTest() 
	{	
		Comparator<VerticeNegocio> comparador = null;
		
		this.solverGoloso = new SolverGoloso(grafo, comparador);
	}
	
	@Test
	public void verticeAisladoTest() 
	{	
		//Agrega el vertice 6
		grafo.agregarVertice();
		
		this.solverGoloso = new SolverGoloso(grafo, comparador);
		Set<Integer> solucion = solverGoloso.resolver();
		
		assertTrue(solucion.contains(6));
	}
	
	@Test
	public void todosAisladosTest() 
	{	
		this.grafo = new Grafo(6);
		
		this.solverGoloso = new SolverGoloso(grafo, comparador);
		Set<Integer> solucion = solverGoloso.resolver();
		
		//la solucion debe ser igual al conjunto de vertices
		assertEquals(solucion.size(), grafo.vertices());
	}

}
