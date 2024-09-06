package ftn.devops.audit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = { "ftn.devops.audit.Repository" })
@EnableConfigurationProperties(CassandraProperties.class)
public class CassandraConfig {

    @Autowired
    private CassandraProperties cassandraProperties;

    @Bean
    public CqlSessionFactoryBean session() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(cassandraProperties.getUrl());
        session.setPort(cassandraProperties.getPort());
        session.setKeyspaceName(cassandraProperties.getKeyspaceName());
        session.setLocalDatacenter(cassandraProperties.getDatacenter());
        return session;
    }

    @Bean
    public CassandraTemplate cassandraTemplate(CqlSessionFactoryBean session) {
        return new CassandraTemplate(session.getObject());
    }
}