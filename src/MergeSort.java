
public class MergeSort {

	public static void main(String[] args) {
		int[] input = new int[] { 4, 7, 3, 5, 1, 8, 9, 6, 2 };
		printArray(input);
		int[] result = mergeSort(input);
		printArray(result);
	}
	
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print(array[i]);
			} else {
				System.out.print(", " + array[i]);
			}
		}
		System.out.println();
	}
	
	private static int[] mergeSort(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		
		int[] left = new int[input.length / 2];
		int[] right = new int[input.length / 2 + input.length % 2];
		
		int i = 0, j = 0, k = 0;
		
		while (k < input.length) {
			if (k < input.length / 2) {
				left[i] = input[k];
				i++;
				k++;
			} else {
				right[j] = input[k];
				j++;
				k++;
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while (k < result.length) {
			if (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					result[k] = left[i];
					i++;
					k++;
				} else {
					result[k] = right[j];
					j++;
					k++;
				}
			} else if (i < left.length) {
				result[k] = left[i];
				i++;
				k++;
			} else {
				result[k] = right[j];
				j++;
				k++;
			}
		}
		return result;
	}
	
}
