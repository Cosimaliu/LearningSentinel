package example.mashibing;

/**
 * @Author liusc
 * @Date 2023/5/28 16:36
 * @Desc Bfprt算法：（了解KMP算法需要）
 *         针对典型问题：查询字符串【A串中是否包含B串，包含返回A串中包含的第一个值的下标，不包含返回-1】
 *         暴力解:O(N*M)
 *         使用bfprt算法：O(N)
 * @Version 1.0
 */
public class BfprtAlg {

    public static void main(String[] args) {
        int k = getIndexOf("abaaaac", "   ac");
        System.out.println("k的值是：" + k);
    }

    public static int getIndexOf(String s, String m) {
        if (null == s || null == m || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0;//str中当前比对到的位置
        int y = 0;//match中当前比对到的位置
        int[] next = getNextArray(match);
        while (x < str.length && y < match.length) { // next[i] match中i之前的字符串match[0....i-1]
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0  也是同样的判断效果
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }

    // 复杂度 M  O(M)
    private static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // cn代表，cn位置的字符，是当前和i-1位置比较的字符
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
