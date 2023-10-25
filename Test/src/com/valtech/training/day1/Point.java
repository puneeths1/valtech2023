package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable{
	
	public static final Point ORIGIN = new Point();

	static {
		//ORIGIN.x = 1000;
		//ORIGIN.y =2000;
		System.out.println(ORIGIN);
	}
	
	public int x;
	public transient int y;
		
	public Point() {
		System.out.println("Point Method");
	}
	
	public Point(int x,int y) {
		System.out.println(" IN ctrl of Point");
		//super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		
		
		return (x-o.x == 0)? (y-o.y):(x-o.x);
	}
	
		
		public boolean equals(Object ob) {
			Point p = (Point) ob;
			return p.x == x && p.y ==y;
		}
		
		@Override
		public int hashCode() {
			return toString().hashCode();	
			}
		
		@Override
		public String toString() {
			return "X="+x+"Y="+y+"Distance"+distance();
		}
		
		public double distance(Point other) {
			System.out.println("Distance with another Point");
			return distance(other.x,other.y);
		}
		
		public double distance(int x,int y) {
			int diffx = this.x - x;
			int diffy = this.y - y;
			return Math.sqrt(diffx*diffx + diffy*diffy);
		}
		
		public double distance() {
			System.out.println("Distance in Point");
			int diffx = x - ORIGIN.x;
			int diffy = y -  ORIGIN.y;
			return Math.sqrt(diffx*diffx + diffy*diffy);
		}
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Point p = new Point();
			p.x = 25;
			p.y = 20;
			System.out.println(p);

	}

}
