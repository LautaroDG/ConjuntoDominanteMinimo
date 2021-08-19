package tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import codigoNegocio.Grafo;
import codigoNegocio.SolverBacktracking;

public class BacktrackingTest 
{
	
	private Grafo grafo;
	
	private SolverBacktracking solverBacktracking;

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
		
		this.solverBacktracking = new SolverBacktracking(grafo);
	}

	@Test
	public void solucionTest() 
	{	
		Set<Integer> solucion = solverBacktracking.resolver();
		
		int tamanioSolucionEsperada = 2;
		
		assertEquals(tamanioSolucionEsperada, solucion.size());
	}
	
	@Test
	public void noSolucionTest() 
	{	
		Set<Integer> solucion = solverBacktracking.resolver();
		
		int tamanioSolucionEsperada = 5;
		
		assertNotEquals(tamanioSolucionEsperada, solucion.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void grafoNullTest() 
	{	
		this.grafo = null;
		
		this.solverBacktracking = new SolverBacktracking(grafo);
	}
	
	@Test
	public void grafoVacioTest() 
	{	
		this.grafo = new Grafo(0);
		
		this.solverBacktracking = new SolverBacktracking(grafo);
		Set<Integer> solucion = solverBacktracking.resolver();
		
		//la solucion debe ser igual al conjunto de vertices
		assertEquals(0, solucion.size());
	}
	
	@Test
	public void verticeAisladoTest() 
	{	
		//Agrega el vertice 6
		grafo.agregarVertice();
		
		this.solverBacktracking = new SolverBacktracking(grafo);
		Set<Integer> solucion = solverBacktracking.resolver();
		
		assertTrue(solucion.contains(6));
	}

	@Test
	public void todosAisladosTest() 
	{	
		this.grafo = new Grafo(6);
		
		this.solverBacktracking = new SolverBacktracking(grafo);
		Set<Integer> solucion = solverBacktracking.resolver();
		
		//la solucion debe ser igual al conjunto de vertices
		assertEquals(6, solucion.size());
	}
}
