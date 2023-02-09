package edu.poly.store.StreamAPI;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import edu.poly.store.bean.Student;

public class StreamAPI {
	static List<Student> list  = Arrays.asList(
			new Student("Teo",true,7.5),
			new Student("duc",true,5.5),
			new Student("dat",true,9.5),
			new Student("cu",true,4.5),
			new Student("xuong",true,6.5),
			new Student("abc",true,10.0)
			
			);
	 public static void main(String[] args) {
			demo1();
			demo3();
		}

	private static void demo3() {
		List<Student> result = list.stream()
				.filter(sv-> sv.getMarks() >=7)
				.peek(sv-> sv.setName(sv.getName().toUpperCase()))
				.collect(Collectors.toList());
		
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		List<Double> result = list.stream()
				.filter(n-> n %2 ==0)
				.map(n-> Math.sqrt(n) )
				.peek(d-> System.out.println(d))
				.collect(Collectors.toList());
		
	}

}
