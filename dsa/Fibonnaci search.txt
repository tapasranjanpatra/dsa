
public class Fibonacci_Search {

	public static int min(int x, int y) {
		return (x <= y) ? x:y;
	}
	
	public static int fibSearch(int arr[], int x, int n) {
		int fib2 = 0;
		int fib1 = 1;
		int fib = fib1 + fib2;
		
		while(fib < n) {
			fib2 = fib1;
			fib1 = fib;
			fib = fib2 + fib1;
		}
		
		int offset = -1;
		while(fib > 1) {
			int i = min(offset + fib2 , n-1);
			
			if(arr[i] < x) {
				fib = fib1;
				fib1 = fib2;
				fib2 = fib - fib1;
				offset = i ;
			}else if(arr[i] > x) {
				fib = fib2;
				fib1 = fib1 - fib2;
				fib2 = fib - fib1;
			}else {
				return i;
			}
			
		}
		if(fib1 == 1 && arr[n-1] == x) {
			return n-1;
		}
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {10,22,35,40,45,50,80,82,85,90,100,235};
		int n =12;
		int x = 235;
		
		int ind = fibSearch(arr, x , n);
		if(ind >= 0) {
			System.out.println("Found at index: "+ ind);
		}else {
			System.out.println(x + " isn't present in the array");
		}
	}

}
