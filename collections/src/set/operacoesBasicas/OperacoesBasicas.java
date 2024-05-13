package set.OperacoesBasicas;

public class OperacoesBasicas {

	public static void main(String[] args) {
		ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

		System.out.println("Existem " + conjuntoConvidados.contarConvidador()
				+ (conjuntoConvidados.contarConvidador() == 1 ? " conjunto " : " conjuntos ")
				+ "dentro do Set de Convidados.\n");

		System.out.println("  *** Adicionando convidados ao Set - 5 total - 1 com codigo repetido ***\n");

		conjuntoConvidados.adicionarConvidado("John Mello", 1234);
		conjuntoConvidados.adicionarConvidado("Julia Ramos", 1235);
		conjuntoConvidados.adicionarConvidado("Cacau", 1236);
		conjuntoConvidados.adicionarConvidado("Seu Madruga", 1237);
		conjuntoConvidados.adicionarConvidado("Dona Florinda", 1235);

		conjuntoConvidados.exibirConvidados();
		
		System.out.println();

		System.out.println("Existem " + conjuntoConvidados.contarConvidador()
				+ (conjuntoConvidados.contarConvidador() == 1 ? " conjunto " : " conjuntos ")
				+ "dentro do Set de Convidados.\n");
		
		
		System.out.println("  *** Removendo convidado do Set - codigo 1237 ***\n");
		
		conjuntoConvidados.removerConvidadoPorCodigoConvite(1237);

		System.out.println("Existem " + conjuntoConvidados.contarConvidador()
				+ (conjuntoConvidados.contarConvidador() == 1 ? " conjunto " : " conjuntos ")
				+ "dentro do Set de Convidados.\n");

		conjuntoConvidados.exibirConvidados();

	}

}
