package example;

/**
 * @author liusc
 * 归并排序
 *
 * 学习理解：以数组分到最小（只剩两个数）为BaseCase,的递归运算
 */
public class GuiBingAlg {
    public static void main(String[] args) {
        int[] a = {9,3,11,22,33,14,2,36,48};
        sort(a,0,a.length-1);
        print(a);
    }
    //实现无限向下递归，以left = right为baseCase;
    static void sort(int[] a,int left,int right){
        if(left == right) return;
        //分成两半
        int mid = left +(right-left)/2;//不直接除以2，是为了防止出现越界问题
        //左边排序
        sort(a,left,mid);
        //右边排序
        sort(a,mid+1,right);
        merge(a,left,mid+1,right);
    }
    //实现将连个已经排好序的数组整合成一个
    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound){
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound-leftPtr+1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //排序完，剩余的数也要set到temp中
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        for (int m = 0;m<temp.length;m++) arr[leftPtr+m] = temp[m];

    }

    static void print(int[] arr){
        for (int j : arr) {
            System.out.println(j);
            //测试
        }
    }
}
