package edu.poly.store.lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
		demo1();
		demo2();
		demo4();
	}

	private static void demo4() {
		deMo4Inter oInter =(x) -> {
			
			System.out.println(x);
			
		};
		oInter.m1(2022);
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		list.forEach(n -> System.out.println(n));
	}
	private static void demo2() {
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		list.forEach(n -> System.out.println(n));
	}
	@FunctionalInterface
	interface deMo4Inter{
		void m1(int x);
		default void m2() {}
		public static void m3() {
			
		}
	}
}
