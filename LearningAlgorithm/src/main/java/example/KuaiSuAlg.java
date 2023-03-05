package example;

/**
 * @author liusc
 * 快速排序
 *
 * 学习理解：也可以称为轴排序，以一个数为轴，区分大于它和小于它的数,（以只剩一个数，不能轴排序）为BaseCase
 */
public class KuaiSuAlg {
    public static void main(String[] args) {
        int[] a = {9,3,12,23,14,16,223};
        sort(a,0,a.length-1);
        print(a);
    }
    //实现无限向下递归，以left = right为baseCase;
    static void sort(int[] arr,int leftBound,int rightBound){
        if(leftBound >= rightBound) return;

        int mid = partition(arr,leftBound,rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid,rightBound);
    }

    // 以轴区分“小于它”和“大于它”的数
    static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, rightBound);
        return left;
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
