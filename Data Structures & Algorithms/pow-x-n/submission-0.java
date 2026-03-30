class Solution {
    public double myPow(double x, int n) {
        double product = 1D;
        if(n == 0) return 1.0;
        for(int i = 0; i < Math.abs(n); i++){
                product *= x;
        }
        if(n > 0){
            return product;
        }else{
            return 1D/product;
        }
    }
}
