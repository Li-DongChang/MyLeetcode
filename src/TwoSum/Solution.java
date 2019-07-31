package com.qdu.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidcha
 * @createDate ：2019年7月31日
 */
public class Solution_Convert {
	// 利用hashMap，对于nums数组中的每个元素nums[i],
	// 计算所需complement=target-nums[i],将结果放入map中，直接从map中找符合要求的数
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
