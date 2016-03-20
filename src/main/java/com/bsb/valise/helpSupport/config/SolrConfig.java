package com.bsb.valise.helpSupport.config;

import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.SolrServerFactory;
import org.springframework.data.solr.server.support.MulticoreSolrServerFactory;

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
	private Environment env;

//	@Bean
//	public HttpSolrServerFactoryBean solrServer() {
//		HttpSolrServerFactoryBean factory = new HttpSolrServerFactoryBean();
//		factory.setUrl(env.getRequiredProperty("solr.server.url"));
//		return factory;
//	}

	@Bean
    public SolrServer solrServer() throws MalformedURLException, IllegalStateException {
//        return new HttpSolrServer("http://localhost:8983/solr/");
		return new HttpSolrServer( env.getRequiredProperty("solr.server.url"));
       
    }

    @Bean
    public SolrServerFactory solrServerFactory() throws MalformedURLException, IllegalStateException {
        return new MulticoreSolrServerFactory(solrServer());
    }

    @Bean
    public SolrTemplate solrTemplate() throws Exception {
        SolrTemplate solrTemplate = new SolrTemplate(solrServerFactory());
        solrTemplate.setSolrCore("helpsupport");
        return solrTemplate;
    }

}
