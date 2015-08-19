package br.com.java8.interfacefuncional;


//interface funcional = contem apenas um metodo abstrato

//essa anotacao nao deixa ter mais de um metodo, ao compilar o codigo dar erro se tiver mais de um metodo
@FunctionalInterface
public interface Validador<T> {
	public boolean validar(T t);

}
