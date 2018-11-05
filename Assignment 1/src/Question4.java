
public class Question4 {

	public static void main(String[] args) {

		int key = Integer.parseInt(args[0]);
		binarySearchVariant(key);

	}
	
	public static void binarySearchVariant(int key)
	{

		int[] list = new int[200];
		int high = list.length;
		int low = 0;
		int mid = 0;
		int comparisons = 0;
		Boolean keyFound = false;
		
		//Fill list with even #s from 2 to 400
		for(int n = 0;n < list.length;n++) {
			list[n] = 2*(n+1);
		}
		
		mid = low + ((high - low)/3);
		
		while(low < high & !keyFound & low != mid & high != mid) 
		{
			
			if(list[mid] == key)	//Key found, print necessary info
			{
				//return mid;
				comparisons++;
				System.out.println("K was found.");
				System.out.println("The algorithm performed " + comparisons + " comparisons.");
				System.out.println("K was found at position " + mid + " in the list.");
				keyFound = true;
			} 
			else if(list[mid] > key)	//Key is lower than compared value
			{
				comparisons++;
				//high = mid - 1;
				high = mid;
			} 
			else if(list[mid] < key)	//Key is higher than compared value
			{
				comparisons++;
				//low = mid + 1;
				low = mid;
			}
			
			mid = low + ((high - low)/3);
			
			if((high - low) == 2) {
				mid++;
			}
			
		}
		
		//return -1;
		if(!keyFound) {
			System.out.println("K was not found");
			System.out.println("The algorithm performed " + comparisons + " comparisons.");
		}
		
	}

}
