package br.com.boaspraticas.classeinterna;

public class MinhaClasseExterna {
	private int x = 7;

	public void criarClasseInternaAPartirDaClasseExterna() {
		// instancia classe interna a partir de um método da externa
		MinhaClasseInterna interna = new MinhaClasseInterna();
		interna.mostraValorVariavelClasseExterna();
	}

	// definindo classe interna regular
	class MinhaClasseInterna {
		public void mostraValorVariavelClasseExterna() {
			System.out.println("Valor de x na classe externa é: " + x);
		}

		public void exibeFormasDeReferenciarClasses() {
			System.out.println("Referência para a classe interna: " + this);
			System.out.println("Referência para a classe externa: "
					+ MinhaClasseExterna.this);
		}
	}

	void testaClasseInternaDeMetodo() {
		final String z = "variavel local de metodo";

		// definindo classe interna de metodo
		class MinhaClasseInternaDeMetodo {
			public void mostraDadosExternos() {
				System.out.println("Valor de x da classe externa é: " + x);
				// se z não for final nao compila
				System.out.println("Valor de z do método é: " + z);
			}
		}

		MinhaClasseInternaDeMetodo internaMetodo = new MinhaClasseInternaDeMetodo();
		internaMetodo.mostraDadosExternos();
	}

	public static void main(String[] args) {
		MinhaClasseExterna externa = new MinhaClasseExterna();
		// instanciando classe interna a partir de um método da classe externa
		externa.criarClasseInternaAPartirDaClasseExterna();

		// instanciando classe interna a partir de uma instância da classe
		// externa
		MinhaClasseInterna interna = externa.new MinhaClasseInterna();
		interna.mostraValorVariavelClasseExterna();

		interna.exibeFormasDeReferenciarClasses();
		
		//intanciando a classe interna de Metodo
		externa.testaClasseInternaDeMetodo();
		
		
	}
}
