package br.com.java.cintdt.classesinternas;

public class ExternaInternaDeMetodo {
	private String x = "Classe externa";

	// a classe interna local de metodo so podera ser instancia dentro do
	// metodo a qual foi definida
	// a classe interna so acessa variaveis locais do metodo se for do tipo
	// final
	
	void fazerAlgo() {
		final int y = 10;
		class InternaDeMetodo {
			public void acessarExterna() {
				System.out
						.println("Valor do a tributo private x, de Externa2: "
								+ x);
				System.out.println("Variavel local: " + y);
			}
		}
		InternaDeMetodo it = new InternaDeMetodo();
		it.acessarExterna();
	}

	public static void main(String[] args) {
		ExternaInternaDeMetodo ex = new ExternaInternaDeMetodo();
		ex.fazerAlgo();
	}

}
