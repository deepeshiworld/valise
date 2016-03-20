package com.bsb.valise.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsb.valise.helpSupport.model.HelpSupportDto;
import com.bsb.valise.helpSupport.service.HelpSupportService;

@Controller
@RequestMapping(value = "/v1")
public class HelpSupportHandler {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	@Autowired
	HelpSupportService helpSupportService;

	@RequestMapping(value = "/hs", method = RequestMethod.GET)
	public @ResponseBody String getStatus(@RequestParam(value = "lob") String lob, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			logger.debug("In HelpSupportHandler : " + lob);

			HelpSupportDto dto = helpSupportService.getHelpSupportDataByLob(lob);
			return dto.getCat();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
