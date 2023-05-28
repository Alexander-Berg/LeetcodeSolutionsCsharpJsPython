import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {
    class BinarySearch1 {
        public int search(int[] nums, int target) {
            // Set the left and right boundaries
            int left = 0, right = nums.length - 1;

            // Under this condition
            while (left <= right) {
                // Get the middle index and the middle value.
                int mid = left + (right - left) / 2;

                // Case 1, return the middle index.
                if (nums[mid] == target) {
                    return mid;
                }
                // Case 2, discard the smaller half.
                else if (nums[mid] < target) {
                    left = mid + 1;
                }
                // Case 3, discard the larger half.
                else {
                    right = mid - 1;
                }
            }

            // If we finish the search without finding target, return -1.
            return -1;
        }
    }

    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }


    class SqrtXBinarySearch {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            int start = 1, end = x;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (mid <= x / mid && (mid + 1) > x / (mid + 1))// Found the result
                    return mid;
                else if (mid > x / mid)// Keep checking the left part
                    end = mid;
                else
                    start = mid + 1;// Keep checking the right part
            }
            return start;
        }
    }
class BinarySearch2 {
    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left == right
        if (nums[left] == target) return left;
        return -1;
    }
}

// The isBadVersion API is defined in the parent class VersionControl.
    public class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
    public class FirstBadVersion extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1, right = n, ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
                if (isBadVersion(mid)) {
                    ans = mid; // record mid as current answer
                    right = mid - 1; // try to find smaller version in the left side
                } else {
                    left = mid + 1; // try to find in the right side
                }
            }
            return ans;
        }
    }


    class FindPeakElement {
        public int findPeakElement(int[] nums) {
            int lo=0,hi = nums.length-1;
            while(lo<hi){
                int mid = lo+(hi-lo)/2;
                if(nums[mid] < nums[mid+1])
                    lo = mid+1;
                else
                    hi = mid;

            }
            return lo;
        }
    }
    class BinarySearch3 {
        int binarySearc3(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return -1;

            int left = 0, right = nums.length - 1;
            while (left + 1 < right) {
                // Prevent (left + right) overflow
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            // Post-processing:
            // End Condition: left + 1 == right
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            return -1;
        }
    }

    class FindKClosestElements{
        public List<Integer> findClosestElements(int[] A, int k, int x) {
            int left = 0, right = A.length - k;
            while (left < right) {
                int mid = (left + right) / 2;
                if (x - A[mid] > A[mid + k] - x)
                    left = mid + 1;
                else
                    right = mid;
            }
            return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
        }
    }
    class ValidPerfectSquare {
        public boolean isPerfectSquare(int num) {
            long left = 1, right = num;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * mid == num) return true; // check if mid is perfect square
                if (mid * mid < num) { // mid is small -> go right to increase mid
                    left = mid + 1;
                } else {
                    right = mid - 1; // mid is large -> to left to decrease mid
                }
            }
            return false;
        }
    }

    class FindSmallestLetterGreaterThanTarget{
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (target >= letters[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            return letters[left % letters.length];
        }
    }

    class FindMinimumRotatedSortedArray {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length-1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] > nums[r]){
                    l = mid + 1;
                } else {
                    r--;  //nums[mid]=nums[r] no idea, but we can eliminate nums[r];
                }
            }
            return nums[l];
        }
    }

    class FindKSmallestPairDistance {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int WIDTH = 2 * nums[nums.length - 1];

            //multiplicity[i] = number of nums[j] == nums[i] (j < i)
            int[] multiplicity = new int[nums.length];
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == nums[i-1]) {
                    multiplicity[i] = 1 + multiplicity[i - 1];
                }
            }

            //prefix[v] = number of values <= v
            int[] prefix = new int[WIDTH];
            int left = 0;
            for (int i = 0; i < WIDTH; ++i) {
                while (left < nums.length && nums[left] == i) left++;
                prefix[i] = left;
            }

            int lo = 0;
            int hi = nums[nums.length - 1] - nums[0];
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                int count = 0;
                for (int i = 0; i < nums.length; ++i) {
                    count += prefix[nums[i] + mi] - prefix[nums[i]] + multiplicity[i];
                }
                //count = number of pairs with distance <= mi
                if (count >= k) hi = mi;
                else lo = mi + 1;
            }
            return lo;
        }
    }

    class SplitArrayLargestSum {
        int[] nums;
        public int splitArray(int[] nums, int m) {
            this.nums = nums;
            int low = 0, high = 0, min = Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++){
                low = Math.max(low, nums[i]);
                high += nums[i];
            }
            while(low <= high) {
                int mid = (low + high) / 2;
                if(required_no_of_chunks(mid, m)){
                    min = Math.min(min, mid);
                    high = mid - 1;
                }
                else low = mid + 1;
            }
            return min;
        }

        private boolean required_no_of_chunks(int mid, int m){
            int chunks = 0, i=0;
            while(i < nums.length){
                int val = 0;
                while(i < nums.length && nums[i] + val <= mid) val += nums[i++];
                chunks++;
            }
            return chunks <= m;
        }
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
              this.right = right;
          }
      }

    class DeleteNodeinBST {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){
                return null;
            }
            if(key < root.val){
                root.left = deleteNode(root.left, key);
            }else if(key > root.val){
                root.right = deleteNode(root.right, key);
            }else{
                if(root.left == null){
                    return root.right;
                }else if(root.right == null){
                    return root.left;
                }

                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        }

        private TreeNode findMin(TreeNode node){
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
    }

}
