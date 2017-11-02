package com.dewaldtvanwyk.metric.response;

/* Generic pojo for responding to conversions */

public class MetricResponse {

	String unit;
	Double value;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
