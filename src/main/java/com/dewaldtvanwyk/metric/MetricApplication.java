package com.dewaldtvanwyk.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class MetricApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricApplication.class, args);
	}
	
	/* Rest Logic may be found in MetricController */

}
