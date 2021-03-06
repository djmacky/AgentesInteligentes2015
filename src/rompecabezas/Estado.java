package rompecabezas;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Estado {
	
	String nombre;
	Object info;
	HashMap<Operador,Estado>enlaces;
	boolean visitado;
	
	public Estado() {
		this.nombre = null;
		this.info = null;
		this.visitado = false;
		this.enlaces = new HashMap<Operador,Estado>();
	}
	
	public Estado (Object info){
		this.nombre = null;
		this.info = info;
		this.visitado = false;	
		this.enlaces = new HashMap<Operador,Estado>();
	}
	
	public Estado (String nombre,Object info){
		this.nombre = "Estado " + nombre;
		this.info = info;
		this.visitado = false;	
		this.enlaces = new HashMap<Operador,Estado>();
	}
	
	public void agregarEnlace(Operador operador,Estado estadoDestino) {
		this.enlaces.put(operador, estadoDestino);
	}
	
	public void agregarNombre(int contador) {
		this.nombre = "Estado" + Integer.toString(contador);
	}
	
	public HashMap<Operador,Estado> getEnlaces() {
		return this.enlaces;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Object getInfo() {
		return this.info;
	}
	
	public boolean visitado() {
		return this.visitado;
	}
	
	public void setVisitado(boolean value) {
		this.visitado = value;
	}
	
	// este metodo se usa para imprimir todas las propiedades del estado
	public void verPropiedades() {
		if(this.info instanceof int[][]) {
			System.out.println("---------------");
			System.out.println(this.nombre);
			this.verMatriz();
			this.verEnlaces();
			if(this.visitado)
				System.out.println("Visitado: Si");
			else
				System.out.println("Visitado: No");
			System.out.println("---------------");
		}
	}
	
	// muestra los enlaces del estado, si no tiene no imprime nada
	public void verEnlaces() {
		for(Map.Entry <Operador,Estado> o: this.enlaces.entrySet()) {
			System.out.println("Con: " + o.getKey() +  " hacia " + o.getValue().nombre);
		}
	}
	
	// this method prints any matrix size without returning an index out of bound exception 
	public void verMatriz() {
		if(this.info instanceof int[][]) {
			String matrix = Arrays.deepToString((Object[]) this.info);
			String [] fmtd_matrix = matrix.split("],");
			for(String s: fmtd_matrix) {
				System.out.println(s);
			}
		}
	}
}

