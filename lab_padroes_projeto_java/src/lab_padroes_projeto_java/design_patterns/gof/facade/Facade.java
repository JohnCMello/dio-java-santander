package lab_padroes_projeto_java.design_patterns.gof.facade;

import lab_padroes_projeto_java.design_patterns.gof.facade.subsistema_cep.CepApi;
import lab_padroes_projeto_java.design_patterns.gof.facade.subsistema_crm.CrmService;

public class Facade {
	
	public void migrarCliente(String nome, String cep) {
		
		String cidade = CepApi.getInstancia().recuperarCidade(cep);
		String estado = CepApi.getInstancia().recuperarEstado(cep);
		
		CrmService.gravarCliente(nome, cep, cidade, estado);
	}
}
