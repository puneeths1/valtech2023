package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3d;

public class SerialTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Point p = new Point(2,3);
		System.out.println(p);
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(new File("objects")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
	    ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(new File("objects")));
	    Point p1 =  (Point) ois.readObject();
	    System.out.println(p1);
	    System.out.println(p == p1);
	    
	    Point3d p2 = new Point3d(2,3,4);
	    System.out.println(p2);
	    ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("obj")));
	    oo.writeObject(p2);
	    oo.flush();
	    oo.close();
	    ObjectInputStream oi  = new ObjectInputStream(new FileInputStream(new File("obj")));
	    Point p3 =  (Point) oi.readObject();
	    System.out.println(p3);
	    System.out.println(p2 == p3);
	    
	}

}
