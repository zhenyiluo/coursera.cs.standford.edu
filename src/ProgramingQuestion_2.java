

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ProgramingQuestion_2 {
	public static void main(String[] args){
		File file = new File("/Users/cecilia/Downloads/QuickSort.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();	
		while(sc.hasNextInt()){
			list.add(sc.nextInt());
		}
		int size = list.size();
		int[] array = new int[size];
		for(int i = 0; i < size; i++){
			array[i] = list.get(i);
		}
//		System.out.println(sort1(array, 0, array.length -1));
		System.out.println(sort2(array, 0, array.length -1));
//		System.out.println(sort3(array, 0, array.length -1));
//		for(int n : array){
//			System.out.println(n);
//		}
		
	}

	private static int sort1(int[] a, int start, int end) {
		if(end <= start){
			return 0;
		}
		int ret = 0;
		int pivot = a[start];
		int i = start; 
		for(int j = start + 1; j <= end; j++){
			if(a[j] < pivot){
				swap(a, ++i, j);
			}
		}
		swap(a, start, i);
		
		ret += end - start;
		ret += sort1(a, start, i-1);
		ret += sort1(a, i+1, end);
		return ret;
	}
	private static int sort2(int[] a, int start, int end) {
		if(end <= start){
			return 0;
		}
		int ret = 0;
		swap(a, start, end);
		int pivot = a[start];
		int i = start; 
		for(int j = start + 1; j <= end; j++){
			if(a[j] < pivot){
				swap(a, ++i, j);
			}
		}
		swap(a, start, i);
		
		ret += end - start;
		ret += sort2(a, start, i-1);
		ret += sort2(a, i+1, end);
		return ret;
	}
	
	private static int sort3(int[] a, int start, int end) {
		if(end <= start){
			return 0;
		}
		int ret = 0;
		int mid = start + ((end - start)>> 1);
		if(a[start] < Math.max(a[mid], a[end]) && a[start] > Math.min(a[mid], a[end])){
			// Do nothing
		}else if(a[mid] < Math.max(a[start], a[end]) && a[mid] > Math.min(a[start], a[end])){
			swap(a, start, mid);
		}else{
			swap(a, start, end);
		}
		int pivot = a[start];
		int i = start; 
		for(int j = start + 1; j <= end; j++){
			if(a[j] < pivot){
				swap(a, ++i, j);
			}
		}
		swap(a, start, i);
		
		ret += end - start;
		ret += sort3(a, start, i-1);
		ret += sort3(a, i+1, end);
		return ret;
	}
	private static void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
