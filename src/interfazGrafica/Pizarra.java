package interfazGrafica;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Pizarra extends JFrame {
	private JPanel marcoSuperior;
	private JPanel marcoInferior;	
	private JPanel marcoIzquierdo;
	private JPanel marcoDerecho;

	public Pizarra() 
	{
		setearPizarra();
	}
	
	public void setearPizarra() 
	{
		setBounds(450, 200, 500, 410);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GREEN);
		
		marcoSuperior = new JPanel();
		marcoSuperior.setBackground(Color.LIGHT_GRAY);
		marcoSuperior.setBounds(0, 43, 484, 16);
		getContentPane().add(marcoSuperior);	
		
		marcoInferior = new JPanel();
		marcoInferior.setBackground(Color.LIGHT_GRAY);
		marcoInferior.setBounds(0, 281, 484, 16);
		getContentPane().add(marcoInferior);		
		
		marcoIzquierdo = new JPanel();
		marcoIzquierdo.setBackground(Color.LIGHT_GRAY);
		marcoIzquierdo.setBounds(0, 57, 16, 224);
		getContentPane().add(marcoIzquierdo);		
		
		marcoDerecho = new JPanel();
		marcoDerecho.setBackground(Color.LIGHT_GRAY);
		marcoDerecho.setBounds(468, 57, 16, 224);
		getContentPane().add(marcoDerecho);
		
		getContentPane().setLayout(null);
	}
}