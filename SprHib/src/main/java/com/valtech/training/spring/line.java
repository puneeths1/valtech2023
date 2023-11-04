package com.valtech.training.spring;

import com.valtech.training.spring.point.Point;

public class line {
	
	private Point start;
	private Point end;
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	public line() {
		super();
		// TODO Auto-generated constructor stub
	}
	public line(Point start, Point end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "line [start=" + start + ", end=" + end + "]";
	}
	
	
	
}
