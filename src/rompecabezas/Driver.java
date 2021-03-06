package rompecabezas;
import java.util.HashMap;
import java.util.List;

import algoritmos.BFS;
import algoritmos.DFS;
import algoritmos.Heuristic;


public class Driver {

	public static int numHilos = 6;
	public static boolean REPETIDO;
	public static HashMap<String,Integer> HILOS;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tStart,tDelta,tEnd;
		double elapsedSeconds;
		int contador = 1;
		int[][] headbreaker = { {0,1,6},
								{4,3,7},
								{5,2,8}};
		Estado s = new Estado(Integer.toString(contador),headbreaker);
		
		tStart = System.currentTimeMillis();
		
		List<Estado> estados = new Generador().crearEstados(s);
		for(Estado i: estados) {
			i.verPropiedades();
		}
	
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		
		System.out.println("Termino generador de estados\nTiempo en segs: " + elapsedSeconds);
		
		//definir el estado a buscar
		int[][] solucion = { {3,0,7},
						     {1,6,4},
						     {5,2,8}};
		Estado objetivo = new Estado(solucion);
		boolean existe;
		
		System.out.println("\nbusqueda por profundidad");
		tStart = System.currentTimeMillis();
		DFS bus1 = new DFS(estados);
		
		existe = bus1.existeEstado(objetivo);
		
		if(existe)
			System.out.println("El estado existe");
		else
			System.out.println("El estado no existe :(");
		
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		
		System.out.println("Termino busqueda en produndidad\nTiempo en segs: " + elapsedSeconds);
		
		System.out.println("\nbusqueda por amplitud");
		tStart = System.currentTimeMillis();
		BFS bus2 = new BFS(estados);
		existe = bus2.existeEstado(objetivo);
		
		if(existe)
			System.out.println("El estado existe");
		else
			System.out.println("El estado no existe :(");
		
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		
		System.out.println("Termino busqueda en amplitud\nTiempo en segs: " + elapsedSeconds);
		
		System.out.println("\nbusqueda heuristica");
		tStart = System.currentTimeMillis();
		Heuristic bus3 = new Heuristic(estados);
		existe = bus3.existeEstado(objetivo);
		
		if(existe)
			System.out.println("El estado existe");
		else
			System.out.println("El estado no existe :(");
		
		tEnd = System.currentTimeMillis();
		tDelta = tEnd - tStart;
		elapsedSeconds = tDelta / 1000.0;
		
		System.out.println("Termino busqueda heuristica\nTiempo en segs: " + elapsedSeconds);
	}

}
