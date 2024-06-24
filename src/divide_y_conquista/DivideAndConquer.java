package divideAndConquer;

public class DivideAndConquer {

	public static int binarySearch(int[] array, int elemToFind) {

		int left = 0;
		int right = array.length;

		return binarySearch(array, elemToFind, left, right);
	}

	// hidden recursive search
	private static int binarySearch(int[] array, int elemToFind, int left, int right) {

		int middle = (right + left) / 2;

		if (right < left || array.length == middle)
			return -1;

		if (elemToFind == array[middle])
			return 1;

		if (elemToFind < array[middle])
			return binarySearch(array, elemToFind, left, middle - 1);
		else
			return binarySearch(array, elemToFind, middle + 1, right);

	}

	public static double power(double number, int exponent) {

		if (exponent == 0)
			return 1;

		if (exponent == 1)
			return number;

		double result;

		if (exponent % 2 == 0)
			result = power(number, exponent / 2) * power(number, exponent / 2);
		else
			result = power(number, exponent / 2) * power(number, exponent / 2) * number;

		return result;

	}

	public static int sumAllElements(int[] array) {

		if (array.length == 0)
			return 0;

		if (array.length == 1)
			return array[0];

		int result;
		int[] firstPart = new int[array.length / 2];
		int[] secondPart = new int[array.length / 2];

		if (array.length % 2 == 0) {
			for (int i = 0; i < array.length / 2; i++) {
				firstPart[i] = array[i];
				secondPart[i] = array[i + array.length / 2];
			}

			result = sumAllElements(firstPart) + sumAllElements(secondPart);

		} else {
			int numberLeftAlone = array[array.length - 1];

			for (int i = 0; i < array.length / 2; i++) {
				firstPart[i] = array[i];
				secondPart[i] = array[i + array.length / 2];
			}
			result = sumAllElements(firstPart) + sumAllElements(secondPart) + numberLeftAlone;
		}

		return result;
	}

}
