package com.bsb.valise.helpSupport.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.bsb.valise.helpSupport.model.HelpSupportDto;
import com.bsb.valise.helpSupport.repository.HelpSupportRepo;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("resources/valise-servlet.xml").getPath());

		HelpSupportRepo supportDto = context.getBean(HelpSupportRepo.class);

		HelpSupportDto helpSupport = new HelpSupportDto();
	}
}
