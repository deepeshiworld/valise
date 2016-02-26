package com.bsb.valise.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/v1")

public class UserRegistrationHandler {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public @ResponseBody String getStatus(@RequestParam(value = "text") String text, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("In Resigtration handler : ");

		String line = request.getParameter("text");
		logger.info(text);

//		try {
			if (StringUtils.isNotBlank(line)) {
				return null;
			} else {
				line = line.trim();
			}

			//Config.writeJSON(response, map);

//		} catch (IOException e) {
//			logger.error(line + " :  " + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error(line + " :  " + e.getMessage());
//			return null;
//		}
		return null;

	}
}
