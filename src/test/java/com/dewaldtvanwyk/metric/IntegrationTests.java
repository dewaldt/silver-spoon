package com.dewaldtvanwyk.metric;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.dewaldtvanwyk.metric.response.MetricResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class IntegrationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	/* For the sake of brevity, not all services have tests */

	// see if web server is running
	@Test
	public void testWebrootResponse() throws Exception {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + this.port + "/", String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	// check if webservice returns correct data on running server
	@Test
	public void testCmToInchService() throws Exception {
		ResponseEntity<MetricResponse> responseEntity = restTemplate
				.getForEntity("http://localhost:" + this.port + "/distance/cm/20", MetricResponse.class);
		MetricResponse metricResponse = responseEntity.getBody();
		assertEquals("INCH", metricResponse.getUnit());
		assertEquals((Double) 7.874016, metricResponse.getValue());

	}

}
