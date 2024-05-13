package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

	private Set<Convidado> convidadosSet;

	public ConjuntoConvidados() {
		super();
		this.convidadosSet = new HashSet<>();
	}

	public void adicionarConvidado(String nome, int codigoConvite) {
		convidadosSet.add(new Convidado(nome, codigoConvite));
	}

	public void removerConvidadoPorCodigoConvite(int codigoConvite) {
		Convidado convidadoRemover = null;
		for (Convidado convidado : convidadosSet) {
			if (convidado.getCodigoConvite() == codigoConvite) {
				convidadoRemover = convidado;
				break;
			}
		}
		convidadosSet.remove(convidadoRemover);
	}

	public int contarConvidador() {
		return convidadosSet.size();
	}
	
	public void exibirConvidados() {
		System.out.println(convidadosSet);
	}

}
