package tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import codigoNegocio.VerticeNegocio;

public class VerticeNegocioTest {

	public VerticeNegocio inicializar() 
	{
		VerticeNegocio vertice = new VerticeNegocio(0);
		vertice.agregarArista(1);
		vertice.agregarArista(2);
		vertice.agregarArista(3);
		vertice.agregarArista(5);
		
		return vertice;
	}
	
	@Test
	public void vecinosTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		Set<Integer> vecinosEsperados = new HashSet<>(Arrays.asList(1,2,3,5));
		
		assertEquals(vecinosEsperados, vertice.vecinos());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void formarCicloTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		vertice.agregarArista(0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void instanciaVerticeNegativoTest() 
	{
		@SuppressWarnings("unused")
		VerticeNegocio vertice = new VerticeNegocio(-5);
	}
	
	@Test
	public void gradoTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		int gradoEsperado = 4;
		
		assertEquals(gradoEsperado, vertice.grado());
	}
	
	@Test
	public void existeAristaTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		assertTrue(vertice.existeArista(3));
	}
	
	@Test
	public void noExisteAristaTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		assertFalse(vertice.existeArista(4));
	}
	
	@Test
	public void agregarAristaTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		vertice.agregarArista(4);
		
		assertTrue(vertice.existeArista(4));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void agregarVerticeNegativoTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		vertice.agregarArista(-4);
	}

	@Test
	public void eliminarAristaTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		vertice.eliminarArista(2);
		
		assertFalse(vertice.existeArista(2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void eliminarVerticeNegativoTest() 
	{
		VerticeNegocio vertice = inicializar();
		
		vertice.eliminarArista(-9);
	}	
}
