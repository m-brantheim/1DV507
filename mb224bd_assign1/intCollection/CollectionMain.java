package mb224bd_assign1.intCollection;

public class CollectionMain {

	public static void main(String[] args) {
		ArrayIntList arrayIntList = new ArrayIntList();
		arrayIntList.add(5);
		// Should print 5
		System.out.println(arrayIntList.get(0));
		// Should print 0 (the index of 5)
		System.out.println(arrayIntList.indexOf(5));
		// Should print -1 (7 does not exist in list)
		System.out.println(arrayIntList.indexOf(7));
		arrayIntList.remove(0);
		// Should print -1 (5 was removed)
		System.out.println(arrayIntList.indexOf(5));
		
		// Should throw ArrayIndexOutOfBoundsException
		//arrayIntList.get(12);
		
		arrayIntList.add(1);
		arrayIntList.add(2);
		arrayIntList.add(3);
		arrayIntList.add(4);
		arrayIntList.add(5);
		
		// Should print 3 (the index of 4)
		System.out.println(arrayIntList.indexOf(4));
		
		arrayIntList.addAt(44, 3);
		// Should print 3 (the index of 44)
		System.out.println(arrayIntList.indexOf(44));
		
		
		ArrayIntStack arrayIntStack = new ArrayIntStack();
		arrayIntStack.push(100);
		arrayIntStack.push(200);
		arrayIntStack.push(300);
		// Should print 300
		System.out.println(arrayIntStack.peek());
		// Should print 300
		System.out.println(arrayIntStack.pop());
		// Should print 200
		System.out.println(arrayIntStack.pop());
		// Should print 100
		System.out.println(arrayIntStack.pop());
		// Should throw ArrayIndexOutOfBoundsException
		//System.out.println(arrayIntStack.pop());

	}

}
