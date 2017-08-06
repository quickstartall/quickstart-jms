package com.raquibul.quickstartall.jms.receiver.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature  extends Weather implements Serializable{
	private static final long serialVersionUID = 1L;
	private Map<String, Float> temperatures = new HashMap<String, Float>();
	private Float maxTemperature;
	private Float averageTemperature;
	/**
	 * @return the temperatures
	 */
	public Map<String, Float> getTemperatures() {
		return temperatures;
	}
	/**
	 * @param temperatures the temperatures to set
	 */
	public void setTemperatures(Map<String, Float> temperatures) {
		this.temperatures = temperatures;
	}
	/**
	 * @return the maxTemperatureTillNow
	 */
	public Float getMaxTemperatureTillNow() {
		return maxTemperature;
	}
	/**
	 * @param maxTemperatureTillNow the maxTemperatureTillNow to set
	 */
	public void setMaxTemperatureTillNow(Float maxTemperatureTillNow) {
		this.maxTemperature = maxTemperatureTillNow;
	}
	/**
	 * @return the averageTemperature
	 */
	public Float getAverageTemperature() {
		return averageTemperature;
	}
	/**
	 * @param averageTemperature the averageTemperature to set
	 */
	public void setAverageTemperature(Float averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	
	@Override
	@JsonIgnore
	public String toString() {
		return MoreObjects.toStringHelper(this).add("temperatures", temperatures).add("maxTemperature", maxTemperature)
				.add("averageTemperature", averageTemperature).toString();
	}
	
	@Override
	@JsonIgnore
	public int hashCode() {
		return Objects.hashCode(this.maxTemperature, this.averageTemperature);
	}
	
	@Override
	@JsonIgnore
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
        if (getClass() != obj.getClass()) {
        	return false;
        }
        
        Temperature other = (Temperature) obj;
        return Objects.equal(this.maxTemperature, other.maxTemperature)
            && Objects.equal(this.averageTemperature, other.averageTemperature);

	}
	
}
