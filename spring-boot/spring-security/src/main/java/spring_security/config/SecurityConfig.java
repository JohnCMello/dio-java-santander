package spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers(HttpMethod.GET, "/").permitAll()
				.requestMatchers(HttpMethod.GET, "/login").permitAll().requestMatchers(HttpMethod.GET, "/managers")
				.hasAnyRole("MANAGERS").requestMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS")
				.anyRequest().authenticated().and().formLogin();

		return http.build();
	}

	@Bean
	public UserDetailsService user() {
		UserDetails user = User.builder().username("john").password("{noop}john123").roles("USERS").build();
		UserDetails admin = User.builder().username("admin").password("{noop}admin123").roles("MANAGERS").build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}
