package codigoNegocio;

public class Main {

	public static void main(String[] args) {
		Grafo g = new Grafo (20);
		g.agregarArista(0, 1);
		g.agregarArista(0, 4);
		g.agregarArista(1, 4);
		g.agregarArista(3, 4);
		g.agregarArista(3, 2);
		g.agregarArista(3, 5);
		g.agregarArista(2, 1);
		g.agregarArista(5, 6);
		
		SolverGoloso solverGoloso = new SolverGoloso(g, new ComparatorPorGrado());
		
		System.out.println(solverGoloso.resolver());
		
		SolverBacktracking solverBacktracking = new SolverBacktracking(g);
		
		System.out.println(solverBacktracking.resolver());
		
	}

}
