package sort;

import java.util.Scanner;

public class SearchMode {

	/**
	 * @param args
	 *            查找数组众数，数组中数字出现次数超过n/2的数为众数，且假设数组非空且一定存在众数；n为数组长度
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner in = new Scanner(System.in);
		// String strs[] = in.nextLine().trim().split(",");
		// int nums[] = new int[strs.length];
		// for (int i = 0; i < strs.length; i++) {
		// nums[i] = Integer.parseInt(strs[i]);
		// }
		// // System.out.println(find_k(3,nums,0,strs.length-1));
		// find_k(4, nums, 0, strs.length - 1);

		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String strs[] = s.substring(1, s.length() - 1).split(",");
		int nums[] = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		// 快排实现，当排好一个枢纽值时，判断下标是否等于strs.length / 2，是则就是该值，结束返回输出即可；
		// 根据上面众数的定义，可知数组中间的数一定是众数；
		find_k(strs.length / 2, nums, 0, strs.length - 1);

	}

	public static int partition(int[] arr, int low, int high) {
		int temp = arr[low];
		while (low < high) {
			while (arr[high] <= temp && high > low)
				--high;
			arr[low] = arr[high];
			while (arr[low] >= temp && low < high)
				++low;
			arr[high] = arr[low];
		}
		arr[high] = temp;
		return high;
	}

	public static void find_k(int k, int[] arr, int low, int high) {
		int temp = partition(arr, low, high);
		if (temp == k) {
			System.out.print(arr[temp]);
			return;
		} else if (temp > k - 1) {
			find_k(k, arr, low, temp - 1);
		} else {
			find_k(k - temp, arr, temp + 1, high);
		}
	}

}
