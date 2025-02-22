package com.rushi.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	 @Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		exposeIds(config);
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
	}
	 
	 private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>>  entities= entityManager.getMetamodel().getEntities();
		List<Class> entityClass=new ArrayList<>();
		
		for(EntityType tempEntity : entities) {
			entityClass.add(tempEntity.getJavaType());
		}
		Class[] domainTypes = entityClass.toArray(new Class[0]);
		
		config.exposeIdsFor(domainTypes);
	 }
}
