package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

public class InterfazProductos {
	
	public static JPanel crearInterfaz() {
			
			JPanel contenedor=new JPanel();
			JPanel contenedorContenido=new JPanel();
			JPanel contenedorTitulo=new JPanel();
			JPanel contenedor1=new JPanel();
			JPanel contenedor2=new JPanel();
			JPanel contenedor3=new JPanel();

			JLabel imagenPizza=new JLabel();
			JLabel imagenHotdog=new JLabel();
			JLabel imagenHamburger=new JLabel();
			
			JSpinner spinner1=new JSpinner();
			JSpinner spinner2=new JSpinner();
			JSpinner spinner3=new JSpinner();
			
			spinner1.setValue(1);
			spinner2.setValue(1);
			spinner3.setValue(1);
						
			contenedor.setLayout(new BorderLayout());
			
			contenedorContenido.setLayout(new GridLayout(0, 3));
			
			contenedor1.setLayout(new BoxLayout(contenedor1, BoxLayout.Y_AXIS));
			contenedor2.setLayout(new BoxLayout(contenedor2, BoxLayout.Y_AXIS));
			contenedor3.setLayout(new BoxLayout(contenedor3, BoxLayout.Y_AXIS));

			contenedorTitulo.add(new JLabel("Productos"));
			contenedor.add(contenedorTitulo, BorderLayout.NORTH);			
			
			contenedor1.add(new JLabel("Combo 1"));
			contenedor1.add(new JLabel("Pizza + Jugo"));
			contenedor1.add(new JLabel("$ 15000"));

			imagenPizza.setIcon(new ImageIcon("src/imagenes/pizza.png"));
					
			contenedor1.add(imagenPizza);	
			
			contenedor1.add(spinner1);
			
			JButton btnCrearPizza = new JButton("Agregar");
			btnCrearPizza.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					
					Controlador.agregar(15000, Integer.parseInt(spinner1.getValue().toString()),"Pizza");
					
				}
			});
						
			contenedor1.add(btnCrearPizza);	
			
			contenedor2.add(new JLabel("Combo 2"));
			contenedor2.add(new JLabel("Hotdog + Papas + Gaseosa"));
			contenedor2.add(new JLabel("$ 35000"));

			imagenHotdog.setIcon(new ImageIcon("src/imagenes/hot-dog.png"));
			
			contenedor2.add(imagenHotdog);
			
			contenedor2.add(spinner2);
			
			JButton btnCrearHotdog = new JButton("Agregar");
			btnCrearHotdog.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					
					Controlador.agregar(35000, Integer.parseInt(spinner2.getValue().toString()),"Hotdog");
					
				}
			});
			
			contenedor2.add(btnCrearHotdog);
			
	
			contenedor3.add(new JLabel("Combo 3"));
			contenedor3.add(new JLabel("Hamburguesa + Papas + Malteada"));
			contenedor3.add(new JLabel("$ 50000"));

			imagenHamburger.setIcon(new ImageIcon("src/imagenes/hamburger.png"));
			
			contenedor3.add(imagenHamburger);
			
			contenedor3.add(spinner3);			
			
			JButton btnCrearHamburger = new JButton("Agregar");
			btnCrearHamburger.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					
					Controlador.agregar(50000, Integer.parseInt(spinner3.getValue().toString()),"Hamburguesa");
					
				}
			});
			
			contenedor3.add(btnCrearHamburger);	
			
			contenedorContenido.setBackground(new Color(255,255,255));
			
			contenedorTitulo.setBackground(new Color(255,255,0));
			
			contenedorTitulo.setBorder(new EmptyBorder(30,0,30,0));
			
			contenedor1.setBorder(new EmptyBorder(50,50,50,50));
			contenedor2.setBorder(new EmptyBorder(50,50,50,50));
			contenedor3.setBorder(new EmptyBorder(50,50,50,50));
			
			imagenPizza.setBorder(new EmptyBorder(65,0,65,0));
			imagenHotdog.setBorder(new EmptyBorder(75,0,70,0));
			imagenHamburger.setBorder(new EmptyBorder(50,0,50,0));
			
			contenedorContenido.add(contenedor1);
			contenedorContenido.add(contenedor2);
			contenedorContenido.add(contenedor3);
								
			contenedor.add(contenedorContenido, BorderLayout.CENTER);
					
			return contenedor;
			
		}


}
