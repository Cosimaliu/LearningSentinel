package example;

/**
 * @author liusc
 * 希尔排序
 *
 * 学习理解：插入排序的基础上加上间隔swap,减少数据的无效交换提高效率
 */
public class XrAlg {
    public static void main(String[] args) {
        int[] a = {9,3,1,4,5,2,6,8,7};
        sort(a);
        print(a);
    }
    static void sort(int[] a){
        // 每次间隔缩小一倍,直到间隔为2【v1】
        // 通过Knuth序列计算gap【v2】
        int h = 1;
        while (h <= a.length / 3){
            h = h*3+1;
        }
        for(int gap = h;gap>0;gap = (gap-1)/3){
            for (int i=gap;i<a.length;i++) {
                for(int j=i;j>gap-1;j-=gap){
                    if(a[j]<a[j-gap]){
                        swap(a,j,j-gap);
                    }
                }
            }
        }
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
