package map.operacoesBasicas;

public class OperacoesBasicas {

	public static void main(String[] args) {
		
		AgendaContatos agenda = new AgendaContatos();
		
		agenda.adicionarContato("John", 123456789);
		agenda.adicionarContato("Julia", 987654321);
		agenda.adicionarContato("Cacau", 563214789);
		
		agenda.exibirContatos();
		
		agenda.removerContato("John");
		
		agenda.exibirContatos();
		
		System.out.println(agenda.pesquisarPorNome("Cacau"));
		
		
	}

}
