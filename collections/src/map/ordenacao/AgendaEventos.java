package map.ordenacao;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AgendaEventos {

	private Map<LocalDate, Evento> eventos;

	public AgendaEventos() {
		this.eventos = new HashMap<>();
	}

	public void adicionarEvento(LocalDate data, String nome, String atracao) {
		Evento evento = new Evento(nome, atracao);
		eventos.put(data, evento);
	}

	public void exibirAgenda() {
		Map<LocalDate, Evento> eventosOrdenadosPorData = new TreeMap<>(eventos);
		System.out.println(eventosOrdenadosPorData);
	}

	public void obterProximoEvento() {
//		Set<LocalDate> keySet = eventos.keySet();
//		Collection<Evento> values = eventos.values();
//		eventos.get(); precisa da key
		LocalDate dataAtual = LocalDate.now();
		LocalDate proximaData = null;
		Evento proximoEvento = null;

		Map<LocalDate, Evento> eventosOrdenadosPorData = new TreeMap<>(eventos);

		for (Map.Entry<LocalDate, Evento> entry : eventosOrdenadosPorData.entrySet()) {
			if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
				proximoEvento = entry.getValue();
				proximaData = entry.getKey();
				System.out.println("Próximo evento: \n" + proximoEvento + " - " + proximaData);
				break;
			}
		}

	}
}
