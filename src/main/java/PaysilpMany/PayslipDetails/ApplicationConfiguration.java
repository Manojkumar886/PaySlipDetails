package PaysilpMany.PayslipDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationConfiguration
{
	AuthenticationManager manager;
	
	@Autowired
	EmployeeDetailsService serv;
	
	@Bean
	public WebSecurityCustomizer cutstomize()
	{
		return(web)->web.ignoring().antMatchers("/maddy/newone");
	}

	@Bean
	public PasswordEncoder encrpting()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain secure(HttpSecurity hp) throws Exception
	{
	//	hp.authorizeRequests().anyRequest().permitAll();//alll servers is allowed
		//hp.authorizeRequests().anyRequest().authenticated();//all servers is secure
		hp.authorizeRequests().antMatchers("/maddy/**").authenticated();
		hp.httpBasic();
		hp.formLogin();
		hp.cors();
		AuthenticationManagerBuilder builder=hp.getSharedObject(AuthenticationManagerBuilder.class);
		builder.userDetailsService(serv).passwordEncoder(encrpting());
		manager=builder.build();
		hp.authenticationManager(manager);
		return hp.build();
		
	}
}
