package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import rompecabezas.Estado;
import rompecabezas.Operador;

public class BFS implements SearchMethods {
	
	List<Estado> estados;
	
	public BFS() {
		this.estados = new ArrayList<Estado>();
	}
	
	public BFS(List<Estado> estados) {
		this.estados = estados;
	}

	@Override
	public Estado buscarEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		Queue<Estado> cola =  new LinkedList<Estado>();
		cola.add(this.estados.get(0));
		int[][] matriz_obj = (int[][])objetivo.getInfo();
		boolean cola_vacia = cola.isEmpty();
		
		while(!cola_vacia) {
			Estado head = cola.poll();
			HashMap<Operador,Estado> enlaces = head.getEnlaces();
			for(Map.Entry <Operador,Estado> entry : enlaces.entrySet()) { //tenemos que agregar todos los estados a este nivel del arbol directamente a la cola
				cola.add(entry.getValue());
			}
			int[][] matriz = (int[][])head.getInfo();
			boolean iguales = Arrays.deepEquals(matriz, matriz_obj);
			if(iguales) { //si encontro el estado deseado
				System.out.println("la solucion fue encontrada en el estado actual");
				head.verPropiedades();
				return head;
			}
			else { //no son iguales, sigamos buscando
				//System.out.println("la solucion no esta en el estado actual -> " + head.getNombre());
			}
			
			cola_vacia = cola.isEmpty();
		}
		
		return null;
	}

	@Override
	public boolean existeEstado(Estado objetivo) {
		// TODO Auto-generated method stub
		Queue<Estado> cola =  new LinkedList<Estado>();
		cola.add(this.estados.get(0));
		int[][] matriz_obj = (int[][])objetivo.getInfo();
		boolean cola_vacia = cola.isEmpty();
		
		while(!cola_vacia) {
			Estado head = cola.poll();
			HashMap<Operador,Estado> enlaces = head.getEnlaces();
			for(Map.Entry <Operador,Estado> entry : enlaces.entrySet()) { //tenemos que agregar todos los estados a este nivel del arbol directamente a la cola
				cola.add(entry.getValue());
			}
			int[][] matriz = (int[][])head.getInfo();
			boolean iguales = Arrays.deepEquals(matriz, matriz_obj);
			if(iguales) { //si encontro el estado deseado
				System.out.println("la solucion fue encontrada en el estado actual");
				head.verPropiedades();
				return true;
			}
			else { //no son iguales, sigamos buscando
				//System.out.println("la solucion no esta en el estado actual -> " + head.getNombre());
			}
			
			cola_vacia = cola.isEmpty();
		}
		
		return false;
	}

}
