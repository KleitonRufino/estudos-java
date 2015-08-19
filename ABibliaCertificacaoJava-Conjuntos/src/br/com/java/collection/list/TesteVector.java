package br.com.java.collection.list;


import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TesteVector {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//Mais lento que o arraylist
		//metodos sao sincronizados
		
		long inicio, fim;
		int n = 2600000;
		inicio = System.currentTimeMillis();
		List vect = new Vector();

		for (int i = 0; i < n; i++)
			vect.add(new Integer(i));

		fim = System.currentTimeMillis();
		System.out.println("tempo para inserir: " + (fim - inicio) / 1000.000
				+ " segundo");

		inicio = System.currentTimeMillis();
		Iterator o = vect.iterator();
		while (o.hasNext()) {
			@SuppressWarnings("unused")
			Integer x = (Integer) o.next();
		}
		fim = System.currentTimeMillis();
		System.out.println("Tempo para iterar: " + (fim - inicio) / 1000.000
				+ " segundo");
	}

}
