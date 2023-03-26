
public class Linear_Search {
	
// time complexity is O(n)
	public static int Index(int Arr[], int num) {
		for(int i=0;i<=Arr.length;i++) {
			if(Arr[i] == num) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Arr[] = {1,9,7,6,4,3,2};
		int num = 2;
		
		System.out.println("Index of "+num+" is "+Index(Arr,num));
	}

}
