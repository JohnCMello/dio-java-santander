package lab_padroes_projeto_java.design_patterns.gof.facade.subsistema_cep;

import lab_padroes_projeto_java.design_patterns.gof.singleton.SingletonEager;

public class CepApi {
	
	private static CepApi instancia = new CepApi();

	private CepApi() {
		super();
	}

	public static CepApi getInstancia() {
		return instancia;
	}
	
	public String recuperarCidade(String cep) {
		return "Cidade a partir do cep";
	}
	
	public String recuperarEstado(String cep) {
		return "Estado a partir do cep";
	}


}
