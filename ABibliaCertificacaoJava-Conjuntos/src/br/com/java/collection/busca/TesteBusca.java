package br.com.java.collection.busca;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class TesteBusca {

	public static void main(String[] args) {
		int[] lista = {1, 2, 5, 3, 6, 0};
		Arrays.sort(lista);
		for(int a : lista)
			System.out.print(a + " ");
		System.out.println("Indice: " + Arrays.binarySearch(lista, 5));
		System.out.println("Indice: " + Arrays.binarySearch(lista, 4));
		Date d1 = new Date(300000000L);
		Date d2 = new Date(200000000L);
		Date d3 = new Date();
		
		Date[] datas = {d1, d3, d2};
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		Arrays.sort(datas);
		for(Date d : datas)
			System.out.println(df.format(d) + " ");
		System.out.println("Indice: " + Arrays.binarySearch(datas, d3));
		
	}

}
