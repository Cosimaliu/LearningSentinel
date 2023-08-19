package example.mashibing;

import java.util.Date;
import java.util.Scanner;

/**
 * @Author liusc
 * @Date 2023/4/11 23:09
 * @Version 1.0
 */
public class FrogJumpsStepsAlg {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入需要跳到第   几个台阶：");
        int n = scanner.nextInt();
        Long fStartTime = new Date().getTime();
        System.out.println(f(n));
        Long fEndTime = new Date().getTime();
        System.out.println("f耗时:"+(fEndTime-fStartTime));
        Long f1StartTime = new Date().getTime();
        System.out.println(f1(n));
        Long f1EndTime= new Date().getTime();
        System.out.println("f1耗时:"+(f1EndTime-f1StartTime));

    }

    /**
     * 青蛙跳台阶问题（一只青蛙[一次跳一阶，一次跳两阶]，有多少种跳法可以跳到第n阶台阶上，）
     */

    //递归方法实现
    public static int f(int k){
        if (k <= 2) {
            return k;
        }
        return f(k - 1) + f(k - 2);
    }

    //动态规划实现 Dynamic Programming, Dp
    public static int f1(int n){
        if (n <= 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        // 动态规划一定要寻找初始值，假设不设置dp[2],打印出的值就是错的
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
