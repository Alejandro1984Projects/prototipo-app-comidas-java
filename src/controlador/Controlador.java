package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Producto;

public class Controlador {
	
	public static void borrarLista() {
		
		File fichero = new File("lista.txt"); 
		fichero.delete();
	}
	
			
	public static void guardarFichero(ArrayList<Producto> guardarlista){
		
        try{
            ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("lista.txt"));
                    
            oos.writeObject(guardarlista);            
           
            oos.close();
        }
        catch(Exception e){}
    }
	
	public static void agregar(int _precio, int _cantidad, String _nombreCombo) {
		
		ArrayList<Producto> lista=new ArrayList<Producto>();
			
		lista=leerLista();
		lista.add(new Producto(_precio, _cantidad,_nombreCombo));
		guardarFichero(lista);
		
	}
	
	public static ArrayList<Producto> leerLista(){
		
		ArrayList<Producto> nuevalista=new ArrayList<Producto>();
		
		try{

            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("lista.txt"));
                      
            nuevalista=(ArrayList<Producto>) ois.readObject();
                     
            ois.close();            
        }
        catch(Exception e){}		
		
		return nuevalista;
		
		
	}
	
public static void borrarProducto(String nombre) {
		
		ArrayList<Producto> lista=leerLista();
		
		for(Producto p:lista) {
			if (p.nombreCombo.equals(nombre)) {
				lista.remove(p);
				break;
			}
		}
		borrarLista();
		
		guardarFichero(lista);		
		
	}

}
