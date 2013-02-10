import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DivideAndConquer {
	
	private static long numberOfInversions = 0;

	public static void main(String[] args) {
		Integer[] a = readArrayFromFile("IntegerArray.txt");
		//printArray(a);
		mergeSortAndCount(a);
		//printArray(sortedA);
		System.out.println("Total number of inversions = " + numberOfInversions);
	}
	
	private static Integer[] mergeSortAndCount(Integer[] input) {
		
		// Base case
		if (input.length <= 1) {
			return input;
			
		} 
		
		Integer[] left = new Integer[input.length / 2];
		Integer[] right = new Integer[input.length / 2 + input.length % 2];
		
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
		
		left = mergeSortAndCount(left);
		right = mergeSortAndCount(right);
		
		return mergeAndCount(left, right);
	}
	
	private static Integer[] mergeAndCount(Integer[] left, Integer[] right) {
		Integer[] result = new Integer[left.length + right.length];
		
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
					// Here count the number of inversion
					//System.out.println("Inversion with i = " + i + " and left array = " + left.length);
					numberOfInversions += (left.length - i);
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

	private static void printArray(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print(array[i]);
			} else {
				System.out.print(", " + array[i]);
			}
		}
		System.out.println();
	}
	
	public static Integer[] readArrayFromFile(String filename) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			List<Integer> integerListFromFile = new ArrayList<Integer>();
			String str = br.readLine();
			while (str != null) {
				Integer current = Integer.parseInt(str);
				integerListFromFile.add(current);
				str = br.readLine();
			}
			br.close();
			return integerListFromFile.toArray(new Integer[integerListFromFile.size()]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
