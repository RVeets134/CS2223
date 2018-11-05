
public class Question1 {

	public static void main(String[] args) {

		int input = Integer.parseInt(args[0]);
		System.out.println(testFunctions(input));

	}
	
	private static long testFunctions(int selection) {
		
		long elapsedTime = 0;
		final int N = 100000;
		long start = 0;
		long end = 0;
		long sum = 0;
		
		switch(selection) {
		
			// Linear function
			case 1:
				start = System.currentTimeMillis();
				for(int count1 = 0;count1 < N;count1++) {
					sum *= 1;
				}	
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
			//Quadratic function
			case 2:
				start = System.currentTimeMillis();
				for(int count1 = 0;count1 < N;count1++) {
					for(int count2 = 0;count2 < N;count2++) {
						sum *= 1;
					}
					sum *= 1;
				}
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
			//Cubic function	
			case 3:
				start = System.currentTimeMillis();
				for(int count1 = 0;count1 < N;count1++) {
					for(int count2 = 0;count2 < N;count2++) {
						for(int count3 = 0;count3 < N;count3++) {
							sum *= 1;
						}
						sum *= 1;
					}
					sum *= 1;
				}
				end = System.currentTimeMillis();
				elapsedTime = end - start;
				break;
			//Default case	
			default:
				System.out.println("Invalid argument.");
		}
		
		return elapsedTime;
		
	}

}
