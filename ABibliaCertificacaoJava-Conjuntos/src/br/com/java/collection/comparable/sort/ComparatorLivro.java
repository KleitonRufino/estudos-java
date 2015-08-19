package br.com.java.collection.comparable.sort;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class ComparatorLivro implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		LivroII l1 = (LivroII) obj1;
		LivroII l2 = (LivroII) obj2;
		return l2.isbn.compareTo(l1.isbn);
	}
	
}
