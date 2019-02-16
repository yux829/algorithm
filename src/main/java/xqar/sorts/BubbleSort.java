package xqar.sorts;

import org.junit.Test;

import xqar.App;

/**
 * 冒泡：持续比较相邻的两个元素，大的挪到后面
 * https://www.cnblogs.com/shen-hua/p/5422676.html
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较；
第二趟比较完成后，倒数第二个数也一定是数组中第二大的数，所以第三趟比较的时候最后两个数不参与比较；
依次类推，每一趟比较次数-1；
 * @author Administrator
 *
 */
public class BubbleSort {
	
	
	public static void sort(int[] nums) {
		if(nums==null || nums.length<1) {
			App.log("错误：参数为空");
			return;
		}
		for(int i=0;i<nums.length-1;i++) { //外层控制循环的趟数，每循环一次就会找到一个最大的值放到最后
			for(int j=1;j<nums.length-i;j++) {//内层控制循环字数，小于已经找到的最大值的个数
				if(nums[j-1]>nums[j]) {
					int temp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
		}
	}
	
	
	@Test
	public void testSort() {
		int[] nums= new int[] {12,34,2,1,5,8,4,3,100,123,932749};
		BubbleSort.sort(nums);
		for(int value:nums) {
			App.log(value+",");
		}
		
	}

}
