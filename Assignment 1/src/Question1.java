
public class Question1 {

	public static void main(String[] args) {

		//System.out.println("Select a function.");
		//int input = 1;
		for(int n = 1;n <= 3;n++) {
			System.out.println(testFunctions(n));
		}
		
	}
	
	private static long testFunctions(int selection) {
		
		long elapsedTime = 0;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int N = 100000;
		long start = 0;
		long end = 0;
		
		switch(selection) {
		
			// Linear function
			case 1:
				start = System.currentTimeMillis();
				while(count1 < N) {
					count1 += 1;
				}
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
			//Quadratic function
			case 2:
				start = System.currentTimeMillis();
				while(count1 < N) {
					while(count2 < N) {
						count2 += 1;
					}
					count1 += 1;
				}
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
			//Cubic function	
			case 3:
				start = System.currentTimeMillis();
				while(count1 < N) {
					while(count2 < N) {
						while(count3 < N) {
							count3 += 1;
						}
						count2 += 1;
					}
					count1 += 1;
				}
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
		}
		
		return elapsedTime;
		
	}

}
