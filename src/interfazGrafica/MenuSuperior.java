package interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.AristaTO;
import controller.Controller;

@SuppressWarnings("serial")
public class MenuSuperior extends JPanel{
	private ArrayList<AristaTO> aristasTO;
	private JButton btnCDM;
	private JLabel mostrarSolucionLabel;
	private Controller controller;
	private ArrayList<Vertice> vertices;
	private ArrayList<Arista> aristas;
	private Pizarra pizarra;
	private MenuInferior menuInferior;
	
	
	public MenuSuperior(MenuInferior menuInferior) {
		this.aristasTO= new ArrayList<AristaTO>();
		this.pizarra = menuInferior.getFrame();
		this.menuInferior = menuInferior;		
		configurarMenu();
		configurarLabel();
		configurarButton();
	}
	
	private void configurarMenu(){
		setBounds(0, 0, 484, 46);
		setBackground(Color.ORANGE);
		setLayout(null);
	}
	
	private void configurarLabel() {
		this.mostrarSolucionLabel = new JLabel();
		this.mostrarSolucionLabel.setBounds(187, 11, 287, 21);
		add(this.mostrarSolucionLabel);
	}
	
	private void configurarButton() {
		this.btnCDM = new JButton("Conjunto Dominante Minimo");
		this.btnCDM.setFont(new Font("Dialog", Font.BOLD, 9));
		this.btnCDM.setBounds(12, 10, 165, 25);
		add(this.btnCDM);		
		btnCDM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				    vertices = menuInferior.getVertices();
				    aristas = menuInferior.getAristas();				    
				    generarTO(aristas);			
				    controller = new Controller(aristasTO, vertices.size());
				    mostrarSolucionLabel.setText(controller.getCDM().toString());
				    mostrarSolucion(controller.getCDM());
			}	
		});	
	}
	
    public void generarTO(ArrayList<Arista> aristas) {
		
		this.aristasTO.clear();
		
		for(int i = 0; i<aristas.size(); i++) {
			this.aristasTO.add(new AristaTO(aristas.get(i).getVertice1().getNumero(),aristas.get(i).getVertice2().getNumero()));
		}
	}
    
	public void mostrarSolucion (Set<Integer> CDM) 
	{		
		for (Integer vertice : CDM) 
		{
			for(int i=0;i<vertices.size();i++) 
			{
				if(vertices.get(i).getNumero().equals(vertice)) 
				{						
					Graphics circuloVertice= pizarra.getGraphics();				
					circuloVertice.setColor(Color.RED);
					circuloVertice.drawOval(vertices.get(i).getCoordenada().x, vertices.get(i).getCoordenada().y, 5, 5);		
					this.menuInferior.getNumerosDeVertices().get(i).setForeground(Color.RED);						
				}
			}
		}
	}
	
	public ArrayList<AristaTO> getAristasTO() {
		return aristasTO;
	}

}
