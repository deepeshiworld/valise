package com.bsb.valise.helpSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsb.valise.helpSupport.model.HelpSupportDto;
import com.bsb.valise.helpSupport.repository.HelpSupportRepoImpl;

@Service
public class HelpSupportService {

	@Autowired
	HelpSupportRepoImpl helpSupportRepo;

	public HelpSupportDto getHelpSupportDataByLob(String lob) {
		// HelpSupportDto dto = helpSupportRepo.findOne("123");
		// System.out.println(dto.getAnswer());

		HelpSupportDto dto1 = helpSupportRepo.findOne("123");
		// HelpSupportDto dto1 = helpSupportRepo.findQuesByLob(lob);
		System.out.println(dto1);
		return dto1;

	}
}
