package com.bsb.valise.script;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bsb.valise.dto.CustomerBo;

public class AspectDemo {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:src/main/resources/valise-servlet.xml");

		CustomerBo customer = (CustomerBo) applicationContext.getBean("customerBo");

		customer.addCustomer();

		System.out.println();

	}
}
