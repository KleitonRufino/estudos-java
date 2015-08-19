package br.com.java.collection.map;

public class CarroMap {
	Integer chassi;

	public CarroMap(Integer chassi) {
		super();
		this.chassi = chassi;
	}

	@Override
	public boolean equals(Object obj) {
		CarroMap c = (CarroMap) obj;
		if (c.chassi == this.chassi)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return chassi;
	}

	@Override
	public String toString() {
		return chassi + " ";
	}

}
