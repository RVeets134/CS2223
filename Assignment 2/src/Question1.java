import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Question1 {

	static int[] unsortedList = new int[100];
	static PrintWriter writer;

	public static void main(String[] args) throws IOException {

		writer = new PrintWriter(new File("quickSortList.txt"));
		
		final int MAX = 1000;
		final int MIN = 1;
		
		for(int n = 0;n < unsortedList.length;n++) {
			unsortedList[n] = (int) ((Math.random() * MAX - MIN + 1) + MIN);
			//unsortedList[n] = 10000/(3*n+1);
			//System.out.println(unsortedList[n]);
		}
		
		quickSort(0, unsortedList.length-1);

	}
	
	private static void quickSort(int start, int end) throws IOException {
		
		//Update on the list on every recursive call
		for(int n = 0;n < unsortedList.length;n++) {
			if(n < unsortedList.length - 1) {
				writer.print(unsortedList[n] + ", ");
				writer.flush();	
				//System.out.print(unsortedList[n] + ", ");
			}
			else {
				writer.print(unsortedList[n]);
				writer.flush();	
				//System.out.print(unsortedList[n]);
			}
		}
		writer.println();
		writer.flush();
		//System.out.println();
		
		makeMedianPivot(start, end);
		
		int mid = 0;
		if(end - start >= 1) {
			mid = getPivotSwap(start, end);
			quickSort(start, mid-1);
			quickSort(mid + 1, end);
		}
		
	}
	
	//Finds median from the left, mid, and right values to put at the end of the list and use as the pivot
	private static void makeMedianPivot(int start, int end) {
		
		if(unsortedList.length > 0) {
			int right = unsortedList[end];
			int left = unsortedList[start];
			int mid = unsortedList[(end-start)/2];
			
			if((left < mid && mid < right) || (right < mid && mid < left)) {
				unsortedList[end] = mid;
				unsortedList[(end-start)/2] = right;
			}
			else if((mid < left && left < right) || (right < left && left < mid)) {
				unsortedList[end] = left;
				unsortedList[start] = right;
			}
			
		}
		
	}
	
	//Performs the switching portion of the quick sort algorithm
	//Also, returns index where list is broken into sublists that need to go through the algorithm
	private static int getPivotSwap(int start, int end) {
		
		int pivot = unsortedList[end];
		int leftPointer = start;
		int rightPointer = end;
		int tempValue = 0;
		
		//Algorithm to switch values with quicksort
		while(leftPointer != rightPointer) {    //Loop through list until pointers cross
			
			if(unsortedList[leftPointer] > pivot) {     //Left pointer value greater than pivot
				if(unsortedList[rightPointer] < pivot) {      //Right pointer value less than pivot
					//Switch left and right values
					tempValue = unsortedList[rightPointer];
					unsortedList[rightPointer] = unsortedList[leftPointer];
					unsortedList[leftPointer] = tempValue;
					leftPointer++;
				}
				else {     //Right pointer value also greater than pivot, can't switch, need to look for one to switch with
					rightPointer--;
				}
			}
			else {     //Left pointer value is less than pivot, no need to switch this value
				leftPointer++;
			}
		}
		
		
		//Switch value where pointers cross with the pivot value
		unsortedList[end] = unsortedList[leftPointer];
		unsortedList[leftPointer] = pivot;
		return leftPointer;
		
	}
	
}
