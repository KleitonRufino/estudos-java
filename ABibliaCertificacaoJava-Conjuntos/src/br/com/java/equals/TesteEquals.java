package br.com.java.equals;

import java.util.Date;

public class TesteEquals {

	public static void main(String[] args) {
		Integer i1 = new Integer(20);
		Integer i2 = new Integer(20);
		if(i1.equals(i2) && (i1.hashCode() == i2.hashCode()))
			System.out.println("metodos sobrescritos para wrappers");
		
		String s1 = "Roberto";
		String s2 = new String("Roberto");
		if(s1.equals(s2) && (s1.hashCode() == s2.hashCode()))
			System.out.println("metodos sobrescritos para String");
		
		Date d1 = new Date();
		Date d2 = new Date();
		if(d1.equals(d2) && (d1.hashCode() == d2.hashCode()))
			System.out.println("metodos sobrescritos para Date");
	}

}
