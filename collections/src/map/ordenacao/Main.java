package map.ordenacao;

import java.time.LocalDate;
import java.time.Month;

public class Main {

	public static void main(String[] args) {
		AgendaEventos agenda = new AgendaEventos()
;
		agenda.adicionarEvento(LocalDate.of(2024, Month.JULY, 15), "Evento 1", "Lazy Train");
		agenda.adicionarEvento(LocalDate.of(2024, 7, 10), "Evento 2", "Outra banda");
		agenda.adicionarEvento(LocalDate.of(2024, Month.JANUARY, 3), "Evento 3", "Mais outra banda");
		agenda.adicionarEvento(LocalDate.of(2024, Month.MAY, 13), "Evento 4", "Black Sabbath");
		agenda.adicionarEvento(LocalDate.of(2024, Month.MAY, 15), "Evento 5", "Raul Seixas");
	
		
		agenda.exibirAgenda();
		agenda.obterProximoEvento();
		
	}

}
