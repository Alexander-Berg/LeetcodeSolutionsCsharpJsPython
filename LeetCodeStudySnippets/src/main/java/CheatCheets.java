import javax.swing.tree.TreeNode;
import java.util.*;

public class CheatCheets {
    //Two pointers: one input, opposite ends
    class Twopointers {
        public int fn(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            int ans = 0;

            while (left < right) {
                // do some logic here with left and right
                if (CONDITION) {
                    left++;
                } else {
                    right--;
                }
            }

            return ans;
        }
    }

    //Two pointers: two inputs, exhaust both
    class Twopointers2 {
        public int fn(int[] arr1, int[] arr2) {
            int i = 0, j = 0, ans = 0;

            while (i < arr1.length && j < arr2.length) {
                // do some logic here
                if (CONDITION) {
                    i++;
                } else {
                    j++;
                }
            }

            while (i < arr1.length) {
                // do logic
                i++;
            }

            while (j < arr2.length) {
                // do logic
                j++;
            }

            return ans;
        }
    }

    //Sliding window
    class slidingwindow {
        public int fn(int[] arr) {
            int left = 0, ans = 0, curr = 0;

            for (int right = 0; right < arr.length; right++) {
                // do logic here to add arr[right] to curr

                while (WINDOW_CONDITION_BROKEN) {
                    // remove arr[left] from curr
                    left++;
                }

                // update ans
            }

            return ans;
        }
    }

    //Build a prefix sum
    class PrefixSum {
        public int[] fn(int[] arr) {
            int[] prefix = new int[arr.length];
            prefix[0] = arr[0];

            for (int i = 1; i < arr.length; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
            }

            return prefix;
        }
    }

    //   Efficient string building
    class Efficientstringbuilding {
        public String fn(char[] arr) {
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }

