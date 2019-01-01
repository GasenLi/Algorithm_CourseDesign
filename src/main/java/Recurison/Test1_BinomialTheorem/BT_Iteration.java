package Recurison.Test1_BinomialTheorem;

public class BT_Iteration {

    public static void main(String[] args) {
        int n,k;

        for(int i=1000;i<=50000;i+=2000){
            k = i;
            n = i + 10;

            //Test
            long startTime = System.currentTimeMillis();
            BT_Iteration(n, k);
            long endtime = System.currentTimeMillis();

            long runTime = endtime - startTime;
            System.out.println("当n为"+ i +"运行时间：" + runTime);
        }
    }

    public static int BT_Iteration(int n, int k) {
        int[][] memo = new int[n+1][k+1];

        for (int down = 1; down <= n; down++) {
            for (int up = 1; up <= k; up++) {
                if (down == up) {
                    memo[down][up] = 1;
                }else if (up <= 1) {
                    memo[down][up] = down;
                }else {
                    memo[down][up] = memo[down-1][up-1] + memo[down-1][up];
                }
            }
        }

        return memo[n][k];
    }
}
