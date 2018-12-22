package Recurison.Test1_BinomialTheorem;

public class BT_Iteration {

    public static void main(String[] args) {
        int n=6, k=3;

        System.out.println(BT_Iteration(n,k));
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
