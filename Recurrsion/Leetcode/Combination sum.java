import java.util.*;
class Solution {

    void allCombinations(int[] candidates, int idx,int target, List<Integer>combin ,List<List<Integer>>ans   ){

        if(target == 0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(idx == candidates.length || target < 0 ){
            return ;
        }
        
         combin.add(candidates[idx]);
        //allCombinations(candidates,idx+1,target-candidates[idx] , combin,ans);  // iss condition ki need nhi h
        allCombinations(candidates,idx,target-candidates[idx] , combin,ans);
        combin.remove(combin.size() -1);
         allCombinations(candidates,idx+1,target , combin,ans);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>>ans = new ArrayList<>();
       List<Integer>combin = new ArrayList<>();
         allCombinations(candidates,0,target,combin , ans);

         return ans;
    }
}