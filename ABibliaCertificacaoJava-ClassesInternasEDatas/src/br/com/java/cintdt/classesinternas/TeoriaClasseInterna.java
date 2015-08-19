package br.com.java.cintdt.classesinternas;

public class TeoriaClasseInterna {
	private int x = 7;

	public void criarInstanciaInterna() {
		Interna in = new Interna();
		in.verExterna();
	}

	@Override
	public String toString() {
		return "EXTERNA";
	}

	// classes interna eh uma parte da classes externa
	// classes internas nao possuem declaracoes estaticas de nenhum tipo
	// a classe interna podera ser acessada atraves da instancia da classe
	// externa
	// a classe interna so pode ser marcada como abstract e final
	class Interna {
		public void verExterna() {
			// a classe interna acessa um membro private da classe externa
			// porque tambem faz parte desta
			System.out
					.println("O valor do atributo(externo) private x, externo eh: "
							+ x);
		}

		public void referenciar() {
			System.out.println("Classe interna " + this);
			System.out.println("Classe externa " + TeoriaClasseInterna.this.x);
		}

		@Override
		public String toString() {
			return "INTERNA";
		}

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TeoriaClasseInterna t = new TeoriaClasseInterna();
		t.criarInstanciaInterna();

		// intanciando classe interna de fora
		TeoriaClasseInterna.Interna t2 = new TeoriaClasseInterna().new Interna();
		TeoriaClasseInterna.Interna interna = t.new Interna();
		new TeoriaClasseInterna().new Interna();
		TeoriaClasseInterna.Interna inst = new TeoriaClasseInterna().new Interna();

		inst.referenciar();
	}
}
