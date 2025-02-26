/**
 * 977. 有序数组的平方
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */

//AC time:2025-02-24 22:38:48


/**
 * 本题思路
 * 采用双指针法
 * left和right指针，新建一个数组，对比原数组大小，从后面开始赋值，最后返回新建数组
 */
public class LeetCode_977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int number = right;
        int[] new_nums = new int[right+1];
        while (left - right < 1) {
            if (Math.abs(nums[right]) >= Math.abs(nums[left])) {
                new_nums[number] = nums[right] * nums[right];
                right--;
            } else {
                new_nums[number] = nums[left] * nums[left];
                left++;
            }
            number--;
        }
        return new_nums;
    }
}