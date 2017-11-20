package com.microservice.erp2017;

import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
/**
 *
 * @author Reza
 */
@Configuration
@EnableTransactionManagement
public class DatasourceConfig {
    
    final Logger logger = LoggerFactory.getLogger(DatasourceConfig.class);

    static DataSource ds;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
	if (ds == null) {
            ds = DataSourceBuilder.create().build();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    ((HikariDataSource) ds).close();
                }
            });
	}
	return ds;
    }

    @Bean
    FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
	return new FlywayMigrationInitializer(flyway, (f) -> {
	});
    }

    void logDS() {
        if (ds instanceof HikariDataSource) {
            HikariDataSource hs = ((HikariDataSource) ds);
			
            logger.warn("spring.datasource.poolName = " + hs.getPoolName());
            logger.warn("spring.datasource.isAutoCommit = " + hs.isAutoCommit());
            logger.warn("spring.datasource.connectionTestQuery = " + hs.getConnectionTestQuery());
            logger.warn("spring.datasource.maximumPoolSize = " + hs.getMaximumPoolSize());
            logger.warn("spring.datasource.minimumIdle = " + hs.getMinimumIdle());
            logger.warn("spring.datasource.maxLifetime = " + hs.getMaxLifetime());
            logger.warn("spring.datasource.connectionTimeout = " + hs.getConnectionTimeout());
            logger.warn("spring.datasource.idleTimeout = " + hs.getIdleTimeout());
            logger.warn("spring.datasource.validationTimeout = " + hs.getValidationTimeout());
            logger.warn("spring.datasource.leakDetectionThreshold = " + hs.getLeakDetectionThreshold());
	} else {
            logger.warn("Gawatt bukan hikari euy..");
	}
    }

    @Bean
    @DependsOn("entityManagerFactory")
    FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
	logDS();
	return new FlywayMigrationInitializer(flyway, null);
    }
    
    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	return hemf.getSessionFactory();
    }
    
}
