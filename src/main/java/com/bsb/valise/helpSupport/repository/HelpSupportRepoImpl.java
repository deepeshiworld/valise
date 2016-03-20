package com.bsb.valise.helpSupport.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.stereotype.Repository;

import com.bsb.valise.helpSupport.model.HelpSupportDto;

@Repository
public class HelpSupportRepoImpl extends SimpleSolrRepository<HelpSupportDto, Serializable> implements HelpSupportRepo {

	@Autowired
	SolrOperations solrOperations;

	@Override
	public HelpSupportDto findQuesByLob(String lob) {
		return solrOperations.queryForObject(new SimpleQuery(new SimpleStringCriteria("lob:" + lob)),
				HelpSupportDto.class);

	}
	
	
	@Override
	public HelpSupportDto findOne(Serializable id) {
		super.setSolrOperations(solrOperations);
		return super.findOne("123");
	}

	@Override
	public List<HelpSupportDto> findByCatStartingWith(String cat) {
		return null;
	}

	@Override
	public Page<HelpSupportDto> findProductsByCustomImplementation(String value, Pageable page) {
		return null;
	}

}
