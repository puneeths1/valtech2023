package com.valtech.training.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.valtech.training.spring.point.Point;

public class UtilsBean {
	
	private List<String> names;
	
	private Properties settings;
	
	private Map<Point,line> points;

	public Map<Point, line> getPoints() {
		return points;
	}

	public void setPoints(Map<Point, line> points) {
		this.points = points;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	public Properties getSettings() {
		return settings;
	}

	public void setSettings(Properties settings) {
		this.settings = settings;
	}

	
	

}
