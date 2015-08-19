package br.com.boaspraticas.generics;

public class TesteGenericsParametrizado<T, X> {
	private T primeiro;
	private X segundo;

	public TesteGenericsParametrizado(T primeiro, X segundo) {
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	public T getT() {
		return primeiro;
	}

	public X getX() {
		return segundo;
	}

	public static void main(String[] args) {
		TesteGenericsParametrizado<String, Integer> teste = new TesteGenericsParametrizado<String, Integer>(
				"string 1", 10);
		String primeiroValor = teste.getT(); // retorna String
		int segundoValor = teste.getX(); // retorna Integer e faz o unboxing
											// para int
		System.out.println(primeiroValor);
		System.out.println(segundoValor);
	}
}