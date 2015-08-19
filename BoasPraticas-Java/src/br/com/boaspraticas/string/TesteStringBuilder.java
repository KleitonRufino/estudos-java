package br.com.boaspraticas.string;

public class TesteStringBuilder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Concatenar com StringBuilder ou StringBuffer

		// Ma pratica
		// concat = sao criadas copias dos objetos
		String sobrenome = "Rufino";
		String nome = "Kleiton";
		String var1 = sobrenome + ", " + nome + "; ";
		System.out.println(var1);
		// Boa pratica
		// Permite melhor performance
		// Armazena caracteres especificados pela sua capacidade, caso ela seja
		// excedida, eh aumentada para acomodar os caracteres adicionais;
		// Não precisa alocar novos objetos quando realiza uma concatenacao;
		// Não são sincronizadas;
		// Não são seguras para threads;

		StringBuilder var2 = new StringBuilder(sobrenome).append(", ")
				.append(nome).append("; ");
		System.out.println(var2);
	
		// length - Retorna o numero de caracteres atualmente em um
		// StringBuilder;
		// capacity – Retorna o número de caracteres que pode ser armazenado em
		// um StringBuilder sem alocar mais memória;
		// ensureCapacity – Garante que um StringBuilder tenha pelo menos a
		// capacidade especificada;
		// setLength – Aumenta ou diminui o comprimento de uma StringBuilder;
		// charAt – Aceita um argumento inteiro que representa o indice e
		// retorna o caractere nessa posição no StringBuilder;
		// setCharAt – Copia caracteres de um StringBuilder no array de
		// caracteres passado como um argumento, tendo aceitação de ate 4
		// argumentos;

		int numeroDePosts = 3;

		String status = (numeroDePosts < 4) ? "número baixo de posts"
				: "bom número de posts";

		System.out.println("O status de publicações desse blog é: " + status);
	}

}
