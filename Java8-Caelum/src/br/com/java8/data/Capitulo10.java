package br.com.java8.data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class Capitulo10 {

	public static void main(String[] args) {
		Capitulo10 cap = new Capitulo10();
		// cap.imprimirData();
		// cap.criandoData();
		// cap.comparacoes();
		// cap.obterData();
		// cap.datasInvalidas();
		cap.diferencaEntreDatas();
	}

	@SuppressWarnings("unused")
	public void add() {
		// Modo antigo
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);

		// Novo modo
		// Add 1 mes a dt atual
		LocalDate mesQueVem = LocalDate.now().plusMonths(1);

		// add 1 dia a dt atual
		LocalDate diaQueVem = LocalDate.now().plusDays(1);

		// add 1 ano a dt atual
		LocalDate anoQueVem = LocalDate.now().plusYears(1);

		// subtraindo 1 ano da dt atual
		LocalDate anoPassado = LocalDate.now().minusYears(1);
	}

	public void imprimirData() {
		// imprimindo tudo
		LocalDateTime agora1 = LocalDateTime.now();
		System.out.println("LocalDateTime: " + agora1);

		// imprimindo so horas
		LocalDate agora2 = LocalDate.now();
		System.out.println("LocalDate: " + agora2);

		// imprimindo so horas
		LocalTime agora3 = LocalTime.now();
		System.out.println("LocalTime: " + agora3);
	}

	@SuppressWarnings("unused")
	public void criandoData() {
		// criando data ao meio dia
		LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);

		// combinando
		LocalTime agora = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEHora = hoje.atTime(agora);

		// criando novas instancias
		LocalDate date = LocalDate.of(2014, 12, 25);
		LocalDateTime dateTime = LocalDateTime.of(2014, 12, 25, 10, 30);

		// modificando ano da data atual
		LocalDate dataDoPassado = LocalDate.now().withYear(1993);

	}

	public void comparacoes() {
		LocalDate hoje = LocalDate.now();
		LocalDate amanha = LocalDate.now().plusDays(1);

		System.out.println(hoje.isBefore(amanha));
		System.out.println(hoje.isAfter(amanha));
		System.out.println(hoje.isEqual(amanha));

		ZonedDateTime tokyo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0,
				ZoneId.of("Asia/Tokyo"));
		ZonedDateTime saoPaulo = ZonedDateTime.of(2011, 5, 2, 10, 30, 0, 0,
				ZoneId.of("America/Sao_Paulo"));

		System.out.println(tokyo.isEqual(saoPaulo));
		tokyo = tokyo.plusHours(12);
		System.out.println(tokyo.isEqual(saoPaulo));
	}

	public void obterData() {
		// pegando dia do mes atual
		System.out.println("hoje é dia " + MonthDay.now().getDayOfMonth());

		LocalDate date = LocalDate.now();
		YearMonth ym = YearMonth.from(date);
		System.out.println(ym.getMonth() + " " + ym.getYear());
	}

	public void utilizandoEnum() {

		System.out.println(LocalDate.of(2014, 12, 25));
		System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));

		System.out.println(Month.DECEMBER.firstMonthOfQuarter());
		System.out.println(Month.DECEMBER.plus(1));
		System.out.println(Month.DECEMBER.minus(1));
	}

	public void imprimirDataFormatada() {
		Locale pt = new Locale("pt");
		System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, pt));
		System.out.println(Month.DECEMBER.getDisplayName(TextStyle.SHORT, pt));
	}

	public void formatarData() {
		LocalDateTime agora1 = LocalDateTime.now();
		String resultado1 = agora1
				.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(resultado1);

		LocalDate agora2 = LocalDate.now();
		String resultado2 = agora2.format(DateTimeFormatter
				.ofPattern("dd/MM/yyyy"));
		System.out.println(resultado2);

		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter
				.ofPattern("dd/MM/yyyy");
		String resultado3 = agora.format(formatador);
		LocalDate agoraEmData = LocalDate.parse(resultado3, formatador);
		System.out.println(agoraEmData);
	}

	public void datasInvalidas() {
		// Gera exception
		LocalDate data = LocalDate.of(2014, Month.FEBRUARY, 30);
		System.out.println(data);

		// Gera exception
		LocalDateTime horaInvalida = LocalDate.now().atTime(25, 0);
		System.out.println(horaInvalida);
	}

	public void diferencaEntreDatas() {
		LocalDate agora1 = LocalDate.now();
		LocalDate outraData1 = LocalDate.of(1989, Month.JANUARY, 25);
		long dias = ChronoUnit.DAYS.between(outraData1, agora1);
		long meses = ChronoUnit.MONTHS.between(outraData1, agora1);
		long anos = ChronoUnit.YEARS.between(outraData1, agora1);
		System.out.printf("%s dias, %s meses e %s anos", dias, meses, anos);

		System.out.println();

		LocalDate agora2 = LocalDate.now();
		LocalDate outraData2 = LocalDate.of(1989, Month.JANUARY, 25);
		Period periodo = Period.between(outraData2, agora2);
		System.out.printf("%s dias, %s meses e %s anos", periodo.getDays(),
				periodo.getMonths(), periodo.getYears());

		System.out.println();

		LocalDateTime agora3 = LocalDateTime.now();
		LocalDateTime daquiAUmaHora3 = LocalDateTime.now().plusHours(1);
		Duration duration = Duration.between(agora3, daquiAUmaHora3);
		if (duration.isNegative()) {
			duration = duration.negated();
		}

		System.out
				.printf("%s horas, %s minutos e %s segundos",
						duration.toHours(), duration.toMinutes(),
						duration.getSeconds());

	}
}
