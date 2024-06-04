package springbootcourse.singleton_prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem {
	@Autowired
	private Remetente noreply;
	@Autowired
	private Remetente techTeam;
	private int order = 1;
	
	public void enviarConfirmacaoCadastro() {
		System.out.println(noreply);
		System.out.println("Seu cadastro foi aprovado");
		System.out.println("execução " + order);
		order++;
	}

	public void enviarMensagemBoasVindas() {
		techTeam.setEmail("tech@dio.com.br");
		System.out.println(techTeam);
		System.out.println("Bem-vindo à Tech Elite");
		System.out.println("execução " + order);
		order++;
	}
}