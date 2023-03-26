
public class Binary_Search {

	//Time complexity is O(log n , base2 )
	public static int IndArr(int Arr[],int num) {
		int start = 0;
		int last = Arr.length-1;
		
		
		while(start<=last) {
			int mid = (int)(start+last)/2;
			
			if(Arr[mid] == num) {
				return mid;
			}
			if(Arr[mid]<num) {
				start = mid+1;
			}else{last = mid-1;}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int Arr[] = {1,2,3,4,5,6,7,8,9}; // arrays should be sorted for binary search
   
   int num = 8;

   System.out.println("Index of "+num+" is "+ IndArr(Arr,num));
 
	}

}
