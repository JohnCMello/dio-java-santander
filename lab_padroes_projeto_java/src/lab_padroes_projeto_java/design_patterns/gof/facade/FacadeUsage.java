package lab_padroes_projeto_java.design_patterns.gof.facade;

public class FacadeUsage {
	public static void main(String[] args) {
		Facade facade = new Facade();
		
		facade.migrarCliente("John Mello", "88111222");
	}
}
