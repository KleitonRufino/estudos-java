package br.com.boaspraticas.collection;

import java.util.Collections;
import java.util.List;

public class Colecao {
	List<String> lista;

	public Colecao() {
		super();
	}

	public Colecao(List<String> lista) {
		super();
		this.lista = lista;
	}

	public List<String> getLista() {
		if (lista == null)
			return Collections.emptyList();
		else
			return lista;
	}

	public static void main(String[] args) {
		// preferir devolver lista vazia
		System.out.println(new Colecao().getLista().size());
	}
}
