import java.util.*;

class Solution {

    private void allCombinations(int start, int k , int target,  List<Integer>combin, List<List<Integer>>ans){
        if(combin.size() == k && target == 0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(combin.size() > k || target < 0){
            return;
        }

        for(int i=start; i<=9; i++){
            combin.add(i);
            allCombinations(i+1,k,target - i, combin, ans);
            combin.remove(combin.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>combin = new ArrayList<>();

        allCombinations(1 , k , n, combin, ans);

        return ans;
    }
}