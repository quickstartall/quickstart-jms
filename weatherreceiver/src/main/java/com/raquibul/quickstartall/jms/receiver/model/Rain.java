package com.raquibul.quickstartall.jms.receiver.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain extends Weather implements Serializable{
	private static final long serialVersionUID = 1L;
	private Map<String, Float> rains = new HashMap<String, Float>();
	private Float maxRain;
	private Float averageRain;
	/**
	 * @return the rains
	 */
	public Map<String, Float> getRains() {
		return rains;
	}
	/**
	 * @param rains the rains to set
	 */
	public void setRains(Map<String, Float> rains) {
		this.rains = rains;
	}
	
	
	/**
	 * @return the maxRain
	 */
	public Float getMaxRain() {
		return maxRain;
	}
	/**
	 * @param maxRain the maxRain to set
	 */
	public void setMaxRain(Float maxRain) {
		this.maxRain = maxRain;
	}
	/**
	 * @return the averageRain
	 */
	public Float getAverageRain() {
		return averageRain;
	}
	/**
	 * @param averageRain the averageRain to set
	 */
	public void setAverageRain(Float averageRain) {
		this.averageRain = averageRain;
	}
	
	@Override
	@JsonIgnore
	public String toString() {
		return MoreObjects.toStringHelper(this).add("rains", rains).add("maxRain", maxRain)
				.add("averageRain", averageRain).toString();
	}
	
	@Override
	@JsonIgnore
	public int hashCode() {
		return Objects.hashCode(this.maxRain, this.averageRain);
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
        
        Rain other = (Rain) obj;
        return Objects.equal(this.maxRain, other.maxRain)
            && Objects.equal(this.averageRain, other.averageRain);

	}
}
