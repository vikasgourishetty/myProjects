package com.vikas.groundrun.tool;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GroundRunApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(GroundRunApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(GroundRunApplication.class, args);
		
		logger.info("Beans in the context");
		
		String beanNames[] = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		
		for(String beanName : beanNames)
			logger.info(beanName);
	}
}
