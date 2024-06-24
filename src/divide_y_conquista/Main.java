package divideAndConquer;

public class Main {

	public static void main(String[] args) {

		// Binary Search

//		int elemToFind = 200;
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 }; // pre-sorted array of positive ints
//		
//		int result = DivideAndConquer.binarySearch(array, elemToFind);
//
//		if (result != -1) {
//			System.out.println("Gotcha! " + elemToFind + " was found!");
//		} else
//			System.out.println(elemToFind + " was not found!");

		// ------------------

		// Power

//		double number = 4;
//		int exponent = 3;
//		double result = DivideAndConquer.power(number, exponent);
//		System.out.println(number + " to the power of " + exponent + " equals: " + result);

		// ------------------
		
		// Sum all elements of one array
		
		int[] array = {1,2,3,4,5};
		int result = DivideAndConquer.sumAllElements(array);
		
		System.out.println("The sum of all items in the array is: " + result);
		
	}
}
