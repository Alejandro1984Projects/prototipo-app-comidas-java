package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Interfaz {
	
	JFrame marco = new JFrame();
	JPanel contenedor = new JPanel();
	JPanel contenedorReemplazo = new JPanel();
	JPanel contenedorBotones=new JPanel();
	JLabel label=new JLabel();
	
public Interfaz() {
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		contenedor.setLayout(new BorderLayout(0,0));
		
		label.setIcon(new ImageIcon("src/imagenes/welcome.png"));
						
		JButton btnActivos = new JButton("Ver Productos");
		btnActivos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				contenedorReemplazo.removeAll();
				contenedorReemplazo.add(InterfazProductos.crearInterfaz());
				contenedor.updateUI();
			}
		});
		contenedorBotones.add(btnActivos);
		
		JButton btnConsultas= new JButton("Ver Compra");
		btnConsultas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				contenedorReemplazo.removeAll();
				contenedorReemplazo.add(InterfazCompra.crearInterfaz());
				contenedor.updateUI();
			}
		});
		contenedorBotones.add(btnConsultas);
		
		contenedorReemplazo.setBackground(new Color(25,255,255));
		
		contenedorReemplazo.setBorder(new EmptyBorder(30,0,0,0));
		
		contenedorBotones.setBorder(new EmptyBorder(25,0,25,0));
		
		contenedorBotones.setBackground(new Color(192, 192, 192));
		
		contenedorReemplazo.add(label);

		contenedor.add(contenedorReemplazo, BorderLayout.CENTER);
		contenedor.add(contenedorBotones, BorderLayout.SOUTH);
		
		marco.add(contenedor);

		marco.setVisible(true);
		marco.setBounds(0, 0, 1500, 700);
		
		
	}


}
