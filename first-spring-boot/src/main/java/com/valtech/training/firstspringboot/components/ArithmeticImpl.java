package com.valtech.training.firstspringboot.components;

public class ArithmeticImpl implements Arithmetic {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException {
		if(b==0) {
			throw new DivideByZeroException("Zero cannot be used as denominator");
		}
		return a / b;
	}
	
	public static void main(String[] args) {
		Arithmetic a = new ArithmeticImpl();
		//System.out.println(a.add(2, 5));
		//System.out.println(a.sub(21, 5));
		//System.out.println(a.mul(2, 5));
		try {
			System.out.println(a.div(22, 5));
			System.out.println(a.div(20,0));
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("IN EXCEPTION");
	}
		finally {
			System.out.println("in finally");
		}
		System.out.println(a.mul(3, 6));
	}
}


