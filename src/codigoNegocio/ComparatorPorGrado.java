package codigoNegocio;

import java.util.Comparator;

public class ComparatorPorGrado implements Comparator<VerticeNegocio>
{

	@Override
	public int compare(VerticeNegocio vertice1, VerticeNegocio vertice2) 
	{
		return -vertice1.grado() + vertice2.grado();
	}

}
