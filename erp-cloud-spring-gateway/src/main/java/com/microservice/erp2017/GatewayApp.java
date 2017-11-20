package com.microservice.erp2017;

import java.net.InetSocketAddress;

import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.google.common.collect.ImmutableList;

/**
 *
 * @author Reza
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients
public class GatewayApp {
    
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	    
	config.setAllowCredentials(true);
	config.setAllowedOrigins(ImmutableList.of("*"));
	config.setAllowedHeaders(ImmutableList.of("Authorization","x-auth-token", "remember-me", "content-type"));
	config.setAllowedMethods(ImmutableList.of("OPTIONS","POST","GET","PUT","DELETE","PATCH"));
	    
	source.registerCorsConfiguration("/**", config);
	FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	bean.setOrder(0);
	return bean;
    }
    
    @Value("${com.tomcat.apr:false}")
    private boolean enableApr;

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	if (enableApr) {
            tomcat.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
            tomcat.addContextLifecycleListeners(new AprLifecycleListener());
            tomcat.setAddress(new InetSocketAddress(0).getAddress());
	}
	return tomcat;
    }
}
