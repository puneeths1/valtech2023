package com.valtech.training.spring;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;
	
	public SimpleInterestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic=arithmetic;
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeInterest(int prin, int roi, int duration) {
		// TODO Auto-generated method stub
		int result = arithmetic.mul(prin, roi);
		result = arithmetic.mul(result, duration);
		
		return arithmetic.div(result,100);
	}
	
	public static void main(String args[]) {
		Arithmetic arithmetic  = new ArithmeticImpl();
		SimpleInterest s1 = new SimpleInterestImpl(arithmetic);
		System.out.println(s1.computeInterest(200,3, 4));
	}

}
