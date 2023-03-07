package example;

/**
 * @Author liusc
 * @Date 2023/3/7
 * @Version 1.0
 * @Description liKou算法
 */
public class LiKouAlg {

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4};
        int left = removeDuplicates(arr);
        print(arr,left);
    }

    //1. **双指针**对已经排序的数组去重  ============================================================
    static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length-1) {
            if (nums[left] == nums[right]) {
                right++;
            }else{
                left++;
                nums[left] = nums[right];
            }
        }
        return left;
    }

    static void print(int[] arr,int left){
        for (int i=0;i<=left;i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    //2.   ============================================================



}
