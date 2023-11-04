package com.valtech.training.spring.point;

public class Point {
	
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Point(int x, int y) {
		super();
		System.out.println("Parameterised Constructor");
		this.x = x;
		this.y = y;
	}
	

}
