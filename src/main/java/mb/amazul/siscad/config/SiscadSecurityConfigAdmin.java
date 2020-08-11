package mb.amazul.siscad.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SiscadSecurityConfigAdmin extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	private final String USUARIOS_QUERY = "select cpf as username, password, ativo from usuario where cpf=?";
	private final String PERFIS_QUERY = "select u.cpf as username, r.nome as role from usuario u inner join usuario_perfil ur on (u.id = ur.usuario_id) inner join perfil r on (ur.perfil_id=r.perfil_id) where u.cpf=?";


	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication()
	   .usersByUsernameQuery(USUARIOS_QUERY)
	   .authoritiesByUsernameQuery(PERFIS_QUERY)
	   .dataSource(dataSource)
	   .passwordEncoder(bCryptPasswordEncoder);
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
		 String[] staticResources  =  {
		         "/css/**",
		         "/image/**",
		         "/fonts/**",
		         "/js/**",
		         "/video/**",
		     };
		 
	  http.authorizeRequests()
	   .antMatchers(staticResources).permitAll()
	   .antMatchers("/relatorios").permitAll()
	   .antMatchers("/").permitAll()
	   .antMatchers("/login").permitAll()
	   .antMatchers("/signup").permitAll()
	   //hasRole("ADMIN")
	   .antMatchers("/externo/**").hasAnyAuthority("EXTERNO","ADMIN","ADMIN_RH")
	   .antMatchers("/empregado/**").hasAnyAuthority("ADMIN","ADMIN_RH")
	   .antMatchers("/home/**").hasAnyAuthority("EXTERNO","ADMIN","ADMIN_RH").anyRequest()
	   .authenticated().and().csrf().disable()
	   .formLogin().loginPage("/login").failureUrl("/login?error=true")
	   .defaultSuccessUrl("/home/home")
	   .usernameParameter("cpf")
	   .passwordParameter("password")
	   .and().logout()
	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	   .logoutSuccessUrl("/")
	   .and().rememberMe()
	   .tokenRepository(persistentTokenRepository())
	   .tokenValiditySeconds(60*60)
	   .and().exceptionHandling().accessDeniedPage("/access_denied");
	 }
	 
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * String[] staticResources = { "/css/**", "/images/**", "/fonts/**",
	 * "/scripts/**", };
	 * 
	 * http .authorizeRequests() .antMatchers(staticResources).permitAll()
	 * .anyRequest().authenticated() .and() .formLogin()
	 * .loginPage("/login").permitAll() .and() .logout().permitAll(); }
	 */
	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
	         .withUser("user").password("pass").roles("USER")
	         .and()
	         .withUser("admin").password("pass").roles("ADMIN");
	    }
	 

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);

		return db;
	}
	
}
