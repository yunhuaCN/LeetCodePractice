/**
 * 209. 长度最小的子数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */


//AC time:2025-02-26 22:16:02

public class LeetCode_209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        //使用滑动窗口法
        int begin = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int minLength = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLength = (end - begin + 1);
                result = result < minLength ? result : minLength;
                sum -= nums[begin++];
            }
        }
        if (result == Integer.MAX_VALUE) {
            result = 0;
        }
        return result;
    }
}
