/*
 * File: Permutations.java
 * Project: LeetCode
 * Created Date: Monday, 12th April 2021 6:58:11 pm
 * -----
 * Code by: Abhijeet Suryawanshi
 * Student Number: 19370773
 * -----
 * Modified By: Abhijeet Suryawanshi
 * Date Modified: Monday, 12th April 2021 8:13 pm
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
        Permutations s = new Permutations();
        System.out.println(s.permute(new int[] { 1, 2, 3 }));
        System.out.println(s.permute(new int[] { 0, 1 }));
        System.out.println(s.permute(new int[] { 1, 4, 1, 4}));
    }


	public List<List<Integer>> permute(int[] nums) {

		return permute(arrayToList(nums));
	}

	private List<List<Integer>> permute(List<Integer> nums) {

		List<List<Integer>> permutations = new ArrayList<>();

		if (nums.size() == 1) {
			permutations.add(nums);
			return permutations;
		}

		for (int i = 0; i < nums.size(); i++) {

			List<Integer> subList = new ArrayList<>(nums);
			subList.remove(i);

			for (List<Integer> sublist : permute(subList)) {

				
				sublist.add(0, nums.get(i));
				permutations.add(sublist);
			}
		}

		return permutations;
	}

	private List<Integer> arrayToList(int[] nums) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			list.add(nums[i]);
		}

		return list;
	}
}