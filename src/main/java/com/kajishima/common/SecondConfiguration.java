package com.kajishima.common;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages="com.kajishima.repository.secondary", sqlSessionFactoryRef = "secondarySqlSessionFactory")
@ConfigurationProperties(prefix="spring.datasource.secondary")
public class SecondConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	  public DataSourceProperties secondaryProperties() {
	    return new DataSourceProperties();
	  }

	 @Bean(name = "secondaryDatasource")
	  public DataSource secondaryDatasource(
	      @Qualifier("secondaryProperties") DataSourceProperties properties) {
	    return properties.initializeDataSourceBuilder().build();
	  }
	  @Bean(name = "secondaryManager")
	  public PlatformTransactionManager secondaryManager(DataSource secondaryDatasource) {
	    return new DataSourceTransactionManager(secondaryDatasource);
	  }

	  @Bean(name = "secondarySqlSessionFactory")
	  public SqlSessionFactory sqlSessionFactory(@Qualifier("secondaryDatasource") DataSource secondaryDatasource)
	      throws Exception {
	    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	    sqlSessionFactory.setDataSource(secondaryDatasource);
	    ResourcePatternResolver resolver =
                ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        // mybatis-configの設定
	    sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        // Mapperのパスを設定
	    sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:**/dao/secondary/*.xml"));
	    return (SqlSessionFactory) sqlSessionFactory.getObject();
	  }

}
