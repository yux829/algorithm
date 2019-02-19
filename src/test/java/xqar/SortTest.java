package xqar;

import org.junit.Test;

import xqar.sorts.*;

public class SortTest {
	private 	int[] nums= new int[] {1,7,2,5,3,4,6,9,8};
	private int[] nums2 = new int[]{8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
	@Test
	public void testSelectionSort() {
		SelectionSort.sort(nums);
		SelectionSort.sort(nums2);
		log();
	}
	@Test
	public void testBubbleSort() {
		BubbleSort.sort(nums);
		BubbleSort.sort(nums2);
		log();
	}
	
	@Test
	public void testInsertionSort() {
		InsertionSort.sort(nums);
		InsertionSort.sort(nums2);
		log();
	}
	@Test
	public void testMergeSort() {
		nums=MergeSort.sort(nums);
		nums2=MergeSort.sort(nums2);
		log();
	}
	
	
	
	private void log() {
		for(int value:nums) {
			App.log(value+",");
		}
		App.logln("---------");
		for(int value:nums2) {
			App.log(value+",");
		}
		App.logln("---------");
	}

}
