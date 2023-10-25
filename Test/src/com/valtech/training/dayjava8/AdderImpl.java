package com.valtech.training.dayjava8;

public class AdderImpl implements Adder{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adder s = new AdderImpl();
		System.out.println(s.add(3, 4));
		Adder s1 = new Adder() {
			public int add(int a,int b) {
				return a+b;
			}
		};
		System.out.println(s1.add(56, 3));
		Adder s2 = (i,j) ->{return i+j;};
		System.out.println(s2.add(5, 8));
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
