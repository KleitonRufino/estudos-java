package br.com.java.collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TesteTreeSet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//TreeSet sem duplicatas, itera por ordem classificada
		//classificada e ordenada
		Set s = new TreeSet();
		s.add(new Integer(10));
		s.add(new Integer(10));
		s.add(new Integer(11));
		s.add(new Integer(12));
		s.add(new Integer(5) + 5);
		System.out.println(s);
	
		Set s1 = new TreeSet();
		s1.add("Roberto");
		s1.add("Roberto");
		s1.add("Marcelo");
		s1.add("Osvaldo");
		s1.add(new String("Osvaldo"));
		System.out.println(s1);
		
		
	}

}
