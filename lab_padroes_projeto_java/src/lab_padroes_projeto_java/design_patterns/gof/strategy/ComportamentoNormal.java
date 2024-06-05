package lab_padroes_projeto_java.design_patterns.gof.strategy;

public class ComportamentoNormal implements Comportamento {

	@Override
	public void mover() {
			System.out.println("Movendo normalmente.");
	}

	@Override
	public void atacar() {
		System.out.println("Não ataca em modo normal.");
		
	}

	@Override
	public void defender() {
		System.out.println("Defendido com pouco efeito.");
	}

}
