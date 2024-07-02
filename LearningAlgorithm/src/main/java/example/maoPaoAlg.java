package example;

/**
 * @Author liusc
 * @Date 2024/6/26 20:47
 * @Desc 冒泡算法
 * @Version 1.0
 */
public class maoPaoAlg {

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapper = false;

        //外层循环要冒泡的次数
        for (int i1 = 0; i1 < n; i1++) {
            //内循环进行两两比较并交换
            for (int j = 0; j < n - 1 - i1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //交换相邻元素
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapper = true;
                }
            }
            if(!swapper){
                break;
            }
        }
    }

    public static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("未排序数组：");
        printArr(array);

        // 调用冒泡排序方法
        bubbleSort(array);

        System.out.println("排序后数组：");
        printArr(array);
    }
}
