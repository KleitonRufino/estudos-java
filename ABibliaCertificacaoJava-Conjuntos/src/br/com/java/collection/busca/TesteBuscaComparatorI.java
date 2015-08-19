package br.com.java.collection.busca;

import java.util.Arrays;

public class TesteBuscaComparatorI {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] lista = {"um", "dois", "tres", "quatro"};
		Arrays.sort(lista);
		for(String s : lista)
			System.out.print(s + " ");
		System.out.println("Indice: " + Arrays.binarySearch(lista, "dois"));
		
		ComparatorReverso cr = new ComparatorReverso();
		Arrays.sort(lista, cr);
		for(String s : lista)
			System.out.print(s + " ");
		System.out.println("Indice: " + Arrays.binarySearch(lista, "dois", cr));
	}

}
