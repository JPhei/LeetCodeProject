package sort;

import java.util.Scanner;

public class ArrayJumpMovement {

	/**
	 * @param args
	 *            【 数组移动跳跃 】 从下标为0开始遍历，每次移动当前值的位数，负数向前移动，正数向后移动；
	 *            当数组越界则跳出返回true，否则返回false； 测试用例： [1,2,3,4,5] 返回true [1,-3]
	 *            返回true [1] 返回true [1,1,1,2,-1,1,-3] 返回false
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine().trim();
		String strs[] = s.substring(1, s.length() - 1).split(",");
		int nums[] = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}

		solution(nums);

	}

	private static void solution(int[] nums) {
		// TODO Auto-generated method stub
		if (nums.length <= 0 || nums == null)
			return;
		// 标记变量，标记每个位置的数是否已经遍历过
		// 若出现重复遍历过同一个位置，则说明出现了循环，则永远也不会跳出
		boolean[] flags = new boolean[nums.length];
		int i = 0;
		flags[i] = true;

		while (i < nums.length && i >= 0) {
			int temp = nums[i];
			i = i + temp;

			if (i >= nums.length || i < 0) {
				System.out.println(true);// 只要数组越界即可跳出循环
				return;
			}
			if (!flags[i]) {
				flags[i] = true;
			} else if (flags[i]) {
				System.out.println(false);
				return;
			}
		}
	}

}
