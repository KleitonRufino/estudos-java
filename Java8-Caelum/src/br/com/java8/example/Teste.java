package br.com.java8.example;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Teste {
	Customer paulo = new Customer("Paulo Silveira");
	Customer rodrigo = new Customer("Rodrigo Turini");
	Customer guilherme = new Customer("Guilherme Silveira");
	Customer adriano = new Customer("Adriano Almeida");

	Product bach = new Product("Bach Completo", Paths.get("/music/bach.mp3"),
			new BigDecimal(100));
	Product poderosas = new Product("Poderosas Anita",
			Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
	Product bandeira = new Product("Bandeira Brasil",
			Paths.get("/images/brasil.jpg"), new BigDecimal(50));
	Product beauty = new Product("Beleza Americana", Paths.get("beauty.mov"),
			new BigDecimal(150));
	Product vingadores = new Product("Os Vingadores",
			Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
	Product amelie = new Product("Amelie Poulain",
			Paths.get("/movies/amelie.mov"), new BigDecimal(100));

	LocalDateTime today = LocalDateTime.now();
	LocalDateTime yesterday = today.minusDays(1);
	LocalDateTime lastMonth = today.minusMonths(1);

	Payment payment1 = new Payment(Arrays.asList(bach, poderosas), today, paulo);
	Payment payment2 = new Payment(Arrays.asList(bach, bandeira, amelie),
			yesterday, rodrigo);
	Payment payment3 = new Payment(Arrays.asList(beauty, vingadores, bach),
			today, adriano);
	Payment payment4 = new Payment(Arrays.asList(bach, poderosas, amelie),
			lastMonth, guilherme);
	Payment payment5 = new Payment(Arrays.asList(beauty, amelie), yesterday,
			paulo);
	List<Payment> payments = Arrays.asList(payment1, payment2, payment3,
			payment4, payment5);

	public void ordenandoPagamentos() {
		payments.stream().sorted(Comparator.comparing(Payment::getDate))
				.forEach(System.out::println);
	}

	public void calcularValorTotalDoPayment1() {
		payment1.getProducts().stream().map(Product::getPrice)
				.reduce(BigDecimal::add).ifPresent(System.out::println);

		BigDecimal total = payment1.getProducts().stream()
				.map(Product::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(total);
	}

	public void somarTodosOsValoresDeTodosOsPagamentos() {
		BigDecimal total = payments
				.stream()
				.map(p -> p.getProducts().stream().map(Product::getPrice)
						.reduce(BigDecimal.ZERO, BigDecimal::add))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println(total);

		BigDecimal totalFlat = payments.stream()
				.flatMap(p -> p.getProducts().stream().map(Product::getPrice))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println(totalFlat);
	}

	@SuppressWarnings("unused")
	public void produtosMaisVendidos() {
		Stream<Product> products1 = payments.stream().map(Payment::getProducts)
				.flatMap(p -> p.stream());

		Stream<Product> products2 = payments.stream().map(Payment::getProducts)
				.flatMap(List::stream);
		
		
	}

}
