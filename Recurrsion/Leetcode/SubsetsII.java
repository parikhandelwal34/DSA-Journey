import java.util.*;

class Solution {

    private void getAllSubsets(int[] nums, int i,List<Integer>ans,  List<List<Integer>>allSubsets){
        if(i == nums.length){
            allSubsets.add(new ArrayList<>(ans));
            return;
        }

        ans.add(nums[i]);
        getAllSubsets(nums,i+1,ans,allSubsets);
        ans.remove(ans.size() - 1);

        int idx = i+1;
        while(idx < nums.length && nums[idx] == nums[idx-1]){
            idx++;
        }

        getAllSubsets(nums,idx,ans,allSubsets);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) { 
        Arrays.sort(nums);   //TC : O(2^n * n)
        List<List<Integer>>allSubsets = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();

        getAllSubsets(nums,0,ans,allSubsets);

        return allSubsets;
    }
}