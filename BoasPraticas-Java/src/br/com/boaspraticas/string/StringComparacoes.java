package br.com.boaspraticas.string;

public class StringComparacoes {
	public static void main(String[] args) {
		// Declarar sem o new
		String nome = "Kleiton";
		String sobrenome = "Rufino";

		// comparar com equals
		// == compara referencia de memoria

		System.out.println(sobrenome.equals(nome));

		// evitar comparar variaveis com string para nao receber
		// nullpointerexception
		// ma pratica
		// boolean igual = sobrenome.equals("silva");
		// Boa pratica
		System.out.println("Rufino".equals(sobrenome));

	}
}
