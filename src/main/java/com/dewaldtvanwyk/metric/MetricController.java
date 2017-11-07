package com.dewaldtvanwyk.metric;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dewaldtvanwyk.metric.response.MetricResponse;

@RestController
@EnableAutoConfiguration
public class MetricController {

	/* UNITS OF ACCEPTED MEASURE */
	final String CELSIUS = "CELSIUS";
	final String FAHRENHEIT = "FAHRENHEIT";
	final String FOOT = "FOOT";
	final String METRE = "METRE";
	final String CM = "CM";
	final String INCH = "INCH";

	// A webroot welcome message
	@RequestMapping("/")
	public String webroot() {
		return ("Spring Boot Micro Service webroot live");
	}

	//Usage warning: The naive calculation  [°F] = [°C] × 9/5 + 32. is cited by many sources, including Wikipedia, but if compared to a known chart, the temperatures are often far off
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = {
			"/temperature/{from}/{value}" })
	public MetricResponse temperature(@PathVariable String from, @PathVariable Double value) throws Exception {

		MetricResponse metricResponse = new MetricResponse();
		Double calc = null;

		switch (from.toUpperCase()) {
		// takes celsius and gives fahrenheit
		case CELSIUS:
			metricResponse.setUnit(FAHRENHEIT);
			// [°F] = [°C] × 9/5 + 32
			calc = value * 9 / 5 + 32;
			metricResponse.setValue(calc);
			break;
		//takes fahrenheit and gives celsius
		case FAHRENHEIT:
			metricResponse.setUnit(CELSIUS);
			// [°C] = ([°F] - 32) × 5/9
			calc = (value - 32) * 5 / 9;
			metricResponse.setValue(calc);
			break;
		default:
			throw new Exception(from.toUpperCase() + " is not a supported temperature unit.");
		}

		return (metricResponse);

	}
	
	// Below method can do 2 types of conversion
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = {
			"/distance/{from}/{value}" })
	public MetricResponse length(@PathVariable String from, @PathVariable Double value) throws Exception {

		MetricResponse metricResponse = new MetricResponse();
		Double calc = null;

		// Cited 3.28084 as feet in metre
		// However, at higher precision: 3.28083989501312
		// https://www.wyzant.com/resources/answers/13219/how_many_feet_make_a_meter
		switch (from.toUpperCase()) {
		case FOOT:
			metricResponse.setUnit(METRE);
			// 3.28083989501312 feet in a metre
			calc = (value / 3.28083989501312);
			metricResponse.setValue(calc);
			break;
		case METRE:
			metricResponse.setUnit(FOOT);
			// 1 metre = 3.28083989501312
			calc = (value * 3.28083989501312);
			metricResponse.setValue(calc);
			break;
		case CM:
			metricResponse.setUnit(INCH);
			// 3.28083989501312 feet in a metre
			calc = (value * 0.3937008);
			metricResponse.setValue(calc);
			break;
		case INCH:
			metricResponse.setUnit(CM);
			// 1 metre = 3.28083989501312
			calc = (value / 0.3937008);
			metricResponse.setValue(calc);
			break;
		default:
			throw new Exception(from.toUpperCase() + " is not a supported distance unit.");
		}

		return (metricResponse);

	}

}
