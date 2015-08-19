package br.com.java8.arquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Arquivos {
	
	public static void main(String[] args) {
		Arquivos a = new Arquivos();
		a.listarTodosOsArquivos();
	}
	public void listarTodosOsArquivos() {
		try {
			Files.list(Paths.get("C:/Users/Kleiton/Downloads")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
