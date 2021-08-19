package interfazGrafica;
import java.awt.EventQueue;

public class Pantalla {

	private Pizarra pizarra;	
	private MenuSuperior menuSuperior;
	private MenuInferior menuInferior;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.pizarra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {			
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {			
		pizarra = new Pizarra();
		this.menuInferior = new MenuInferior(pizarra);
		this.menuSuperior = new MenuSuperior(menuInferior);		
		pizarra.getContentPane().add(menuSuperior);
		pizarra.getContentPane().add(menuInferior);	
	}	
}

