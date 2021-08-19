package interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.swt.graphics.Point;

@SuppressWarnings("serial")
public class MenuInferior extends JPanel{
	private JButton btnGenerarVertice;
	private JButton btnGenerarArista;
	private JTextField vertice1TextField;
	private JTextField vertice2TextField;
	private MouseAdapter mouseListener;
	private ArrayList<JLabel> numerosDeVertices;
	private ArrayList<Vertice> vertices;
	private ArrayList<Arista> aristas;
	private Pizarra pizarra;
	private int limiteDerecho;
	private int limiteIzquierdo;
	private int limiteSuperior;
	private int limiteInferior;
	
	public MenuInferior(Pizarra pizarra) {
		this.pizarra = pizarra;
		this.numerosDeVertices = new ArrayList<>();
		this.vertices = new ArrayList<>();
		this.aristas = new ArrayList<>();
		limiteDerecho= 460;
		limiteIzquierdo=  32;
		limiteSuperior= 95;
		limiteInferior=  290;
		configurarMenu();
		configurarTextFields();
		configurarMouseListener();
		configurarGenerarVertice();
		configurarGenerarArista();
	}

	private void configurarMenu(){
		setBounds(0, 292, 484, 79);
		setBackground(Color.ORANGE);
		setLayout(null);
	}
	
	private void configurarTextFields() {
		vertice1TextField = new JTextField();
		vertice1TextField.setBounds(325, 340, 37, 25);
		vertice1TextField.setColumns(10);
		pizarra.getContentPane().add(vertice1TextField);		
		vertice2TextField = new JTextField();
		vertice2TextField.setBounds(370, 340, 37, 25);
		vertice2TextField.setColumns(10);
		pizarra.getContentPane().add(vertice2TextField);
	}
	

	
	private void configurarMouseListener() {
		mouseListener = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evento) {
				if(evento.getX()<limiteDerecho && evento.getX()>limiteIzquierdo && evento.getY() <limiteInferior && evento.getY() > limiteSuperior ){
				Graphics circuloVertice= pizarra.getGraphics();				
				circuloVertice.setColor(Color.BLUE);
				circuloVertice.drawOval(evento.getX()-7, evento.getY()-5, 5, 5);
				numerosDeVertices.add(new JLabel());
				numerosDeVertices.get(numerosDeVertices.size()-1).setBounds(evento.getX()-7, evento.getY()-30, 20, 20);
				pizarra.getContentPane().add(numerosDeVertices.get(numerosDeVertices.size()-1));
				numerosDeVertices.get(numerosDeVertices.size()-1).setText( "" + (numerosDeVertices.size()-1));
				Vertice vertice = new Vertice(new Point(evento.getX()-7, evento.getY()-5),numerosDeVertices.size()-1);
				vertices.add(vertice);
				pizarra.removeMouseListener(mouseListener);
				}else {
					pizarra.removeMouseListener(mouseListener);
				}
			}
		};		
	}
	
	private void configurarGenerarVertice() {
		btnGenerarVertice = new JButton("Generar vertice");
		btnGenerarVertice.setFont(new Font("Dialog", Font.BOLD, 9));
		btnGenerarVertice.setBounds(12, 340, 117, 25);
		pizarra.getContentPane().add(btnGenerarVertice);		
		btnGenerarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pizarra.addMouseListener(mouseListener);	
			}
		});
	}
	
	private void configurarGenerarArista() {
		btnGenerarArista = new JButton("Generar arista");
		btnGenerarArista.setFont(new Font("Dialog", Font.BOLD, 9));
		btnGenerarArista.setBounds(200, 340, 117, 25);
		pizarra.getContentPane().add(btnGenerarArista);		
		btnGenerarArista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String inputVertice1 = vertice1TextField.getText();
					String inputVertice2 = vertice2TextField.getText();					
					if(verificarInputs(inputVertice1) && verificarInputs(inputVertice2)){					
						int vertice1 = Integer.parseInt(inputVertice1);
						int vertice2 = Integer.parseInt(inputVertice2);
						if(verificarVertice(vertice1) && verificarVertice(vertice2) && vertice1 != vertice2) 
						{
							Graphics lineaArista= pizarra.getGraphics();
							lineaArista.drawOval(vertice1, vertice2, 2, 2);						
							Vertice vertice_1 = vertices.get(vertice1);
							Vertice vertice_2 = vertices.get(vertice2);						
							lineaArista.drawLine(vertice_1.getCoordenada().x+2, vertice_1.getCoordenada().y+2, vertice_2.getCoordenada().x+2,vertice_2.getCoordenada().y+2);						
							Arista nuevaArista= new Arista(vertice_1,vertice_2);
							aristas.add(nuevaArista);
						}
					}
					vertice1TextField.setText("");	
					vertice2TextField.setText("");	
				}

			
			});
	}
	private boolean verificarInputs(String input) {
		if(input.equals("")) 
		{
			return false;
		}
		try {
			Integer.parseInt(input);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private boolean verificarVertice(int vertice) {
		if(vertice < 0 || vertice >= vertices.size())
			return false;
		return true;
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public Pizarra getFrame() {
		return pizarra;
	}

	public ArrayList<JLabel> getNumerosDeVertices() {
		return numerosDeVertices;
	}	
	
}
