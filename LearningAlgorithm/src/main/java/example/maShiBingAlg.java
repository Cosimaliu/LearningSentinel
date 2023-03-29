package example;

import java.util.LinkedList;

/**
 * @Author liusc
 * @Date 2023/3/26 15:08
 * @Version 1.0
 */
public class maShiBingAlg {
    public static void main(String[] args) {
        int[] a = new int[]{4,3,5,4,3,1,9,2};
        int[] res = getMaxWindow(a,3);
        for (int re : res) {
            System.out.println(re);
        }
    }

    /**
     * 题目一：
     * 假设一个固定大小为W的窗口，依次划过arr,返回每一次滑出状况的最大值
     * 例如，arr = [4,3,5,4,3,3,6,7] , w = 3
     * 返回：[5,5,5,4,6,7]
     */
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 其中放的是位置，arr[位置]
        LinkedList<Integer> qMax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index= 0;
        // L...R
        //     i
        // 当前让i -> [i] 进窗口，i就是r
        for (int R = 0; R < arr.length; R++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                qMax.pollLast();
            }
            qMax.addLast(R);
            // 如果窗口没有形成w的长度之前，不弹出数字
            if (qMax.peekFirst() == R - w) {
                qMax.pollFirst();
            }
            if (R >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;

    }

    /**
     * 题目二：
     * 给定一个整型组arr,和一个整数num某个arr中的子数组sub,如果想达标，必须满足：
     * sub中最大值-sub中最小值 <= num,返回arr中达标子数组的数量
     */
    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qMin = new LinkedList<>();
        LinkedList<Integer> qMax = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while(L<arr.length){// L是开头位置，尝试每一个开头
            // 如果此时窗口的开头是L,下面的while工作：R向右扩到违规为止
            while (R <arr.length){// R是最后一个达标位置的再下一个
                while (!qMin.isEmpty()&&arr[qMin.peekFirst()] >= arr[R]){
                    qMin.pollLast();
                }
                qMin.addLast(R);
                // R -> arr[R]
                while(!qMax.isEmpty()&& arr[qMax.peekFirst()] <= arr[R]){
                    qMax.pollLast();
                }
                qMax.addLast(R);
                if(arr[qMax.getFirst()] - arr[qMin.getFirst()] > num){
                    break;
                }
                R++;
            }
            // R是最后一个达标位置的再下一个，第一个违规的位置
            res += R -L;
            if(qMin.peekFirst() ==L){
                qMin.pollFirst();
            }
            if(qMax.peekFirst() == L){
                qMax.pollFirst();
            }
            L++;
        }
        return res;
    }


}
