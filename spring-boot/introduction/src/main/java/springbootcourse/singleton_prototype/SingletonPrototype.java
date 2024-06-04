package springbootcourse.singleton_prototype;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springbootcourse.beans_vs_components.SpringPrimeirosPassosApplication;

@SpringBootApplication
public class SingletonPrototype {
	public static void main(String[] args) {
		SpringApplication.run(SingletonPrototype.class, args);
	}
	
	@Bean
	public CommandLineRunner run(SistemaMensagem sistema) throws Exception {
		return args -> {
			sistema.enviarConfirmacaoCadastro();
			sistema.enviarMensagemBoasVindas();
			sistema.enviarConfirmacaoCadastro();
		};
	}
}
