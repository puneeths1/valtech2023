package com.valtech.training.dayjava8;

public class VarArgs {
	//varargs should be in last argument
	public int add(int a,int ...b) {
		int result = a;
		for(int b1 : b) {
			result+=b1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println(va.add(5, 2));
		System.out.println(va.add(7, 8,3));
		System.out.println(va.add(4, 2,3,7));
	}

}
