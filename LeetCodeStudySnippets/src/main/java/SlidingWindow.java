public class SlidingWindow {
    public int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
    public int findLength(String s) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right)== '0') {
                curr++;
            }

            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) {
                return 0;
            }

            int ans = 0;
            int left = 0;
            int curr = 1;

            for (int right = 0; right < nums.length; right++) {
                curr *= nums[right];
                while (curr >= k) {
                    curr /= nums[left];
                    left++;
                }
                ans += right - left + 1;
            }

            return ans;
        }
    }
    public int findBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
