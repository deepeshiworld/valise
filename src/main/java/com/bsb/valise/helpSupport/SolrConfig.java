package com.bsb.valise.helpSupport;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.SolrServerFactory;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;
import org.xml.sax.SAXException;

@Configuration
@PropertySource("classpath:application.properties")
@EnableSolrRepositories("com.bsb.valise.helpSupport")
public class SolrConfig {

	@Bean
	public SolrServer solrServer() {
		try {
			SolrServerFactory factory = new EmbeddedSolrServerFactory("");
			return factory.getSolrServer();
		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}
		return null;
	}

	public SolrOperations solrTemplate() {
		return new SolrTemplate(solrServer());
	}
}
