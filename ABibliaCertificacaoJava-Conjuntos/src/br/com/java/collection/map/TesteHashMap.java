package br.com.java.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TesteHashMap {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//atualizacoes mais rapidas
		//permite chaves e valores nulos
		
		Map<Integer, String> lista = new HashMap<>();
		lista.put(1, "Roberto");
		lista.put(2, "Andrea");
		lista.put(3, "Roberto");
		lista.put(4, "Rubens");
		lista.put(1, "Roberto");
		lista.put(null, "Osvaldo");
		lista.put(null, "Carla");
		lista.put(null, "Carla");
		
		System.out.println(lista.get(1));
		System.out.println(lista.get(4));
		System.out.println(lista.get(0));
		System.out.println(lista.get(null));
	
		lista.remove(1);
		System.out.println(lista.get(1));
		System.out.println(lista.containsKey(2));
		System.out.println(lista.containsValue("Carla"));
		System.out.println(lista.size());
		
		Collection c = lista.values();
		Iterator i = c.iterator();
		while(i.hasNext())
			System.out.println(i.next() + " ");
	}

}
