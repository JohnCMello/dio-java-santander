package lab_padroes_projeto_java.design_patterns.gof.strategy;

public class ComportamentoAgressivo implements Comportamento {

	@Override
	public void mover() {
		System.out.println("Movendo agressivamente");
	}

	@Override
	public void atacar() {
		System.out.println("Ataque agressivo");

	}

	@Override
	public void defender() {
		System.out.println("Contra ataque");

	}

}
