package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import codigoNegocio.SolverBacktracking;
import codigoNegocio.SolverGoloso;

public class Controller 
{		

	private Set<Integer> CDM;
	private SolverGoloso solverGoloso;
	private SolverBacktracking solverBacktracking;
	private ArrayList<AristaTO> aristas;
	private Integer cantVertices;
	
	public Controller(ArrayList<AristaTO> aristas,Integer cantVertices) 
	{
		this.CDM = new HashSet<Integer>();	
		this.aristas = aristas;
		this.cantVertices = cantVertices;
		enviarAlNegocio();
		
	}
	
	public void enviarAlNegocio() 
	{
		this.solverGoloso = new SolverGoloso(this.aristas, this.cantVertices);
		this.CDM = this.solverGoloso.getCDM();
	}
	
	public	void enviarAlNegocioBacktracking(ArrayList<AristaTO> aristas,Integer cantVertices) 
	{
		this.solverBacktracking = new SolverBacktracking(aristas, cantVertices);
		this.CDM = this.solverBacktracking.getCDM();
		
	}	


public Set<Integer> getCDM() {
	return CDM;
}


}
