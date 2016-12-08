package ac.moim.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by SONG_HOHOON on 2016-11-17.
 */
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = "ac.moim")
@Configuration
public class DatabaseConfiguration {

	@Autowired
	Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		String url = env.getProperty("spring.datasource.url");
		String username = env.getProperty("spring.datasource.username");
		String password = env.getProperty("spring.datasource.password");
		String driverClassName = env.getProperty("spring.datasource.driverClassName");

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setDriverClassName(driverClassName);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(value = "dataSource")DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(env.getProperty("spring.jpa.package.scan"));

		String showSql = env.getProperty("spring.jpa.show-sql");
		String databasePlatform = env.getProperty("spring.jpa.database-platform");
		String ddlAuto = env.getProperty("spring.jpa.hibernate.ddl-auto");

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.show_sql", Boolean.valueOf(showSql));
		jpaProperties.put("hibernate.dialect", databasePlatform);
		jpaProperties.put("hibernate.hbm2ddl.auto", ddlAuto);

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier(value ="entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}
}
