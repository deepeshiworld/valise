package com.bsb.valise.helpSupport;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.HttpSolrServerFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
@EnableSolrRepositories("com.bsb.valise.helpSupport.repository")
public class SolrConfig {

	/*
	 * Add an Environment field to the class and annotate that field with
	 * the @Resource annotation. The injected Environment is used to access the
	 * properties which we added to our properties file
	 */
	@Resource
	private Environment environment;

	@Bean
	public SolrServer solrServer() {
		HttpSolrServerFactoryBean factory = new HttpSolrServerFactoryBean();
		factory.setUrl("environment.getProperty('solr.server.url')");
		return factory.getSolrServer();
	}

	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		return new SolrTemplate(solrServer());
	}
}
