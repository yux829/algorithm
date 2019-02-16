package xqar.sorts;

import xqar.App;
/**
 * 每次选择剩余数中最小的元素
 * 1 找到最小值，和数据第1个元素交换
 * 2  从后面的数中找到最小值，和第2个元素交换
 * 
 * 1）循环n次
 * 2）第i次循环从i个数开始从后面数中找到最小的，然后和第i个数交换
 * @author Administrator
 *
 */
public class SelectionSort {
	public static void sort(int[] nums) {
		if(nums==null || nums.length<1) {
			App.log("错误：参数为空");
			return;
		}
		for(int i=0;i<nums.length;i++) { //外层控制循环的趟数，每循环一次就会找到一个最小的值，和第i个数交换
			int min=nums[i];
			int key=i;
			for(int j=i;j<nums.length;j++) {//内层控制循环次数，从i个数开始查找
				if(min>nums[j]) { //找到最小的值，则记录下来
					min=nums[j];
					key=j;
				}
			}
			//把最小的值和i值交换
			int temp=nums[key];
			nums[key]=nums[i];
			nums[i]=temp;
		}
	}
}
