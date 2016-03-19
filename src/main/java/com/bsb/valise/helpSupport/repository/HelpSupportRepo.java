package com.bsb.valise.helpSupport.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.repository.Query;
import org.springframework.stereotype.Repository;

import com.bsb.valise.helpSupport.model.HelpSupportDto;

@Repository
public interface HelpSupportRepo extends CrudRepository<HelpSupportDto, Serializable> {

	@Query("lob:?0")
	public HelpSupportDto findQuesByLob(String lob);
	
	Page<HelpSupportDto> findProductsByCustomImplementation(String value, Pageable page);
}
