package br.com.java.equals;

public class CarroTesteEqualsHashCode {
	int chassi;
	String marca;
	String modelo;
	
	public CarroTesteEqualsHashCode(int chassi, String marca, String modelo) {
		super();
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
	}

	@Override
	public boolean equals(Object obj) {
		if((obj instanceof CarroTesteEqualsHashCode) && ((CarroTesteEqualsHashCode) obj).chassi == this.chassi)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return chassi^marca.length()^13;
	}

	public static void main(String[] args) {
		CarroTesteEqualsHashCode c1 = new CarroTesteEqualsHashCode(123, "GM", "Corsa");
		CarroTesteEqualsHashCode c2 = new CarroTesteEqualsHashCode(123, "GM", "Corsa");
		CarroTesteEqualsHashCode c3 = new CarroTesteEqualsHashCode(1234, "GM", "Corsa");
		
		System.out.println("hashcode de c1: " + c1.hashCode());
		System.out.println("hashcode c2: " + c2.hashCode());
		System.out.println("hashcode de c3: " + c3.hashCode());
		
		System.out.println(c1.equals(c2));
		System.out.println(c2.equals(c3));
	}

}
