package com.valtech.training.day1;

public class Point3d extends Point {
	
	public static final Point3d ORIGIN = new Point3d();
	
	 private int z;
	 public Point3d() {
		 
	 }
	 
	 public Point3d(int x,int y,int z) {
		 super(x,y);
		 System.out.println("In ctor of Point 3d");
		 this.z = z;
	 }
	 
	@Override
	public boolean equals(Object ob) {
		Point3d p = (Point3d) ob;
		return p.x == x && p.y ==y && p.z == z;
	}
	
	//public int hashCode() {
		//return toString().hashCode();	}
	
	public String toString() {
		return "X="+x+"Y="+y+"Z="+z;
	}
	
	public double distance(Point3d p) {
		return distance(p.x,p.y,p.z);
	}
	
	public double distance(int x,int y,int z) {
		int diffx = this.x - x;
		int diffy = this.y - y;
		int diffz = this.z - z;
		return Math.sqrt(diffx*diffx + diffy*diffy +diffz*diffz);
	}
	
	
	
	@Override
	public double distance() {
		System.out.println("Point 3d distance");
		return Math.sqrt(x*x + y*y + z*z);
	}
	public static void main(String[] args) {
		
		System.out.println(Point.ORIGIN.distance());
		System.out.println(ORIGIN.distance());
		Point3d p = new Point3d(10,20,30);
		double dis = p.distance(new Point(20,30));
		System.out.println(p);
		System.out.println(dis);
		 
	}

}
