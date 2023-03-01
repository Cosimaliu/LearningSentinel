package example;

/**
 * @author liusc
 * 插入排序
 *
 * 学习理解：对于基本有序的数组最好用【稳定】
 * 例如：扑克抓拍，每拿一个牌，都做一次排序
 */
public class InsertAlg {
    public static void main(String[] args) {
        int[] a = {9,3,1,4,5,2,6,8,7};
        sort(a);
        print(a);
    }
    static void sort(int[] a){
        for (int i=1;i<a.length;i++) {
//            state(a,i);
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    swap(a,j,j-1);
                }
            }
        }
    }
    static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//    static void state(int[] a,int j){
//        int temp = a[j];
//        for(int k=j-1;k>=0;k--){
//            if(temp<a[k]){
//                a[k+1] = a[k];
//                a[k] = temp;
//            }else{
//                break;
//            }
//        }
//    }

    static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
