package com.microservice.erp2017;

import java.net.InetSocketAddress;

import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Reza
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApp  {
    
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp .class, args);
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
