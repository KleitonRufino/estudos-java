package br.com.java.cintdt.classesinternas;

public class ClasseEstatica {
	// nao existem classes estaticas
	// o static informa que a classe aninhada eh um membro etatico
	//sem ter uma instancia da classe externa
	static class B {
		void imprimir(){
			System.out.println("Class estatica");
		}
	}
	public static void main(String[] args) {
		B b = new B(); // independe da classe externa
		b.imprimir();
		ClasseEstatica.B x = new ClasseEstatica.B();
		x.imprimir();
		new ClasseEstatica.B().imprimir();
	}
}
