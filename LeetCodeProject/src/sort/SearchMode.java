package sort;

import java.util.Scanner;

public class SearchMode {

	/**
	 * @param args
	 *            �����������������������ֳ��ִ�������n/2����Ϊ�������Ҽ�������ǿ���һ������������nΪ���鳤��
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
		// ����ʵ�֣����ź�һ����Ŧֵʱ���ж��±��Ƿ����strs.length / 2��������Ǹ�ֵ����������������ɣ�
		// �������������Ķ��壬��֪�����м����һ����������
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
