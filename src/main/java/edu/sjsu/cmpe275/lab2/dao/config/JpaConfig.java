package edu.sjsu.cmpe275.lab2.dao.config;

import edu.sjsu.cmpe275.lab2.dao.JpaProfileDao;
import edu.sjsu.cmpe275.lab2.dao.ProfileDao;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by yutao on 3/26/16.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("edu.sjsu.cmpe275.lab2.dao")
public class JpaConfig {

    @Bean
    public ProfileDao profileDao() {
        return new JpaProfileDao();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("edu.sjsu.cmpe275.lab2.domain");
        emf.setJpaVendorAdapter(jpaVendorAdapter());
        return emf;
    }

    private JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(MySQL5Dialect.class.getName());
        return jpaVendorAdapter;
    }

    @Bean
    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_hibernate4_01?createDatabaseIfNotExist=true");
        dataSource.setUsername("tutorialuser");
        dataSource.setPassword("tutorialmy5ql");
        dataSource.setInitialSize(2);
        dataSource.setMaxTotal(5);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
