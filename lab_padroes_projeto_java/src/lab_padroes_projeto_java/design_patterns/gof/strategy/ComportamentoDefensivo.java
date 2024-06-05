package lab_padroes_projeto_java.design_patterns.gof.strategy;

public class ComportamentoDefensivo implements Comportamento {

	@Override
	public void mover() {
		System.out.println("Movendo defensivamente");
	}

	@Override
	public void atacar() {
		System.out.println("Ataque de contenção");

	}

	@Override
	public void defender() {
		System.out.println("Totalmente defendido");

	}

}
