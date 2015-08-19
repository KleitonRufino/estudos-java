package br.com.boaspraticas.sobrecarga;

public class Sobrecarga {
	//evitar mandar parametro null
	//boa pratica sobrecarregar metodo
	
	public void teste(String a, String b, String c){}
	public void teste(String a,String b){}
	public void teste(String a){}

	public static void main(String[] args) {
		
		Sobrecarga s = new Sobrecarga();
		
		//ma pratica 
		s.teste(null,"b",null);
		
		//boa pratica
		s.teste("b");
	}
}
