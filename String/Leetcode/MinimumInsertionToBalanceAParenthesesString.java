class Solution {
    public int minInsertions(String s) {
       int n = s.length();
       int open = 0;
       int insertions = 0;
       for(int i=0; i<n; i++){
        char ch = s.charAt(i);
          if(ch == '('){
            open++;
          }else{
             if(i+1 < s.length() && s.charAt(i+1) == ')'){
                i++;
             }else{
                insertions++;
             }

             if(open > 0){
                open--;
             }else{
                insertions++;
             }
          }
       }

        insertions += (open * 2);

        return insertions;
    }
}