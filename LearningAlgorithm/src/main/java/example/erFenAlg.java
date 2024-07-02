package example;

/**
 * @Author liusc
 * @Date 2024/6/26 21:13
 * @Desc 二分算法
 * @Version 1.0
 */
public class erFenAlg {

    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            //检查中间元素
            if (arr[mid] == target) {
                return mid; //找到目标值，返回索引
            }

            //如果目标值大于中间元素，则在右半部分查找
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                //如果目标值小于中间元素，则在左半部分查找
                right = mid - 1;
            }
        }
        // 未找到目标值，返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int[] sortArray = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch(sortArray, target);

        if (result == -1) {
            System.out.println("元素未在数组中找到！");
        } else {
            System.out.println("元素在数组中的索引位置：" + result);
        }
    }

}
