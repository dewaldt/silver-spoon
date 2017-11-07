package com.dewaldtvanwyk.metric;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dewaldtvanwyk.metric.MetricController;
import com.dewaldtvanwyk.metric.response.MetricResponse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricControllerTests {
	
	/* For the sake of brevity, not all services have tests */

	@Autowired
	private MetricController controller;

	@Test
	public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
		
	}
	
	@Test 
	public void testFahrenheitToCelsius()
	{
		try {
			//Test case that 30 degrees celsuis should equal 86 fahrenheit
			MetricResponse metricResponse = controller.temperature("celsius", 30.0);
			assertEquals(true,metricResponse.getUnit().equalsIgnoreCase("fahrenheit"));
			assertEquals((Double)86.0,metricResponse.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertEquals(false,true); //failure
			e.printStackTrace();
		}
		
		assertEquals(true,true);
		
	}

}
