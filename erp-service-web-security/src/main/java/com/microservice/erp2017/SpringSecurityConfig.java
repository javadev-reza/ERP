package com.microservice.erp2017;

import com.microservice.erp2017.service.impl.UserService;
import com.microservice.erp2017.security.AuthServiceToken;
import com.microservice.erp2017.constant.WebConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.google.common.collect.ImmutableList;
import com.microservice.erp2017.security.EntryPointRest;
import com.microservice.erp2017.security.FilterStateless;
import static com.microservice.erp2017.constant.WebConstant.Header.REFFERAL;
import static com.microservice.erp2017.constant.WebConstant.Header.AUTH_TOKEN;
import static com.microservice.erp2017.constant.WebConstant.Header.AUTHORIZATION;
import static com.microservice.erp2017.constant.WebConstant.Header.CONTENT_TYPE;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private EntryPointRest entryPointRestToken;

    private final UserService userService;

    private final AuthServiceToken authServiceToken; 
    
    public SpringSecurityConfig(){
        super(true);
        this.userService = new UserService();
	this.authServiceToken = new AuthServiceToken(WebConstant.SecretCode.TOKEN_KEY, userService);
    }
    
    String[] SpringCloudUrl = {
        "/env",
        "/logging", 
        "/info", 
        "/health", 
        "/error", 
        "/metrics", 
        "/jmx", 
        "/threads", 
        "/trace",
        "/circuitBreaker.stream", 
        "/circuitBreaker**/**", 
        "/hystrix.stream", 
        "/hystrix**/**"
    };
	
    String[] StaticUrl = { 
        "/favicon.ico", 
        "**/*.html", 
        "**/*.css", 
        "**/*.js", 
        "/auth-public/**",
        "/auth-private/sign-in",
        "/auth-super-user/**",
        "/api-docs.json",
        "/v2/api-docs/**", 
        "/webjars/**", 
        "/swagger-ui.html", 
        "/swagger-resources/**", 
        "/details/**", 
        "/api/**", 
        "/file/**",
        "/image/**",
        "**/*.pdf"
    };
        
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
	.and()
	.csrf().disable()
	.anonymous()
	.and()
	.servletApi()
	.and()
	.authorizeRequests()
        .antMatchers(SpringCloudUrl).permitAll()
	.antMatchers(StaticUrl).permitAll()
	.anyRequest()
        .authenticated()
	.and()
	.addFilterBefore(new FilterStateless(authServiceToken), UsernamePasswordAuthenticationFilter.class)
	.exceptionHandling()
        .authenticationEntryPoint(entryPointRestToken);
    }
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
		
	config.setAllowCredentials(true);
	config.setAllowedOrigins(ImmutableList.of("*"));
	config.setAllowedHeaders(ImmutableList.of(AUTH_TOKEN, REFFERAL, CONTENT_TYPE));
	config.setAllowedMethods(ImmutableList.of("OPTIONS","POST","GET","PUT","DELETE","PATCH"));
	source.registerCorsConfiguration("/**", config);
		
	return source;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserService userDetailsService() {
        return userService;
    }

    @Bean
    public AuthServiceToken authServiceToken() {
        return authServiceToken;
    }
}
