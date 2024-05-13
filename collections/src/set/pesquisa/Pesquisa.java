package set.pesquisa;

public class Pesquisa {

	public static void main(String[] args) {
		AgendaContatos agendaContatos = new AgendaContatos();
		
		agendaContatos.exibirContatos();
		System.out.println();
		
		agendaContatos.adicionarContato("John Mello", 123456789);
		agendaContatos.adicionarContato("John Mello", 987654321); // não adiciona com mesmo nome
		agendaContatos.adicionarContato("Julia Ramos", 569874123);
		agendaContatos.adicionarContato("Julia Ramos", 321478965); // não adiciona com mesmo nome
		agendaContatos.adicionarContato("John", 547896321);
		
		agendaContatos.exibirContatos();
		
		System.out.println("   *** Filtra por nome: 'John' ***");
		
		System.out.println(agendaContatos.pesquisarPorNome("John"));
		
		System.out.println("   *** Atualiza Contato ***");
		
		agendaContatos.atualizarNumeroContato("John", 123654789);
		
		agendaContatos.exibirContatos();
		


	}

}
