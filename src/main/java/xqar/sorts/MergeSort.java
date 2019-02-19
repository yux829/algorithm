package xqar.sorts;

import java.util.Arrays;

import xqar.App;

/**
 * 两个有序数组的合并：
首先来看归并排序要解决的第一个问题：两个有序的数组怎样合成一个新的有序数组：
比如数组1｛ 3，5，7，8 ｝数组2为｛ 1，4，9，10 ｝：
首先那肯定是创建一个长度为8的新数组咯，然后就是分别从左到右比较两个数组中哪一个值比较小，然后复制进新的数组中：比如我们这个例子：
｛ 3，5，7，8 ｝ ｛ 1，4，9，10 ｝  ｛  ｝一开始新数组是空的。
然后两个指针分别指向第一个元素，进行比较，显然，1比3小，所以把1复制进新数组中：
｛ 3，5，7，8 ｝ ｛ 1，4，9，10 ｝  ｛ 1， ｝
第二个数组的指针后移，再进行比较，这次是3比较小：
｛ 3，5，7，8 ｝ ｛ 1，4，9，10 ｝  ｛ 1，3， ｝
同理，我们一直比较到两个数组中有某一个先到末尾为止，在我们的例子中，第一个数组先用完。｛ 3，5，7，8 ｝ ｛ 1，4，9，10 ｝  ｛ 1，3，4，5，7，8 ｝
最后把第二个数组中的元素复制进新数组即可。
｛ 1，3，4，5，7，8，9，10 ｝
由于前提是这个两个数组都是有序的，所以这整个过程是很快的，我们可以看出，对于一对长度为N的数组，进行合并所需要的比较次数最多为2 * N -1


归并算法核心：
1 有序队列的合并
2 递归排序

 * @author Administrator
 *
 */
public class MergeSort {
	public static int[] sort(int[] nums) {
		 if (nums.length < 2) return nums;
	        int mid = nums.length / 2;
	        int[] left1= Arrays.copyOfRange(nums, 0, mid);
	        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
	        int[] result= merge(sort(left1), sort(right));
	        return result;
	
		}
	  public static int[] merge1(int[] left, int[] right) {
	        int[] result = new int[left.length + right.length];
	        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
	            if (i >= left.length)
	                result[index] = right[j++];
	            else if (j >= right.length)
	                result[index] = left[i++];
	            else if (left[i] > right[j])
	                result[index] = right[j++];
	            else
	                result[index] = left[i++];
	        }
	        return result;
	    }
	public static int[] merge(int[] leftarray,int[] rightarray) {
		int[] result =new int[leftarray.length+rightarray.length];
		int rKey=0,leftKey=0,rightKey=0;
		while(leftKey<leftarray.length && rightKey<rightarray.length) {
		/*
			if(leftarray[leftKey] <rightarray[rightKey]) {
				result[rKey]=leftarray[leftKey] ;
				leftKey++;
			}else {
				result[rKey]=rightarray[rightKey] ;
				rightKey++;
			}
			rKey++;
			*/
			result[rKey++]=leftarray[leftKey] <rightarray[rightKey]?leftarray[leftKey++]:rightarray[rightKey++];
		}
		//一队列完成后，剩下的直接copy
		while(leftKey<leftarray.length) {
			result[rKey++]=leftarray[leftKey++] ;
//			leftKey++;
//			rKey++;
		}
		
		while(rightKey<rightarray.length) {
			result[rKey++]=rightarray[rightKey++] ;
//			rightKey++;
//			rKey++;
		}
		return result;
	}
}
