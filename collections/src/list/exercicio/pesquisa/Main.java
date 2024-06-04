package list.exercicio.pesquisa;

public class Main {

	public static void main(String[] args) {
		
		SomaNumeros somaNumeros = new SomaNumeros();
		
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(3);
        somaNumeros.adicionarNumero(8);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(20);

        System.out.println("Números na lista: " + somaNumeros.exibirNumeros());
        System.out.println("Soma dos números: " + somaNumeros.calcularSoma());
        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());

	}

}
