package br.com.java.cintdt.classesinternas;

public class ClasseAnonima {
	public int getInfo(){
		return 10;
	}
	class Gerente{
		ClasseAnonima ca = new ClasseAnonima(){
			public int getInfo(){
				return 1000;
			}
		};
	}
	public static void main(String[] args) {
		ClasseAnonima ca = new ClasseAnonima();
		ClasseAnonima.Gerente ger = ca.new Gerente();
		
		System.out.println(ca.getInfo());
		System.out.println(ger.ca.getInfo());
		
	}
}
