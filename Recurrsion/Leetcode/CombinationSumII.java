import java.util.*;

class Solution {

    private void getAllCombinations(int[] candidates, int target, int i,  List<Integer>combin,List<List<Integer>>ans){
        if(target == 0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(i == candidates.length || target < 0){
            return ;
        }

        combin.add(candidates[i]);
        getAllCombinations(candidates,target-candidates[i] , i+1,combin,ans);

        combin.remove(combin.size() - 1);
        int idx = i+1;
        while(idx < candidates.length && candidates[idx] == candidates[idx-1]){
            idx++;
        }

        getAllCombinations(candidates,target,idx,combin,ans);


    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>combin = new ArrayList<>();
        
        getAllCombinations(candidates,target,0,combin,ans);

        return ans;
    }
}