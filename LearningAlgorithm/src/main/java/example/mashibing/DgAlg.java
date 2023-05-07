package example.mashibing;

/**
 * @Author liusc  递归
 * @Date 2023/4/11 23:09
 * @Version 1.0
 */
public class DgAlg {

    public static void main(String[] args) {
        int x=6,y=8,k=10;
        System.out.println(ways1(x,y,k));
        System.out.println(ways2(x,y,k));
    }

    /**
     * 题目：
     *  在棋盘上，"马"限制走k步，走到指定的坐标【x,y】，有多少种路径
     *  棋盘大小：0<x<9,0<y<8
     * 结题思路：
     *  找出走到一个点最近一步的最大可能性（"马"有八种）
     *
     * 结题方法一：暴力求解
     */
    public static int ways1(int x,int y,int k){
        return f(x,y,k);
    }
    // 马从(0,0)出发，有k步要走，并且一定要走完，最终来到x,y位置的方法数是多少
    public static int f(int x, int y, int k) {
        if (k == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        //有步数要走，x,y也是棋盘上的位置
        return f(x + 2, y - 1, k - 1)
                + f(x + 2, y + 1, k - 1)
                + f(x + 1, y + 2, k - 1)
                + f(x - 1, y + 2, k - 1)
                + f(x - 2, y + 1, k - 1)
                + f(x - 2, y - 1, k - 1)
                + f(x - 1, y - 2, k - 1)
                + f(x + 1, y - 2, k - 1);
    }

    /**
     * 结题方法二：动态规划求解
     * @return
     */
    public static int ways2(int x, int y, int k) {
        int[][][] dp = new int[10][9][k + 1];//0~k
        dp[0][0][0] = 1; //dp[..][..][0]=0
        for (int level = 1; level <= k; level++) {
            //level层，x,y
            for (int i = 0; i < 10; i++) { // x可能性
                for (int j = 0; j < 9; j++) { // y的可能性
                    dp[i][j][level] =
                            getValue(dp, i + 2, j - 1, level - 1)
                                    + getValue(dp, i + 2, j + 1, level - 1)
                                    + getValue(dp, i + 1, j + 2, level - 1)
                                    + getValue(dp, i - 1, j + 2, level - 1)
                                    + getValue(dp, i - 2, j + 1, level - 1)
                                    + getValue(dp, i - 2, j - 1, level - 1)
                                    + getValue(dp, i - 1, j - 2, level - 1)
                                    + getValue(dp, i + 1, j - 2, level - 1);
                }
            }
        }
        return dp[x][y][k];
    }

    public static int getValue(int[][][] dp, int x, int y, int k) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][k];
    }

}
