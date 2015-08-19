package br.com.java.collection.comparable;

public class Cliente {
	String nome;
	int idade;
	public Cliente(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	@Override
	public boolean equals(Object obj) {
		Cliente c = (Cliente) obj;
		if(c.idade == this.idade)
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		return idade^nome.length();
	}
	@Override
	public String toString() {
		return nome + " " + idade;
	}
	
	
}
