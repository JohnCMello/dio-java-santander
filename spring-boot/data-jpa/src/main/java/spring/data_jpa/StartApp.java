package spring.data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spring.data_jpa.model.AppUser;
import spring.data_jpa.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		AppUser user = new AppUser();
		user.setName("John");
		user.setUsername("JohnCM");
		user.setPassword("john123");
		
		userRepository.save(user);
		
		for(AppUser u:userRepository.findAll()) {
			System.out.println(u);
		}
		
	}

}
