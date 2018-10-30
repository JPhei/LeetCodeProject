package sort;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FindKthLargestWithRepeatByHeap {

	/**
	 * @param args
	 *            �����ҵ�k���Ԫ�ء����������ظ����ֳ��� �����ֿ����ɸ�
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
		// ʹ��sizeΪ3��С����ʵ��
		System.out.println(findKthLargest(nums, 3));

	}

	public static int findKthLargest(int[] nums, int k) {
		// ��СΪk��С����,�ȸ���������ɽ���С���ѣ�С���Ѵ�С��󲻳���3
		// ������ϣ�����ڵ㼴Ϊ����
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
