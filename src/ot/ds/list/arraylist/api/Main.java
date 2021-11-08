package ot.ds.list.arraylist.api;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		System.out.println("add(값)");
		System.out.println(numbers);
		
		numbers.add(1, 50);
		System.out.println("\nadd(인덱스, 값)");
		System.out.println(numbers);
		
		numbers.remove(2);
		System.out.println("\nremove(인덱스)");
		System.out.println(numbers);
		
		System.out.println("\nget(인덱스)");
		System.out.println(numbers.get(2));
		
		Iterator it = numbers.iterator();
		System.out.println("\niterator");
		while(it.hasNext()) { //뒤에 값이 있냐 없냐 판단
			int value = (int)it.next();
			if(value == 30) {
				it.remove();
			}
			System.out.println(value);
		}
		System.out.println(numbers);
		
		System.out.println("\nfor each");
		for(int value : numbers) {
			System.out.println(value);
		}
		
		System.out.println("\nfor");
		for(int i=0; i<numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
	}
}
