package com.bsb.valise.helpSupport;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.repository.Query;

import com.bsb.valise.helpSupport.dto.HelpSupportDto;

public interface HeplSupportRepo extends CrudRepository<HelpSupportDto, Serializable> {

	@Query("lob:?0")
	public HelpSupportDto findQuesByLob(String lob);
}
