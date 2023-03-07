package example;

/**
 * @author liusc
 * 计数排序
 *
 * 学习理解：
 */
public class JiShuAlg {
    public static void main(String[] args) {
        int[] a = {9,3,12,23,14,16,223};
        sort(a,0,a.length-1);
        print(a);
    }
    static void sort(int[] arr,int leftBound,int rightBound){
    }


    static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
