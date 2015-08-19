package br.com.java.collection.comparable;

@SuppressWarnings("rawtypes")
public class Carro implements Comparable{
	Integer chassi;
	String modelo;
	public Carro(Integer chassi, String modelo) {
		super();
		this.chassi = chassi;
		this.modelo = modelo;
	}
	@Override
	public boolean equals(Object obj) {
		if((obj instanceof Object) && ((Carro)obj).chassi == this.chassi)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return chassi^13;
	}
	@Override
	public String toString() {
		return "Chassi: " + chassi + " / Modelo: " + modelo + " ";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.chassi.compareTo(((Carro)o).chassi);
	}
	
}
