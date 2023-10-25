package com.valtech.training.day2;

public class Outer {
	private int x=10;
	public Inner createInner() {
		return new Inner();
	}
	public static interface abcd {
		
	}
	
	public abstract static class StaticInner implements abcd{
		public void jumpBy10(Outer o) {
			o.x = o.x+10;
		}
		public void jumpBy100(Outer o) {
			
		}
	}
	public class Inner{
		public void printx() {
			System.out.println(x);
		}
		
		public void increment() {
			x++;
		}
	}
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.createInner();
		Outer.Inner i1 = o.createInner();
		i1.increment();
		i1.printx();
		new Outer().createInner().printx();
		StaticInner s1 = new StaticInner() {
			@Override
			public void jumpBy100(Outer o){
				o.x =o.x +100;
				
			}
		};
		s1.jumpBy10(o);
		s1.jumpBy100(o);
		i.printx();
		
		Arithmetic a = new Arithmetic() {
			
			@Override
			public int sub(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int mul(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int div(int a, int b) throws DivideByZeroException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
}
