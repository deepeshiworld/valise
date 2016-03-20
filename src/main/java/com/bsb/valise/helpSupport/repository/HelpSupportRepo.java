package com.bsb.valise.helpSupport.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.repository.Query;

import com.bsb.valise.helpSupport.model.HelpSupportDto;
import com.bsb.valise.helpSupport.model.SearchableItem;

public interface HelpSupportRepo extends CrudRepository<HelpSupportDto, Serializable> {

	@Query(SearchableItem.LOB_FIELD + ":?0")
	public HelpSupportDto findQuesByLob(String lob);

	List<HelpSupportDto> findByCatStartingWith(String cat);

	Page<HelpSupportDto> findProductsByCustomImplementation(String value, Pageable page);
}
