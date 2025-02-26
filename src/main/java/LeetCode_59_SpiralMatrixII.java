/**
 * 59. 螺旋矩阵 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */

//AC time:2025-02-26 23:09:05

public class LeetCode_59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] vec = new int[n][n];
        int loopCount = 0;
        int col = 0, row = 0;
        int count = 1;
        //循环
        if (n == 1) {
            vec[0][0] = 1;
            return vec;
        }
        while (true) {

            /**
             *  主要思路就是模拟循环过程
             *  1.最上行从左到右
             *  2.最右列从上到下
             *  3.最下行从右到左
             *  4.最左列从下到上
             */

            //1
            for (col = loopCount; col < n - loopCount; col++) {
                vec[loopCount][col] = count++;
            }
            //2
            for (row = loopCount + 1; row < n - loopCount; row++) {
                vec[row][n - loopCount - 1] = count++;
            }
            //3
            for (col = n - loopCount - 2; col >= loopCount; col--) {
                vec[n - loopCount - 1][col] = count++;
            }
            //4
            for (row = n - loopCount - 2; row >= loopCount + 1; row--) {
                vec[row][loopCount] = count++;
            }
            //考虑奇数和偶数的情况
            if (count == n*n) {
                vec[n/2][n/2] = count;
                break;
            } else if (count - 1 == n*n) {
                break;
            }
            loopCount++;

        }
        return vec;

    }

}
