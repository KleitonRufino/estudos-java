package br.com.java.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TesteLinkedList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//adequado para insercao de elementos no final (pilhas e filas)
		//iteracao mais lenta que arraylist 
		
		
		long inicio, fim;
		int n = 2600000;
		inicio = System.currentTimeMillis();
		List link = new LinkedList();
	
		for (int i = 0; i < n; i++)
			link.add(new Integer(i));

		fim = System.currentTimeMillis();
		System.out.println("tempo para inserir: " + (fim - inicio) / 1000.000
				+ " segundo");

		inicio = System.currentTimeMillis();
		Iterator o = link.iterator();
		while (o.hasNext()) {
			@SuppressWarnings("unused")
			Integer x = (Integer) o.next();
		}
		fim = System.currentTimeMillis();
		System.out.println("Tempo para iterar: " + (fim - inicio) / 1000.000
				+ " segundo");

	}

}
