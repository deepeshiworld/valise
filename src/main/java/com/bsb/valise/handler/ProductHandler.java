package com.bsb.valise.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsb.valise.common.Config;
import com.bsb.valise.dto.ProductDetailDto;
import com.bsb.valise.service.ProductService;

@Controller
@RequestMapping(value = "/v1")
public class ProductHandler {

	private Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public @ResponseBody String getStatus(@RequestParam(value = "pid") String pid, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("In Resigtration handler : " + pid);
		try {
			if (StringUtils.isBlank(pid)) {
				Config.writeJSON(response, null);
			} else {
				ProductDetailDto detailDto = productService.getProductDetail(pid);
				Config.writeJSON(response, detailDto);
			}
		} catch (IOException e) {
			logger.error("error in handler : " + e.getMessage());
		}
		return null;

	}

	@RequestMapping(value = "/submitProduct", method = RequestMethod.POST)
	public String submitTask(@RequestBody String param, HttpServletRequest request, HttpServletResponse response) {

		logger.info(param);

		return "SUCCESS";
	}
}
