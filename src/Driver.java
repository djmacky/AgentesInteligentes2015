import java.util.ArrayList;
import java.util.List;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int contador = 1;
		int[][] headbreaker = { {1,0,4},
								{3,2,5},
								{6,7,8}};
		Estado s = new Estado(Integer.toString(contador),headbreaker);
		List<Estado> estados = new Generador().crearEstados(s);
		for(Estado i: estados) {
			i.verPropiedades();
		}
		
		
	}

}
