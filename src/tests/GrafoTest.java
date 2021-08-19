package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import codigoNegocio.Grafo;

public class GrafoTest {

	public Grafo inicializar() 
	{
		Grafo grafo = new Grafo(5);
		
		grafo.agregarArista(1, 4);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(3, 2);
		grafo.agregarArista(0, 3);
		
		return grafo;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticesNegativoTest()
	{
		@SuppressWarnings("unused")
		Grafo grafo = new Grafo(-2);
	}

	@Test
	public void agregarAristaTest()
	{
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, 3);
		
		assertTrue(grafo.existeArista(4, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarAristaVerticesInexistentesTest()
	{
		Grafo grafo = inicializar();
		
		grafo.agregarArista(7, 12);
		
		assertTrue(grafo.existeArista(7, 12));
	}
	
	@Test
	public void eliminarAristaTest()
	{
		Grafo grafo = inicializar();
		
		grafo.eliminarArista(0, 3);
		
		assertFalse(grafo.existeArista(0, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void eliminarAristaVerticesInexistentesTest()
	{
		Grafo grafo = inicializar();
		
		grafo.eliminarArista(0, 9);
		
		assertFalse(grafo.existeArista(0, 9));
	}
	
	@Test
	public void existeAristaTest()
	{
		Grafo grafo = inicializar();
		
		assertTrue(grafo.existeArista(0, 3));
	}
	
	@Test
	public void noExisteAristaTest()
	{
		Grafo grafo = inicializar();
		
		assertFalse(grafo.existeArista(4, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void existeAristaVerticesInexistentesTest()
	{
		Grafo grafo = inicializar();
		
		assertTrue(grafo.existeArista(-3, 13));
	}
	
	@Test
	public void agregarVerticeTest() 
	{
		Grafo grafo = inicializar();
		
		grafo.agregarVertice();
		int verticesEsperados = 6;
		
		assertEquals(verticesEsperados, grafo.vertices());
	}
	
	
}
