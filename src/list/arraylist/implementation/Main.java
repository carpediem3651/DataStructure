package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {
		
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		
//		for(int i=0; i<numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
		
		ArrayList.ListIterator li = numbers.listIterator();
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
		
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
		
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.next());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
//		System.out.println(li.previous());
		
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//		
//		while(li.hasPrevious()) {
//			System.out.println(li.previous());
//		}
		
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) {
				li.add(35);
			}
			System.out.println(number);
		}
	}
}
