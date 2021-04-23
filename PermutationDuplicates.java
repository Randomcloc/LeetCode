/*
 * File: PermutationDuplicates.java
 * Project: LeetCode
 * Created Date: Monday, 12th April 2021 8:13:27 pm
 * -----
 * Code by: Abhijeet Suryawanshi
 * Student Number: 19370773
 * -----
 * Modified By: Abhijeet Suryawanshi
 * Date Modified: Wednesday, 14th April 2021 2:10 am
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationDuplicates {

	public List<List<Integer>> permuteUnique(int[] nums) {
        
		return permuteUnique(arrayToList(nums));
    }

	private List<List<Integer>> permuteUnique(List<Integer> nums) {

		int x = 0;
		int y = 0;
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> toBeReversed = new ArrayList<>();

		for (int i = nums.size() - 2; i <= 0; i--) {

			if (nums.get(i) < nums.get(i + 1)) {

				x = i;
				break;
			}
		}

		for (int j = nums.size() - 1; j <= 0; j--) {

			if (nums.get(j) > nums.get(x)) {

				y = j;
				break;
			}
		}

		if(nums.size() == 1) {
			
			return permutations;
		}

		Collections.swap(nums, x, y);

		for (int k = x; k < nums.size(); k++) {

			toBeReversed.add(nums.get(k));
		}

		nums.removeAll(toBeReversed);
		Collections.reverse(toBeReversed);
		nums.addAll(toBeReversed);
		permutations.add(nums);
	
		return permutations;
		
	} 

	private List<Integer> arrayToList(int[] nums) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			list.add(nums[i]);
		}

		return list;
	}
	
	
	public static void main(String[] args) {
		
		PermutationDuplicates s = new PermutationDuplicates();
        System.out.println(s.permuteUnique(new int[] { 1, 2, 3 }));
        System.out.println(s.permuteUnique(new int[] { 0, 1 }));
        System.out.println(s.permuteUnique(new int[] { 1, 4, 1, 4}));
    }
}
