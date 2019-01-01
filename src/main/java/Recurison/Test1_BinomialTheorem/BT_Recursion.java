package Recurison.Test1_BinomialTheorem;

public class BT_Recursion {


    public static void main(String[] args) {
        int k,n;

        for(int i=10;i<=40;i+=5){
            k = i;
            n = i + 10;

            //Test
            long startTime = System.currentTimeMillis();
            BT_Recursion(n, k);
            long endtime = System.currentTimeMillis();

            long runTime = endtime - startTime;
            System.out.println("当n为"+ i +"运行时间：" + runTime);
        }

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
