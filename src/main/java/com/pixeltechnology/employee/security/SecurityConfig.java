package com.pixeltechnology.employee.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());  // form login
        http.httpBasic(Customizer.withDefaults());  // for postman 

        return http.build();
    }
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails
	 * userDetails1 =
	 * User.withUsername("pdsingh").password("singh").roles("USER").build();
	 * UserDetails userDetails2 =
	 * User.withUsername("abcd").password("1234").roles("USER").build(); return new
	 * InMemoryUserDetailsManager(userDetails1,userDetails2); }
	 */
	@Autowired
	private UserDetailsService userDetailsServices;
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoProvider.setUserDetailsService(userDetailsServices);
		return daoProvider;
	}
}
