package vista;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Producto;

public class InterfazCompra {
	
	static JPanel contenedor2;
	
	public static JPanel crearInterfaz() {
		
		JPanel contenedor=new JPanel();
		
		JPanel contenedor1=new JPanel();
		contenedor2=new JPanel();
		JPanel contenedor3=new JPanel();		
				
		contenedor.setLayout(new BorderLayout());
		
		contenedor2.setLayout(new BoxLayout(contenedor2, BoxLayout.Y_AXIS));
				
		contenedor1.add((new JLabel("Lista de Compra")));
				
		mostrarLista();
		
		JButton borrarLista = new JButton("Borrar Lista");
		borrarLista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				
				Controlador.borrarLista();
				mostrarLista();
				
			}
		});
					
		contenedor3.add(borrarLista);
		
		contenedor1.setBorder(new EmptyBorder(25, 0, 25, 0));
		
		contenedor2.setBackground(new Color(255,255,255));
		
		contenedor2.setBorder(new EmptyBorder(50, 50, 50, 50));
		
		contenedor3.setBorder(new EmptyBorder(25, 0, 25, 0));
		
		contenedor.add(contenedor1,BorderLayout.NORTH);	
		contenedor.add(contenedor2,BorderLayout.CENTER);	
		contenedor.add(contenedor3,BorderLayout.SOUTH);	

		
		return contenedor;
		
	}
	
	public static void mostrarLista() {
		
		contenedor2.removeAll();
		contenedor2.updateUI();
				
		ArrayList<Producto> lista=Controlador.leerLista();
		int total=0;
		
		for(Producto p:lista) {
			
			JPanel contProducto=new JPanel();
					
			contProducto.add(new JLabel(p.cantidad+" "+p.nombreCombo+" "+"$"+p.precio*p.cantidad));
			JButton boton=new JButton("borrar producto");
			boton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					
					Controlador.borrarProducto(p.nombreCombo);
					mostrarLista();
					
				}
			});
			contProducto.add(boton);
			contProducto.setBorder(new EmptyBorder(15, 0, 15, 0));
			total+=p.cantidad*p.precio;
			contenedor2.add(contProducto);
		}
		JPanel contTotal=new JPanel();
		contTotal.add(new JLabel("Total= "+total));
		contenedor2.add(contTotal);
		
	}

}
