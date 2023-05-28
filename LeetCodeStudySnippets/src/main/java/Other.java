import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Other {
    class RemoveInvalidParentheses {
        public List<String> removeInvalidParentheses(String s) {
            List<String> output = new ArrayList<>();
            removeHelper(s, output, 0, 0, '(', ')');
            return output;
        }

        public void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen) {
            int numOpenParen = 0, numClosedParen = 0;
            for (int i = iStart; i < s.length(); i++) {
                if (s.charAt(i) == openParen) numOpenParen++;
                if (s.charAt(i) == closedParen) numClosedParen++;
                if (numClosedParen > numOpenParen) { // We have an extra closed paren we need to remove
                    for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                        if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                            // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                            removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                    return; // Stop here. The recursive calls handle the rest of the string.
                }
            }
            // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
            String reversed = new StringBuilder(s).reverse().toString();
            if (openParen == '(')
                removeHelper(reversed, output, 0, 0, ')','(');
            else
                output.add(reversed);
        }
    }

    class BestTimeBuySellStockwithCooldown{
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1) return 0;

            int b0 = -prices[0], b1 = b0;
            int s0 = 0, s1 = 0, s2 = 0;

            for(int i = 1; i < prices.length; i++) {
                b0 = Math.max(b1, s2 - prices[i]);
                s0 = Math.max(s1, b1 + prices[i]);
                b1 = b0; s2 = s1; s1 = s0;
            }
            return s0;
        }
    }

    class BurstBalloons {
        public int maxCoins(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            return maxCoins(nums, 0, nums.length - 1, dp);
        }

        public int maxCoins(int[] nums, int start, int end, int[][] dp) {
            if (start > end) {
                return 0;
            }
            if (dp[start][end] != 0) {
                return dp[start][end];
            }
            int max = nums[start];
            for (int i = start; i <= end; i++) {
                int val = maxCoins(nums, start, i - 1, dp) +
                        get(nums, i) * get(nums, start - 1) * get(nums, end + 1) +
                        maxCoins(nums, i + 1, end, dp);

                max = Math.max(max, val);
            }
            dp[start][end] = max;
            return max;
        }

        public int get(int[] nums, int i) {
            if (i == -1 || i == nums.length) {
                return 1;
            }
            return nums[i];
        }
    }

    public class  QueueReconstructionHeight {
        public int[][] reconstructQueue(int[][] people) {
            //pick up the tallest guy first
            //when insert the next tall guy, just need to insert him into kth position
            //repeat until all people are inserted into list
            Arrays.sort(people,new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
                }
            });
            List<int[]> res = (List<int[]>) new LinkedList();
            for(int[] cur : people){
                res.add(cur[1],cur);
            }
            return res.toArray(new int[people.length][]);
        }
    }


}
