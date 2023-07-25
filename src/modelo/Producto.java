package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Producto implements Serializable{
	
	public int precio;
	public int cantidad;
	public String nombreCombo;
	
	public Producto(int _precio, int _cantidad, String _nombreCombo) {
		
		precio=_precio;
		cantidad=_cantidad;
		nombreCombo=_nombreCombo;
		
	}
}
