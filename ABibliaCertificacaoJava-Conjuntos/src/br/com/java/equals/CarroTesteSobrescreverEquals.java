package br.com.java.equals;

public class CarroTesteSobrescreverEquals {
	int chassi;
	String marca;
	String modelo;

	public CarroTesteSobrescreverEquals(int chassi, String marca, String modelo) {
		super();
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public boolean equals(Object obj) {
		if((obj instanceof CarroTesteSobrescreverEquals) && ((CarroTesteSobrescreverEquals)obj).chassi == this.chassi)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		CarroTesteSobrescreverEquals c1 = new CarroTesteSobrescreverEquals(123, "GM", "Corsa");
		CarroTesteSobrescreverEquals c2 = new CarroTesteSobrescreverEquals(123, "GM", "Corsa");
		CarroTesteSobrescreverEquals c3 = new CarroTesteSobrescreverEquals(1234, "GM", "Corsa");
		
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c3));
	}
	
}
