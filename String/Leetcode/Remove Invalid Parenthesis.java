class Solution {

    private void backtrack(String s, int index, int leftRemove, int rightRemove, int balance, StringBuilder path, Set<String>ans){
        if(index == s.length()){
            if(leftRemove == 0 && rightRemove == 0 && balance == 0){
                ans.add(path.toString());
            }
            return;
        }

        char ch = s.charAt(index);
        if(ch == '(' && leftRemove > 0){
            backtrack(s,index+1,leftRemove-1,rightRemove,balance,path,ans);
        }

        if(ch == ')' && rightRemove > 0){
            backtrack(s,index+1,leftRemove,rightRemove-1,balance,path,ans);
        }

        path.append(ch);
        if(ch == '('){
            backtrack(s,index+1,leftRemove,rightRemove,balance+1,path,ans);
        }else if(ch == ')' && balance > 0){
            backtrack(s,index+1,leftRemove,rightRemove,balance-1,path,ans);
        }else if(ch != ')'){
            backtrack(s, index + 1, leftRemove, rightRemove, balance, path, ans);
        }

        path.deleteCharAt(path.length() - 1);
    }
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        Set<String>ans = new HashSet<>();
        
        int left = 0;
        int right = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                if(left > 0){
                    left--;
                }else{
                    right++;
                }
            }
        }
        backtrack(s,0,left,right,0, new StringBuilder() ,ans);
        return new ArrayList<>(ans);
    } 
}