package list.operacoesBasicas;

public class Tarefa {
	
	private String descricao;

	public Tarefa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescription() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao; 
	}
	
	

}
