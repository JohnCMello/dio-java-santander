package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

	private Set<Contato> contatos;

	public AgendaContatos() {
		this.contatos = new HashSet<>();
	}

	public void adicionarContato(String nome, int numero) {
		contatos.add(new Contato(nome, numero));
	}

	public void exibirContatos() {
		System.out.println(contatos);
	}

	public Set<Contato> pesquisarPorNome(String nome) {
		Set<Contato> contatosPorNome = new HashSet<>();

		for (Contato contato : contatos) {
			if (contato.getNome().startsWith(nome)) {
				contatosPorNome.add(contato);
			}
		}
		return contatosPorNome;
	}

	public Contato atualizarNumeroContato(String nome, int novoNumero) {
		Contato contatoAtualizado = null;

		for (Contato contato : contatos) {
			if (contato.getNome().equalsIgnoreCase(nome)) {
				contato.setNumero(novoNumero);
				contatoAtualizado = contato;
				break;
			}
		}
		return contatoAtualizado;
	}
}
