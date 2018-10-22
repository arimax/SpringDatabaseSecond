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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages="com.kajishima.repository.primary", sqlSessionFactoryRef = "primarySqlSessionFactory")
@ConfigurationProperties(prefix="spring.datasource.primary")
public class PrimaryConfiguration {

	@Bean
	@Primary
	 @ConfigurationProperties(prefix = "spring.datasource.primary")
	  public DataSourceProperties primaryProperties() {
	    return new DataSourceProperties();
	  }

	 @Bean(name = "primaryDatasource")
	  @Primary
	  public DataSource primaryDatasource(
	      @Qualifier("primaryProperties") DataSourceProperties properties) {
	    return properties.initializeDataSourceBuilder().build();
	  }
	  @Bean(name = "primaryManager")
	  @Primary
	  public PlatformTransactionManager primaryManager(DataSource primaryDatasource) {
	    return new DataSourceTransactionManager(primaryDatasource);
	  }

	  @Bean(name = "primarySqlSessionFactory")
	  @Primary
	  public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDatasource") DataSource primaryDatasource)
	      throws Exception {
	    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	    sqlSessionFactory.setDataSource(primaryDatasource);
	    ResourcePatternResolver resolver =
                ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        // mybatis-configの設定
	    sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        // Mapperのパスを設定
	    sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:**/dao/primary/*.xml"));
	    return (SqlSessionFactory) sqlSessionFactory.getObject();
	  }


}
