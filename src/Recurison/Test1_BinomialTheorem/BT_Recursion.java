package Recurison.Test1_BinomialTheorem;

public class BT_Recursion {


    public static void main(String[] args) {
        System.out.println(BT_Recursion(6,3));
    }

    public static int BT_Recursion(int n, int k){
        if(n==k){
            return 1;
        }else if(k<=1){
            return n;
        }

        return (BT_Recursion(n-1, k-1)+BT_Recursion(n-1, k));
    }
}
