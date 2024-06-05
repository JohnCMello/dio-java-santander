package lab_padroes_projeto_java.design_patterns.gof.strategy;

public class StrategyUsage {

	public static void main(String[] args) {

		Comportamento normal = new ComportamentoNormal();
		Comportamento defensivo = new ComportamentoDefensivo();
		Comportamento agressivo = new ComportamentoAgressivo();

		Robo robo = new Robo();

		robo.setComportamento(normal);
		robo.mover();
		robo.atacar();

		robo.setComportamento(defensivo);
		robo.mover();
		robo.defender();

		robo.setComportamento(agressivo);
		robo.mover();
		robo.atacar();

	}
}
