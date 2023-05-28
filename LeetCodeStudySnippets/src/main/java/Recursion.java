import java.lang.reflect.Type;
import java.util.*;
import java.util.Arrays;

public class Recursion {

    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }



     // Definition for a binary tree node.
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

    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {

            // Check if the root node is null or if the root value matches the input value
            if(root == null || root.val == val) {
                // If so, return the root node (which may be null)
                return root;
            }

            // If the input value is less than the root value, search the left subtree recursively
            if(val < root.val) {
                return searchBST(root.left, val);
            }
            // Otherwise, search the right subtree recursively
            else {
                return searchBST(root.right, val);
            }
        }
    }


    public class DuplicateCalculationRecursion{

        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

        private int fib(int N) {
            if (cache.containsKey(N)) {
                return cache.get(N);
            }
            int result;
            if (N < 2) {
                result = N;
            } else {
                result = fib(N-1) + fib(N-2);
            }
            // keep the result in cache.
            cache.put(N, result);
            return result;
        }
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public class Memoization {

        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

        private int fib(int N) {
            if (cache.containsKey(N)) {
                return cache.get(N);
            }
            int result;
            if (N < 2) {
                result = N;
            } else {
                result = fib(N-1) + fib(N-2);
            }
            // keep the result in cache.
            cache.put(N, result);
            return result;
        }
    }

    class FinonacciNumber {
        public int fib(int n) {
            if(n==0)
                return 0;
            int prev=1,prev2=0;
            for(int i=1;i<n;i++)
            {
                int curr = prev+prev2;
                prev2 = prev;
                prev = curr;
            }
            return prev;
        }
    }

    public class TailRecursion {

        private static int helper_non_tail_recursion(int start, int [] ls) {
            if (start >= ls.length) {
                return 0;
            }
            // not a tail recursion because it does some computation after the recursive call returned.
            return ls[start] + helper_non_tail_recursion(start+1, ls);
        }

        public static int sum_non_tail_recursion(int [] ls) {
            if (ls == null || ls.length == 0) {
                return 0;
            }
            return helper_non_tail_recursion(0, ls);
        }

        //---------------------------------------------

        private static int helper_tail_recursion(int start, int [] ls, int acc) {
            if (start >= ls.length) {
                return acc;
            }
            // this is a tail recursion because the final instruction is the recursive call.
            return helper_tail_recursion(start+1, ls, acc+ls[start]);
        }

        public static int sum_tail_recursion(int [] ls) {
            if (ls == null || ls.length == 0) {
                return 0;
            }
            return helper_tail_recursion(0, ls, 0);
        }
    }
    class KSymbolGrammar{
        public int solve(int i, int j,int k,int curr)
        {
            if(i==j)
                return curr;
            int m = (i+j)/2;
            if(m<k)
                return solve(m+1,j,k,1-curr);
            return solve(i,m,k,curr);
        }
        public int kthGrammar(int n, int k) {
            int range = (int)Math.pow(2,n-1);
            return solve(0,range-1,k-1,0);
        }
    }


      // Definition for a binary tree node.
      public class TreeNodeC {
          int val;
          TreeNodeC left;
          TreeNodeC right;
          TreeNodeC() {}
          TreeNodeC(int val) { this.val = val; }
          TreeNodeC(int val, TreeNodeC left, TreeNodeC right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
      }

    class UniqueBinarySearchTrees {
        Map<Pair<Integer, Integer>, List<TreeNodeC>> memo = new HashMap<>();

        private List<TreeNodeC> generateTrees(int l, int r) {
            if (l > r)
                return new ArrayList<>() {{add(null);}};

            var list = new ArrayList<TreeNodeC>();
            var pair = new Pair(l, r);

            if (memo.containsKey(pair))
                return memo.get(pair);

            for (var i=l; i<=r; i++)
                for (var left : generateTrees(l, i-1))
                    for (var right : generateTrees(i+1, r))
                        list.add(new TreeNodeC(i, left, right));

            memo.put(pair, list);
            return list;
        }

        public List<TreeNodeC> generateTrees(int n) {
            return generateTrees(1, n);
        }
    }


    public class topdownmergesortalgorithm{

        public int [] merge_sort(int [] input) {
            if (input.length <= 1) {
                return input;
            }
            int pivot = input.length / 2;
            int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
            int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
            return merge(left_list, right_list);
        }

        public int [] merge(int [] left_list, int [] right_list) {
            int [] ret = new int[left_list.length + right_list.length];
            int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

            while (left_cursor < left_list.length &&
                    right_cursor < right_list.length) {
                if (left_list[left_cursor] < right_list[right_cursor]) {
                    ret[ret_cursor++] = left_list[left_cursor++];
                } else {
                    ret[ret_cursor++] = right_list[right_cursor++];
                }
            }
            // append what is remain the above lists
            while (left_cursor < left_list.length) {
                ret[ret_cursor++] = left_list[left_cursor++];
            }
            while (right_cursor < right_list.length) {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
            return ret;
        }
    }

    class SortArray {
        // Function to merge two sub-arrays in sorted order.
        private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
            // Calculate the start and sizes of two halves.
            int start1 = left;
            int start2 = mid + 1;
            int n1 = mid - left + 1;
            int n2 = right - mid;

            // Copy elements of both halves into a temporary array.
            for (int i = 0; i < n1; i++) {
                tempArr[start1 + i] = arr[start1 + i];
            }
            for (int i = 0; i < n2; i++) {
                tempArr[start2 + i] = arr[start2 + i];
            }

            // Merge the sub-arrays 'in tempArray' back into the original array 'arr' in sorted order.
            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                    arr[k] = tempArr[start1 + i];
                    i += 1;
                } else {
                    arr[k] = tempArr[start2 + j];
                    j += 1;
                }
                k += 1;
            }

            // Copy remaining elements
            while (i < n1) {
                arr[k] = tempArr[start1 + i];
                i += 1;
                k += 1;
            }
            while (j < n2) {
                arr[k] = tempArr[start2 + j];
                j += 1;
                k += 1;
            }
        }

        // Recursive function to sort an array using merge sort
        private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
            if (left >= right) {
                return;
            }
            int mid = (left + right) / 2;
            // Sort first and second halves recursively.
            mergeSort(arr, left, mid, tempArr);
            mergeSort(arr, mid + 1, right, tempArr);
            // Merge the sorted halves.
            merge(arr, left, mid, right, tempArr);
        }

        public int[] sortArray(int[] nums) {
            int[] temporaryArray = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, temporaryArray);
            return nums;
        }
    }
    public class QuickSort {

        public void quickSort(int [] lst) {
            /* Sorts an array in the ascending order in O(n log n) time */
            int n = lst.length;
            qSort(lst, 0, n - 1);
        }

        private void qSort(int [] lst, int lo, int hi) {
            if (lo < hi) {
                int p = partition(lst, lo, hi);
                qSort(lst, lo, p - 1);
                qSort(lst, p + 1, hi);
            }
        }

        private int partition(int [] lst, int lo, int hi) {
    /*
      Picks the last element hi as a pivot
      and returns the index of pivot value in the sorted array */
            int pivot = lst[hi];
            int i = lo;
            for (int j = lo; j < hi; ++j) {
                if (lst[j] < pivot) {
                    int tmp = lst[i];
                    lst[i] = lst[j];
                    lst[j] = tmp;
                    i++;
                }
            }
            int tmp = lst[i];
            lst[i] = lst[hi];
            lst[hi] = tmp;
            return i;
        }

    }

    class BacktrackingSudokuSolver {
        public void solveSudoku(char[][] board) {
            // Start solving sudoku from the first cell
            solve(board, 0, 0);
        }

        private boolean solve(char[][] board, int row, int col) {
            // Base case: If row is equal to board length, entire board has been filled
            if (row == board.length) {
                return true;
            }

            // Move to next row when current row is fully filled
            if (col == board[0].length) {
                return solve(board, row + 1, 0);
            }

            // Skip cells that are already filled
            if (board[row][col] != '.') {
                return solve(board, row, col + 1);
            }

            // Try different numbers in current cell
            for (char num = '1'; num <= '9'; num++) {
                if (isValidPlacement(board, row, col, num)) {
                    board[row][col] = num; // Fill current cell with valid number

                    // Move to next cell
                    if (solve(board, row, col + 1)) {
                        return true;
                    }

                    // Backtrack to previous state if solution not found
                    board[row][col] = '.';
                }
            }

            // No valid solution found
            return false;
        }

        private boolean isValidPlacement(char[][] board, int row, int col, char num) {
            // Check if num is already in the same row, column or 3x3 subgrid
            for (int i = 0; i < board.length; i++) {
                // Check row
                if (board[i][col] == num) {
                    return false;
                }

                // Check column
                if (board[row][i] == num) {
                    return false;
                }

                // Check 3x3 subgrid
                int subgridRow = 3 * (row / 3) + i / 3; // Calculate row index of subgrid
                int subgridCol = 3 * (col / 3) + i % 3; // Calculate column index of subgrid

                if (board[subgridRow][subgridCol] == num) {
                    return false;
                }
            }

            // Placement is valid
            return true;
        }
    }
    class RecursionToIteration {
        public boolean check(TreeNode p, TreeNode q) {
            // p and q are null
            if (p == null && q == null) return true;
            // one of p and q is null
            if (q == null || p == null) return false;
            if (p.val != q.val) return false;
            return true;
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (!check(p, q)) return false;
            // init deques
            ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
            ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
            deqP.addLast(p);
            deqQ.addLast(q);

            while (!deqP.isEmpty()) {
                p = deqP.removeFirst();
                q = deqQ.removeFirst();

                if (!check(p, q)) return false;
                if (p != null) {
                    // in Java nulls are not allowed in Deque
                    if (!check(p.left, q.left)) return false;
                    if (p.left != null) {
                        deqP.addLast(p.left);
                        deqQ.addLast(q.left);
                    }
                    if (!check(p.right, q.right)) return false;
                    if (p.right != null) {
                        deqP.addLast(p.right);
                        deqQ.addLast(q.right);
                    }
                }
            }
            return true;
        }
    }

}



