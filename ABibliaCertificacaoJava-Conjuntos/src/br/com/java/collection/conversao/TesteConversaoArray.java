package br.com.java.collection.conversao;

import java.util.Arrays;
import java.util.List;

import br.com.java.collection.comparable.Cliente;

public class TesteConversaoArray {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Roberto", 30);
		Cliente c2 = new Cliente("Marcelo", 31);
		Cliente c3 = new Cliente("Roberto", 32);
		Cliente c4 = new Cliente("Ana", 28);
	
		Cliente[] c = {c1, c2, c3, c4};
		List ar = Arrays.asList(c);
		System.out.println(ar);
		
		Object[] convertido = ar.toArray();
		for(Object o:convertido)
				System.out.println((Cliente)o + "");
		
	}

}
