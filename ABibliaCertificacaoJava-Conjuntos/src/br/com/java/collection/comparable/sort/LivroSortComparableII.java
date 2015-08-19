package br.com.java.collection.comparable.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivroSortComparableII {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(new LivroII(123, "Java"));
		l.add(new LivroII(124, "Delphi"));
		l.add(new LivroII(121, "C#"));
		l.add(new LivroII(125, "C++"));
		
		System.out.println(l);
		Collections.sort(l, new ComparatorLivro());
		System.out.println(l);
	}

}
