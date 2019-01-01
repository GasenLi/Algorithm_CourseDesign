package Recurison.Test1_BinomialTheorem;

public class BT_Memo {
    private static int[][] memo;

    public static void main(String[] args) {
        int n,k;

        for(int i=1000;i<=50000;i+=2000){
            k = i;
            n = i + 10;

            memo = new int[n+1][k+1];
            //Test
            long startTime = System.currentTimeMillis();
            BT_Memo(n, k);
            long endtime = System.currentTimeMillis();

            long runTime = endtime - startTime;
            System.out.println("当n为"+ i +"运行时间：" + runTime);
        }
    }

    public static int BT_Memo(int n, int k){
       if(n==k){
            memo[n][k] = 1;
        }else if(k<=1){
            memo[n][k] = n;
        }else {
            memo[n][k] = (memo[n-1][k-1] > 0 ? memo[n-1][k-1] : BT_Memo(n-1, k-1)) + (memo[n-1][k] > 0 ? memo[n-1][k] : BT_Memo(n-1, k));
        }

        return memo[n][k];
    }
}
