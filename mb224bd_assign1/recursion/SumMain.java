package mb224bd_assign1.recursion;

public class SumMain {

	public static void main(String[] args) {
		System.out.println(sumInts(3));
	}
	
	private static int sumInts(int n) {
		if(n <= 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else if(n == 2) {
			return 3;
		}
		return sumInts(n / 2) + sumInts(n / 2 + 1);
	}

}
