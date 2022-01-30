package com.payMyBuddy.payMyBuddy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.payMyBuddy.payMyBuddy.services.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {



	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("springuser").password(passwordEncoder().encode("spring123"))
//			.roles("CLIENT")
//			.and()
//			.withUser("springadmin").password(passwordEncoder().encode("admin123"))
//			.roles("CLIENT", "BANK");
//	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//		.authorizeRequests().antMatchers("/signup/**","/openapi/**"
//				,"/signin/**").permitAll()
//		.antMatchers(HttpMethod.POST,"/signin/**", "/signup/**").permitAll()
//		.anyRequest().authenticated();
//
//		
//
//	http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		http.cors().and().csrf().disable()
	      .authorizeRequests().antMatchers("/signup/**", "/login/oauth2/code/google/**", "/signin/**" ,"/signinByGoogle/**")
				.permitAll().antMatchers(HttpMethod.POST, "/signin/**", "/signup/**")
				.permitAll().antMatchers(HttpMethod.GET, "/signin/**", "/login/oauth2/code/google/**")
				.permitAll().anyRequest().authenticated()
		.and()
        .oauth2Login()
            //.loginPage("http://localhost:4200/home")
            .userInfoEndpoint()
                .userService(oauthUserService);
}
 
@Autowired
private CustomOAuth2UserService oauthUserService;
	
	
	
	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}