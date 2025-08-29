
public class Sum {

	public static long sum(int num) {
		long sum = 0;

		for(int i = 0; i <= num; i++) {
			sum += i;
		}

		return sum;
	}

	public static long sumFormula(int num) {
		long sum = num * (num + 1) / 2;

		return sum;
	}
	public static void main(String[] args) {

		int [] inputs = {10_000, 100_000, 500_000, 750_000, 1_000_000, 
				2_000_000, 3_000_000, 4_000_000, 5_000_000, 6_000_000,
				7_000_000, 8_000_000, 9_000_000, 10_000_000, 
				20_000_000, 30_000_000 };
		long startTime;
		long endTime;
		long elapsed;


		System.out.printf("Input size (n), time for loop based summation, time for summation formula n(n + 1)/2 \n");
		System.out.printf("---------------------------------------------------------------------------------------\n");
		for(int i = 0; i < inputs.length; i++) {
			System.out.printf("%14d ", inputs[i] );
			startTime = System.currentTimeMillis();       // record the starting time
			sum(inputs[i]);
			endTime = System.currentTimeMillis();         // record the ending time
			elapsed = endTime - startTime;
			System.out.printf("%29d ", elapsed );

			startTime = System.currentTimeMillis();       // record the starting time
			sumFormula(inputs[i]);
			endTime = System.currentTimeMillis();         // record the ending time
			elapsed = endTime - startTime;
			System.out.printf("%37d\n",elapsed);			



		}

	}

}
