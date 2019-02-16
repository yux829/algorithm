package xqar.sorts;

import xqar.App;

/**
 * 构建一个有序队列，对于未序队列，从已排序的最后往前比较，找到一个位置插入
 * 
 * @author Administrator
 *
 */
public class InsertionSort {
	public static void sort(int[] nums) {
		if(nums==null || nums.length<1) {
			App.log("错误：参数为空");
			return;
		}
		for(int i=1;i<nums.length;i++) { //外层控制循环的趟数，每循环一次处理一个值，把它插入到适合的位置，假设第1个数是有序队列
			int value=nums[i];
			int key=i;
			//一直往前面比较第i个值与i-1个值大小，如果i小于i-1，则交换值，继续与i-2比较，直到不符合条件，此时的key就是应该插入的位置
			while(key>0&&nums[key]<nums[key-1]) {
				nums[key]=nums[key-1];
				nums[key-1]=value;
				key=key-1;
			}
//			nums[key]=value;
			
		}
	}
}
