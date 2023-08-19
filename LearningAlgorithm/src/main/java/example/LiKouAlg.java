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

    //1. **双指针**对已经排序的数组去重    ============================================================
    static int removeDuplicates(int[] nums) {
        if(nums == null||nums.length==0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length - 1; right++) {
            if (nums[left] != nums[right])
                nums[++left] = nums[right];
        }
//        while (right < nums.length-1) {
//            if (nums[left] == nums[right]) {
//                right++;
//            }else{
//                nums[++left] = nums[right];
//            }
//        }
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