            return sb.toString();
        }
    }

    // Linked list: fast and slow pointer
    class Linkedlist {
        public int fn(LinkedList.ListNode head) {
            LinkedList.ListNode slow = head;
            LinkedList.ListNode fast = head;
            int ans = 0;

            while (fast != null && fast.next != null) {
                // do logic
                slow = slow.next;
                fast = fast.next.next;
            }

            return ans;
        }
    }

    //  Reversing a linked list
    class ReversedLinkedList {
        public LinkedList.ListNode fn(LinkedList.ListNode head) {
            LinkedList.ListNode curr = head;
            LinkedList.ListNode prev = null;
            while (curr != null) {
                LinkedList.ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            return prev;
        }
    }

    //  Find number of subarrays that fit an exact criteria
    class Find {
        public int fn(int[] arr, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            counts.put(0, 1);
            int ans = 0, curr = 0;

            for (int num : arr) {
                // do logic to change curr
                ans += counts.getOrDefault(curr - k, 0);
                counts.put(curr, counts.getOrDefault(curr, 0) + 1);
            }

            return ans;
        }
    }

    //Monotonic increasing stack
    class Monotonicincreasingstack {
        public int fn(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            int ans = 0;

            for (int num : arr) {
                // for monotonic decreasing, just flip the > to <
                while (!stack.empty() && stack.peek() > num) {
                    // do logic
                    stack.pop();
                }

                stack.push(num);
            }

            return ans;
        }
    }

    // Binary tree: DFS (recursive)
    class DfsRecursive {
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int ans = 0;
            // do logic
            dfs(root.left);
            dfs(root.right);
            return ans;
        }
    }

    //  Binary tree: DFS (iterative)
    class DfsIterative {
        public int dfs(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int ans = 0;

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                // do logic
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }

            return ans;
        }
    }

    //Binary tree: BFS
    class BFS {
        public int fn(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int ans = 0;

            while (!queue.isEmpty()) {
                int currentLength = queue.size();
                // do logic for current level

                for (int i = 0; i < currentLength; i++) {
                    TreeNode node = queue.remove();
                    // do logic
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return ans;
        }
    }

    //  Graph: DFS (recursive)
    class DFSrecursive {
        Set<Integer> seen = new HashSet<>();

        public int fn(int[][] graph) {
            seen.add(START_NODE);
            return dfs(START_NODE, graph);
        }

        public int dfs(int node, int[][] graph) {
            int ans = 0;
            // do some logic
            for (int neighbor : graph[node]) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    ans += dfs(neighbor, graph);
                }
            }

            return ans;
        }
    }

    // Graph: DFS (iterative)
    class DFSIterative {
        public int fn(int[][] graph) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> seen = new HashSet<>();
            stack.push(START_NODE);
            seen.add(START_NODE);
            int ans = 0;

            while (!stack.empty()) {
                int node = stack.pop();
                // do some logic
                for (int neighbor : graph[node]) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        stack.push(neighbor);
                    }
                }
            }

            return ans;
        }
    }

    //  Graph: BFS
    class BFSGraph {
        public int fn(int[][] graph) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            queue.add(START_NODE);
            seen.add(START_NODE);
            int ans = 0;

            while (!queue.isEmpty()) {
                int node = queue.remove();
                // do some logic
                for (int neighbor : graph[node]) {
                    if (!seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            return ans;
        }
    }

    // Find top k elements with heap
    class HeapSearch {
        public int[] fn(int[] arr, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
            for (int num : arr) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.remove();
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = heap.remove();
            }

            return ans;
        }
    }

    //Binary search
    class Binarysearch {
        public int fn(int[] arr, int target) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    // do something
                    return mid;
                }
                if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // left is the insertion point
            return left;
        }
    }

    // Binary search: duplicate elements, left-most insertion point
    class BinarySerchDuplicateElements {
        public int fn(int[] arr, int target) {
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= target) {
                    right = mid
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    // Binary search: duplicate elements, right-most insertion point
    class Binarysearchduplicateelements {
        public int fn(int[] arr, int target) {
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }

    //  Binary search: for greedy problems
    class LookingforMinimum {
        public int fn(int[] arr) {
            int left = MINIMUM_POSSIBLE_ANSWER;
            int right = MAXIMUM_POSSIBLE_ANSWER;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (check(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }

        public boolean check(int x) {
            // this function is implemented depending on the problem
            return BOOLEAN;
        }
    }

    class LookingforMaximum {
        public int fn(int[] arr) {
            int left = MINIMUM_POSSIBLE_ANSWER;
            int right = MAXIMUM_POSSIBLE_ANSWER;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (check(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return right;
        }

        public boolean check(int x) {
            // this function is implemented depending on the problem
            return BOOLEAN;
        }
    }

    //  Backtracking
    class Backtracking {
        public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
            if (BASE_CASE) {
                // modify the answer
                return 0;
            }

            int ans = 0;
            for (ITERATE_OVER_INPUT) {
                // modify the current state
                ans += backtrack(curr, OTHER_ARGUMENTS...)
                // undo the modification of the current state
            }
        }
    }

    // Dynamic programming: top-down memoization
    class TopDownMemoization {

        {
            Map<STATE, Integer> memo = new HashMap<>();

            public int fn ( int[] arr){
            return dp(STATE_FOR_WHOLE_INPUT, arr);
        }

            public int dp (STATE,int[] arr){
            if (BASE_CASE) {
                return 0;
            }

            if (memo.contains(STATE)) {
                return memo.get(STATE);
            }

            int ans = RECURRENCE_RELATION(STATE);
            memo.put(STATE, ans);
            return ans;
        }
        }
    }
   // Build a trie

   // note: using a class is only necessary if you want to store data at each node.
// otherwise, you can implement a trie using only hash maps.
   class TrieNode {
       // you can store data at nodes if you wish
       int data;
       Map<Character, TrieNode> children;
       TrieNode() {
           this.children = new HashMap<>();
       }
   }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }

                curr = curr.children.get(c);
            }

            // at this point, you have a full word at curr
            // you can perform more logic here to give curr an attribute if you want
        }

        return root;
    }

    // The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    public class HammingDistance {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
   // Given a characters array tasks, representing the tasks a CPU needs to do
    public class TaskSheduler {
        public int leastInterval(char[] tasks, int n) {
            int[] counter = new int[26];
            int max = 0;
            int maxCount = 0;
            for(char task : tasks) {
                counter[task - 'A']++;
                if(max == counter[task - 'A']) {
                    maxCount++;
                }
                else if(max < counter[task - 'A']) {
                    max = counter[task - 'A'];
                    maxCount = 1;
                }
            }

            int partCount = max - 1;
            int partLength = n - (maxCount - 1);
            int emptySlots = partCount * partLength;
            int availableTasks = tasks.length - max * maxCount;
            int idles = Math.max(0, emptySlots - availableTasks);

            return tasks.length + idles;
        }
    }
}



