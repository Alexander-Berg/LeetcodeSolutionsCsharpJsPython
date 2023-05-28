import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayString {
    // "static void main" must be defined in a public class.
    public class MainArray {
        public static void main(String[] args) {
            // 1. Initialize
            int[] a0 = new int[5];
            int[] a1 = {1, 2, 3};
            // 2. Get Length
            System.out.println("The size of a1 is: " + a1.length);
            // 3. Access Element
            System.out.println("The first element is: " + a1[0]);
            // 4. Iterate all Elements
            System.out.print("[Version 1] The contents of a1 are:");
            for (int i = 0; i < a1.length; ++i) {
                System.out.print(" " + a1[i]);
            }
            System.out.println();
            System.out.print("[Version 2] The contents of a1 are:");
            for (int item: a1) {
                System.out.print(" " + item);
            }
            System.out.println();
            // 5. Modify Element
            a1[0] = 4;
            // 6. Sort
            Arrays.sort(a1);
        }
    }

    // "static void main" must be defined in a public class.
    public class DynamicArray {
        public static void main(String[] args) {
            // 1. initialize
            List<Integer> v0 = new ArrayList<>();
            List<Integer> v1;                           // v1 == null
            // 2. cast an array to a vector
            Integer[] a = {0, 1, 2, 3, 4};
            v1 = new ArrayList<>(Arrays.asList(a));
            // 3. make a copy
            List<Integer> v2 = v1;                      // another reference to v1
            List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
            // 4. get length
            System.out.println("The size of v1 is: " + v1.size());
            // 5. access element
            System.out.println("The first element in v1 is: " + v1.get(0));
            // 6. iterate the vector
            System.out.print("[Version 1] The contents of v1 are:");
            for (int i = 0; i < v1.size(); ++i) {
                System.out.print(" " + v1.get(i));
            }
            System.out.println();
            System.out.print("[Version 2] The contents of v1 are:");
            for (int item : v1) {
                System.out.print(" " + item);
            }
            System.out.println();
            // 7. modify element
            v2.set(0, 5);       // modify v2 will actually modify v1
            System.out.println("The first element in v1 is: " + v1.get(0));
            v3.set(0, -1);
            System.out.println("The first element in v1 is: " + v1.get(0));
            // 8. sort
            Collections.sort(v1);
            // 9. add new element at the end of the vector
            v1.add(-1);
            v1.add(1, 6);
            // 10. delete the last element
            v1.remove(v1.size() - 1);
        }
    }
    class FindPivotIndex {
        public int pivotIndex(int[] nums) {
            int sum = 0, leftsum = 0;
            for (int x: nums) sum += x;
            for (int i = 0; i < nums.length; ++i) {
                if (leftsum == sum - leftsum - nums[i]) return i;
                leftsum += nums[i];
            }
            return -1;
        }
    }
    class LargestNumberAtLeastTwiceOthers {
        public int dominantIndex(int[] nums) {
            int maxnum = nums[0];
            int maxindex = 0;
            for(int i = 0 ; i < nums.length; i++) {
                if (nums[i] > maxnum) {
                    maxnum = nums[i];
                    maxindex = i;
                }
            }
            for(int i = 0 ; i < nums.length; i++) {
                if (nums[i] * 2 > maxnum && i != maxindex) {
                    return -1;
                }
            }
            return maxindex;
        }
    }

    // "static void main" must be defined in a public class.
    public class TwoDArray {
        private static void printArray(int[][] a) {
            for (int i = 0; i < a.length; ++i) {
                System.out.println(a[i]);
            }
            for (int i = 0; i < a.length; ++i) {
                for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        public static void main(String[] args) {
            System.out.println("Example I:");
            int[][] a = new int[2][5];
            printArray(a);
            System.out.println("Example II:");
            int[][] b = new int[2][];
            printArray(b);
            System.out.println("Example III:");
            b[0] = new int[3];
            b[1] = new int[5];
            printArray(b);
        }
    }

    class DiagonalTraverse {
        public int[] findDiagonalOrder(int[][] matrix) {

            // Check for empty matrices
            if (matrix == null || matrix.length == 0) {
                return new int[0];
            }

            // Variables to track the size of the matrix
            int N = matrix.length;
            int M = matrix[0].length;

            // The two arrays as explained in the algorithm
            int[] result = new int[N*M];
            int k = 0;
            ArrayList<Integer> intermediate = new ArrayList<Integer>();

            // We have to go over all the elements in the first
            // row and the last column to cover all possible diagonals
            for (int d = 0; d < N + M - 1; d++) {

                // Clear the intermediate array every time we start
                // to process another diagonal
                intermediate.clear();

                // We need to figure out the "head" of this diagonal
                // The elements in the first row and the last column
                // are the respective heads.
                int r = d < M ? 0 : d - M + 1;
                int c = d < M ? d : M - 1;

                // Iterate until one of the indices goes out of scope
                // Take note of the index math to go down the diagonal
                while (r < N && c > -1) {

                    intermediate.add(matrix[r][c]);
                    ++r;
                    --c;
                }

                // Reverse even numbered diagonals. The
                // article says we have to reverse odd
                // numbered articles but here, the numbering
                // is starting from 0 :P
                if (d % 2 == 0) {
                    Collections.reverse(intermediate);
                }

                for (int i = 0; i < intermediate.size(); i++) {
                    result[k++] = intermediate.get(i);
                }
            }
            return result;
        }
    }

    // "static void main" must be defined in a public class.
    public class CompareFunction {
        public static void main(String[] args) {
            // initialize
            String s1 = "Hello World";
            System.out.println("s1 is \"" + s1 + "\"");
            String s2 = s1;
            System.out.println("s2 is another reference to s1.");
            String s3 = new String(s1);
            System.out.println("s3 is a copy of s1.");
            // compare using '=='
            System.out.println("Compared by '==':");
            // true since string is immutable and s1 is binded to "Hello World"
            System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
            // true since s1 and s2 is the reference of the same object
            System.out.println("s1 and s2: " + (s1 == s2));
            // false since s3 is refered to another new object
            System.out.println("s1 and s3: " + (s1 == s3));
            // compare using 'equals'
            System.out.println("Compared by 'equals':");
            System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
            System.out.println("s1 and s2: " + s1.equals(s2));
            System.out.println("s1 and s3: " + s1.equals(s3));
            // compare using 'compareTo'
            System.out.println("Compared by 'compareTo':");
            System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
            System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
            System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
        }
    }
    // "static void main" must be defined in a public class.
    public class TestingModificationOperator {
        public static void main(String[] args) {
            String s1 = "Hello World";
           // s1[5] = ',';
            System.out.println(s1);
        }
    }

    // "static void main" must be defined in a public class.
    public class StringExtra {
        public static void main(String[] args) {
            String s1 = "Hello World";
            // 1. concatenate
            s1 += "!";
            System.out.println(s1);
            // 2. find
            System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
            System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
            // 3. get substring
            System.out.println(s1.substring(6, 11));
        }
    }

    // "static void main" must be defined in a public class.
    public class StringConcontenation {
        public static void main(String[] args) {
            String s = "";
            int n = 10000;
            for (int i = 0; i < n; i++) {
                s += "hello";
            }
        }
    }

    // "static void main" must be defined in a public class.
    public class CharArray {
        public static void main(String[] args) {
            String s = "Hello World";
            char[] str = s.toCharArray();
            str[5] = ',';
            System.out.println(str);
        }
    }
    // "static void main" must be defined in a public class.
    public class StringBuilder {
        public void main(String[] args) {
            int n = 10000;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append("hello");
            }
            String s = str.toString();
        }

        private void append(String hello) {
        }
    }

    public static void reverse(int[] v, int N) {
        int i = 0;
        int j = N - 1;
        while (i < j) {
            swap(v, i, j);  // this is a self-defined function
            i++;
            j--;
        }
    }

    private static void swap(int[] v, int i, int j) {
    }

    class ArrayPartition {
        public int arrayPairSum(int[] nums) {
            // Sort the list in ascending order
            Arrays.sort(nums);
            // Initialize sum to zero
            int maxSum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                // Add every element at even positions (0-indexed)
                maxSum += nums[i];
            }
            return maxSum;
        }
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    class PascalsTriangleRowIndex  {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (rowIndex < 0)
                return result;
            result.add(1);
            for (int i = 1; i <= rowIndex; i++)
            {
                for (int j = result.size() - 2; j >= 0; j--)
                {
                    result.set(j + 1, result.get(j) + result.get(j + 1));
                }
                result.add(1);
            }
            return result;
        }
    }

    class ReverseWordsInString {

        public String reverseWords(String s) {
            StringBuilder result = new StringBuilder();
            int lastSpaceIndex = -1;
            for (int strIndex = 0; strIndex < s.length(); strIndex++) {
                if ((strIndex == s.length() - 1) || s.charAt(strIndex) == ' ') {
                    int reverseStrIndex = (strIndex == s.length() - 1) ? strIndex : strIndex - 1;
                    for (; reverseStrIndex > lastSpaceIndex; reverseStrIndex--) {
                        result.append(String.valueOf(s.charAt(reverseStrIndex)));
                    }
                    if (strIndex != s.length() - 1) {
                        result.append(" ");
                    }
                    lastSpaceIndex = strIndex;
                }
            }
            return new String(String.valueOf(result));
        }
    }

}


