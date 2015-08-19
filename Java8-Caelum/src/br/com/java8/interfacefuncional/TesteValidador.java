package br.com.java8.interfacefuncional;

public class TesteValidador {

	public static void main(String[] args) {
		// nao se pode alterar variaveis locais dentro do lambda

		Validador<String> validadorCEP = valor -> {
			return valor.matches(("[0-9]{5}-[0-9]{3}"));
		};
		System.out.println(validadorCEP.validar("04101-300"));
	}

	@SuppressWarnings("unused")
	public void interfaceFuncionalRunnable() {
		Runnable r = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println(i);
			}
		};

		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				System.out.println(i);
			}
		}).start();
	}

	@SuppressWarnings("unused")
	public void validarCEP() {
		Validador<String> validador1 = (String valor) -> {
			return valor.matches("[0-9]{5}-[0-9]{3}");
		};

		Validador<String> validador2 = (v) -> {
			return v.matches("[0-9]{5}-[0-9]{3}");
		};

		Validador<String> validador3 = (v) -> {
			return v.matches("[0-9]{5}-[0-9]{3}");
		};
	}

	
}
