package br.com.java.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteArrayList {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//Acesso sequencial/aleatorio extremamente rapido
		//Em funcao do indice um acesso ao meio da lista eh extremamente rapido
		//insercao extremamente rapida
		
		long inicio, fim;
		int n = 2600000;
		inicio = System.currentTimeMillis();
		List array = new ArrayList();
		
		for(int i = 0; i < n; i++)
			array.add(new Integer(i));
	
	fim = System.currentTimeMillis();
	System.out.println("tempo para inserir: " + (fim - inicio)/1000.000 + " segundo");
		
	inicio = System.currentTimeMillis();
	Iterator o = array.iterator();
	while(o.hasNext()){
		@SuppressWarnings("unused")
		Integer x = (Integer)o.next();
	}
		fim = System.currentTimeMillis();
		System.out.println("Tempo para iterar: " + (fim - inicio)/1000.000 + " segundo");
	}
}
