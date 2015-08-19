package br.com.java.collection.comparable.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivroSortComparableI {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add(new LivroI(123, "Java"));
		l.add(new LivroI(124, "Delphi"));
		l.add(new LivroI(121, "C#"));
		l.add(new LivroI(125, "C++"));
		
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
	}

}
