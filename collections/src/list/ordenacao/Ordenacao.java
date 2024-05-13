package list.ordenacao;

import java.util.Locale;

public class Ordenacao {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		OrdenacaoPessoa ordenacaoPessoaLista = new OrdenacaoPessoa();
		
		ordenacaoPessoaLista.adicionarPessoa("Julia Ramos", 28, 1.54);
		ordenacaoPessoaLista.adicionarPessoa("John Mello", 37, 1.85);
		ordenacaoPessoaLista.adicionarPessoa("Cacau", 5, 0.40);
		
		System.out.println("  *** Lista Original *** ");
		System.out.println(ordenacaoPessoaLista.getPessoasLista());
		
		System.out.println("\n  *** Lista Ordenada por idade *** ");		
		System.out.println(ordenacaoPessoaLista.ordenarPorIdade());
		
		System.out.println("\n  *** Lista Ordenada por altura *** ");	
		System.out.println(ordenacaoPessoaLista.ordenarPorAltura());
	}
	

}
