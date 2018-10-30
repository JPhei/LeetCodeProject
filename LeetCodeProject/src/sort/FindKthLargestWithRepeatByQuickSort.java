package sort;

import java.util.Scanner;

public class FindKthLargestWithRepeatByQuickSort {

	/**
	 * @param args
	 *            【查找第k大的元素】，数组有重复数字出现 ，数字可正可负
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String strs[] = in.nextLine().trim().split(",");
		int nums[] = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(findKthLargest(nums, 2));

	}

	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}

		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}

	public static int getKth(int k, int[] nums, int start, int end) {

		int pivot = nums[end];

		int left = start;
		int right = end;

		while (true) {

			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}

	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}

}
