package sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargestWithRepeatByHeap {

	/**
	 * @param args
	 *            【查找第k大的元素】，数组有重复数字出现 ，数字可正可负
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String strs[] = s.substring(1, s.length() - 1).split(",");
		int nums[] = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		// 使用size为3的小根堆实现
		System.out.println(findKthLargest(nums, 3));

	}

	public static int findKthLargest(int[] nums, int k) {
		// 大小为k的小根堆,比根大的数都可进入小根堆，小根堆大小最大不超过3
		// 遍历完毕，则根节点即为所求
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : nums) {
			q.offer(i);

			if (q.size() > k) {
				q.poll();
			}
		}

		return q.peek();
	}

}
