package list.exercicio.ordenacao;

public class Main {

	public static void main(String[] args) {

		OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
		
		ordenacaoNumeros.adicionarNumero(5);
		ordenacaoNumeros.adicionarNumero(10);
		ordenacaoNumeros.adicionarNumero(3);
		ordenacaoNumeros.adicionarNumero(8);

		System.out.println("Lista original: " + ordenacaoNumeros.getNumeros());
	
		System.out.println("Lista ordenada em ordem ascendente: " + ordenacaoNumeros.ordenarAscendente());
		
		System.out.println("Lista ordenada em ordem descendente: " + ordenacaoNumeros.ordenarDescendente());
	}

}
