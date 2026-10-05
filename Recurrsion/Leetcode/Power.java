public class Power{
     public double myPow(double x, int n) {
       if(n == 0) return 1;
       if(x == 0) return 0;
       if(x == 1) return 1;

       if(n < 1){
        return 1 / (x * myPow(x , -(n+1)));
       }

       double y = myPow(x , n/2);
       if(n % 2 == 0){
        return  y * y;
       }else{
        return x * y * y;
       }
    }
}
