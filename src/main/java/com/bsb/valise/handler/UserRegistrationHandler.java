package com.bsb.valise.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
| Annotation | Meaning                                             |
+------------+-----------------------------------------------------+
| @Component | generic stereotype for any Spring-managed component |
| @Repository| stereotype for persistence layer                    |
| @Service   | stereotype for service layer                        |
| @Controller| stereotype for presentation layer (spring-mvc)      |
*/
@Controller
@RequestMapping(value = "/v1")
public class UserRegistrationHandler {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public @ResponseBody String getStatus(@RequestParam(value = "text") String text, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("In Resigtration handler : " + text);

		String line = request.getParameter("text");
		logger.info(line);

		if (StringUtils.isNotBlank(line)) {
			return line;
		} else {
			line = line.trim();
		}

		return null;

	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submitTask(@RequestBody String param, HttpServletRequest request, HttpServletResponse response) {

		logger.info(param);

		return "SUCCESS";
	}
}
