package br.com.java.equals;

public class TesteString {

	public static void main(String[] args) {
		String s1 = "XX";
		String s2 = new String("XX");
		if(s1 == s2)
			System.out.println("FIRST IS EQUAL");
		else
			System.out.println("FIRST IS NOT EQUAL");
		String e1 = "XX";
		String e2 = new String("XX");
		if(e1 == e2)
			System.out.println("SECOND IS EQUAL");
		else{
			System.out.println("SECOND IS NOT EQUAL");
			System.out.println(e1.hashCode() + " " +  e2.hashCode());
			System.out.println(e1.equals(e2));
		}
	}

}
