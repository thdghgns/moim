package ac.moim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//		http.authorizeRequests()
//			.antMatchers("/mypageMain").authenticated()
//			.antMatchers("/**").permitAll();
//	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/**");
	}
	
}
