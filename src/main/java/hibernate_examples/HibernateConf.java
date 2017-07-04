package hibernate_examples;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.hibernate.dialect.DerbyTenSevenDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class HibernateConf {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(EmbeddedDriver.class.getName());
        dataSource.setUrl("jdbc:derby:bookstore;create=true");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties props = new Properties();
        props.put("hibernate.dialect", DerbyTenSevenDialect.class.getName());
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "true");
        factory.setJpaProperties(props);
        factory.setPackagesToScan("hibernate_examples");
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

}
