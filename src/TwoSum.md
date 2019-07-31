######算法思想
利用双重循环去遍历数组，直到找到二者之和等于target的两个数，时间复杂度为O(n^2)
```
class Solution {
		    public int[] twoSum(int[] nums, int target) {
		        int[] result=new int[2];
		        int len = nums.length;
		        for(int i=0;i<len;i++)
		            for(int j=i+1;j<len;j++)
		                if(nums[i]+nums[j]==target){
		                    result[0]=i;
		                    result[1]=j;
		                }
		                    return result;
		    }
		}
```
