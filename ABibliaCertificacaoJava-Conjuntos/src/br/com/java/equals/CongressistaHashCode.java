package br.com.java.equals;

import java.util.HashMap;

public class CongressistaHashCode {

	private String nome;
	private long cpf;

	public CongressistaHashCode(String nome, long cpf) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public long getCpf() {
		return this.cpf;
	}

	public boolean equals(Object o) {
		if ((o instanceof CongressistaHashCode)
				&& ((CongressistaHashCode) o).getNome().equals(this.getNome())) {
			return true;
		} else
			return false;
	}

	public int hashCode() {
		return getNome().length() * 8;
	}

	public static void main(String[] args) {
		CongressistaHashCode con1 = new CongressistaHashCode("Tiago", 1234567);
		CongressistaHashCode con2 = new CongressistaHashCode("Caio", 76543221);
		
		HashMap<CongressistaHashCode,String> hash = new HashMap<CongressistaHashCode,String>();
		
		// Inserção dos congressistas no HashMap
		hash.put(con1, "Info importante sobre Tiago");
		hash.put(con2, "Info importante sobr Caio");
		
		/*
		 * Criaremos um terceiro congressista e iremos efetuar uma busca
		 * para ver se o algoritimo está, de fato, funcionando.
		 * Não será encontrado o objeto porque Primeiro: não o inserimos no HashMap
		 * Segundo: o tamanho do nome não bate com nenhum tamanho de nome inserido.
		 */
		
		CongressistaHashCode con3 = new CongressistaHashCode("Felipe", 123123123);
		
		System.out.println(hash.containsKey(con3)); // False
		
		/*
		 *  Aqui iremos procurar por um nome que coincida com o valor de algum
		 *  que ja esteja cadastrado, Mas - muito importante - não bate com o nome
		 *  do congresissta que está lá. Por isto é importante a implementação do
		 *  método equals()
		 */
		
		CongressistaHashCode con4 = new CongressistaHashCode("Livia", 54545432);
		
		System.out.println(hash.containsKey(con4)); // Falso!
		
		/*
		 *  Por fim, iremos pesquisar por um objeto que já existe e exibir suas info.
		 */
		
		String info = hash.get(con1); // retornará o valor atribuído ao objeto no Mapa
		System.out.println(info);
		
		info = hash.get(con2);
		System.out.println(info);
	}

}
