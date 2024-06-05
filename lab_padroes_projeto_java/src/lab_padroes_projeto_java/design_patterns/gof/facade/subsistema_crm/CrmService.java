package lab_padroes_projeto_java.design_patterns.gof.facade.subsistema_crm;

public class CrmService {
	
	private CrmService() {
		super();
	}
	
	public static void gravarCliente(String nome, String cep, String cidade, String estado) {
		System.out.println("Cliente salvo no sistem CRM");
		System.out.println(nome);
		System.out.println(cep);
		System.out.println(cidade);
		System.out.println(estado);
	}
}
