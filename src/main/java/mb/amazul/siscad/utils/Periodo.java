package mb.amazul.siscad.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Periodo {

	JANFEV(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),1,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),2,20)),"Jan/Fev"),
	
	FEVMAR(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),2,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),3,20)),"Fev/Mar"),
	
	MARABR(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),3,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),4,20)),"Mar/Abr"),
	
	ABRMAI(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),4,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),5,20)),"Abr/Mai"),
	
	MAIJUN(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),5,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),6,20)),"Mai/Jun"),
	
	JUNJUL(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),6,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),7,20)),"Jun/Jul"),
	
	JULAGO(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),7,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),8,20)),"Jul/Ago"),
	
	AGOSET(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),8,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),9,20)),"Ago/Set"),
	
	SETOUT(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),9,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),10,20)),"Set/Out"),
	
	OUTNOV(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),10,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),11,20)),"Out/Nov"),
	
	NOVDEZ(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),11,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),12,20)),"Nov/Dez"),
	
	DEZJAN(DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear(),12,21)),
			DateTimeFormatter.ofPattern("dd/MM/YYYY").format(LocalDate.of(LocalDate.now().getYear()+1,1,20)),"Dez/Jan");
	
	
	private final String dataini;
	private final String datafim;
	private final String nome;
	
	private Periodo(String dataini, String datafim, String nome) {
		this.dataini = dataini;
		this.datafim = datafim;
		this.nome = nome;
	}

	public String getDataini() {
		return dataini;
	}
	public String getDatafim() {
		return datafim;
	}
	public String getNome() {
		return nome;
	}
	
	
	
	
	
	
}
