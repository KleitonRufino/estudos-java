package br.com.java.collection.map;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class TesteHashTable {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// metodos sao sincronizados
		// mais lento que hashmap
		// nao aceita chave nem valor nulos

		Map lista = new Hashtable<>();
		CarroMap c1 = new CarroMap(1);
		CarroMap c2 = new CarroMap(2);
		CarroMap c3 = new CarroMap(3);
		CarroMap c4 = new CarroMap(1);
		CarroMap c5 = new CarroMap(2);

		lista.put(c1, "Mariana");
		lista.put(c2, "Roberto");
		lista.put(c3, "Stella");
		lista.put(c4, "Rubens");
		lista.put(c5, "Tralala");

		Collection c = lista.values();
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next() + " ");
		}

	}

}
