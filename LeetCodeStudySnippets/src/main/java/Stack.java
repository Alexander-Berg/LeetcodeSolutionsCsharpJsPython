import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Stack {

    // "static void main" must be defined in a public class.
    class MyStack {
        private List<Integer> data;               // store elements

        public MyStack() {
            data = new ArrayList<>();
        }

        /**
         * Insert an element into the stack.
         */
        public void push(int x) {
            data.add(x);
        }

        /**
         * Checks whether the queue is empty or not.
         */
        public boolean isEmpty() {
            return data.isEmpty();
        }

        /**
         * Get the top item from the queue.
         */
        public int top() {
            return data.get(data.size() - 1);
        }

        /**
         * Delete an element from the queue. Return true if the operation is successful.
         */
        public int pop() {
            if (isEmpty()) {

            }
            data.remove(data.size() - 1);

            return 0;
        }
    }

    ;

    public class Main {
        public void main(String[] args) {
            MyStack s = new MyStack();
            s.push(1);
            s.push(2);
            s.push(3);
            for (int i = 0; i < 4; ++i) {
                if (!s.isEmpty()) {
                    System.out.println(s.top());
                }
                System.out.println(s.pop());
            }
        }
    }

    // "static void main" must be defined in a public class.
    public class Stack2 {
        public static void main(String[] args) {
            // 1. Initialize a stack.
            Stack s = new Stack();
            // 2. Push new element.
            s.push(5);
            s.push(13);
            s.push(8);
            s.push(6);
            // 3. Check if stack is empty.
            if (s.empty() == true) {
                System.out.println("Stack is empty!");
                return;
            }
            // 4. Pop an element.
            s.pop();
            // 5. Get the top element.
            System.out.println("The top element is: " + s.peek());
            // 6. Get the size of the stack.
            System.out.println("The size is: " + s.size());
        }
    }

    int pop() {
        return 0;
    }

    private String size() {
        return null;
    }

    private String peek() {
        return null;
    }

    boolean empty() {
        return false;
    }

    private void push(int i) {
    }

    class DailyTemperaturesStack {
        public int[] dailyTemperatures(int[] temperatures) {

            int[] arr = new int[temperatures.length];

            ArrayDeque<int[]> st = new ArrayDeque<>();

            int i = 0, j = temperatures.length - 1;

            while (j >= 0) {

                if (st.size() == 0) {
                    arr[i++] = 0;
                } else if (st.size() > 0 && st.peek()[0] > temperatures[j]) {
                    arr[i++] = 1;
                } else if (st.size() > 0 && st.peek()[0] <= temperatures[j]) {
                    while (st.size() > 0 && st.peek()[0] <= temperatures[j]) {
                        st.pop();

                    }
                    if (st.size() == 0) {
                        arr[i++] = 0;
                    } else {
                        arr[i++] = st.peek()[1] - j;
                    }
                }
                st.push(new int[]{temperatures[j], j});
                j--;
            }


            int[] ans = new int[temperatures.length];
            int k = 0;
            for (i = arr.length - 1; i >= 0; i--) {
                ans[k++] = arr[i];
            }
            return ans;
        }
    }

    class DFSTemplate {
    /*
     * Return true if there is a path from cur to target.

    boolean DFS(Node cur, Node target, Set<Node> visited) {
        return true if cur is target;
        for (next:
             each neighbor of cur){
            if (next is not in visited){
                add next to visited;
                return true if DFS(next, target, visited) == true;
            }
        }
        return false;
         */

    }

    public class TargetSum {
        int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            calculate(nums, 0, 0, S);
            return count;
        }

        public void calculate(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S) {
                    count++;
                }
            } else {
                calculate(nums, i + 1, sum + nums[i], S);
                calculate(nums, i + 1, sum - nums[i], S);
            }
        }
    }

    class DFS2 {
        /*
         * Return true if there is a path from cur to target.

        boolean DFS(int root, int target) {
            Set<Node> visited;
            Stack<Node> stack;
            add root to stack;
            while (stack is not empty){
                Node cur = the top element in stack;
                remove the cur from the stack;
                return true if cur is target;
                for (Node next : the neighbors of cur){
                    if (next is not in visited){
                        add next to visited;
                        add next to stack;
                    }
                }
            }
            return false;
        }
        */

    }
    class ImplementStackUsingQueus {
        Stack stack=new Stack();
        Queue q1;
        Queue q2;
        int size = 0;

        public void MyStack() {
            this.q1= new Queue();
            this.q2= new Queue();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            int pop=q1.remove();
            Queue temp=q1;
            q1=q2;
            q2=temp;
            return pop;
        }

        public int top() {
            while(q1.size()>1){
                q2.add(q1.remove());
            }
            int top=q1.peek();
            q2.add(q1.remove());
            Queue temp=q1;
            q1=q2;
            q2=temp;
            return top;

        }

        public boolean empty() {
            if(q1.isEmpty()) return true;
            return false;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack countStack = new Stack();
        Stack resStack = new Stack();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(Integer.parseInt(res));
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder ((CharSequence) resStack.pop());
                int repeatTimes = countStack.pop();
             //   for (int i = 0; i < repeatTimes; i++) {
            //        temp.append(res);
            //    }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
    class FloodFill {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int color = image[sr][sc];
            if (color != newColor) dfs(image, sr, sc, color, newColor);
            return image;
        }
        public void dfs(int[][] image, int r, int c, int color, int newColor) {
            if (image[r][c] == color) {
                image[r][c] = newColor;
                if (r >= 1) dfs(image, r-1, c, color, newColor);
                if (c >= 1) dfs(image, r, c-1, color, newColor);
                if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
                if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
            }
        }
    }

    class Matrix {
        public int[][] updateMatrix(int[][] matrix) {
            int rowLast = matrix.length - 1;
            int colLast = matrix[0].length - 1;

            int[] row = matrix[0];
            int[] prevRow;
            if (row[0] == 1)
                row[0] = rowLast + colLast + 2;
            for (int c = 1; c <= colLast; c++)
                if (row[c] == 1)
                    row[c] = row[c - 1] + 1;
            for (int r = 1; r <= rowLast; r++) {
                prevRow = row;
                row = matrix[r];
                if (row[0] == 1)
                    row[0] = prevRow[0] + 1;
                for (int c = 1; c <= colLast; c++)
                    if (row[c] == 1)
                        row[c] = Math.min(row[c - 1], prevRow[c]) + 1;
            }
            row = matrix[rowLast];
            for (int c = colLast - 1; c >= 0; c--)
                if (row[c] > 1)
                    row[c] = Math.min(row[c], row[c + 1] + 1);
            for (int r = rowLast - 1; r >= 0; r--) {
                prevRow = row;
                row = matrix[r];
                if (row[colLast] > 1)
                    row[colLast] = Math.min(row[colLast], prevRow[colLast] + 1);
                for (int c = colLast - 1; c >= 0; c--)
                    if (row[c] > 1)
                        row[c] = Math.min(row[c], Math.min(row[c + 1], prevRow[c]) + 1);
            }
            return matrix;
        }
    }

    class KeyRooms {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] seen = new boolean[rooms.size()];
            seen[0] = true;
            Stack stack = new Stack();
            stack.push(0);

            //At the beginning, we have a todo list "stack" of keys to use.
            //'seen' represents at some point we have entered this room.
            while (!stack.isEmpty()) { // While we have keys...
                int node = stack.pop(); // Get the next key 'node'
                for (int nei: rooms.get(node)) // For every key in room # 'node'...
                    if (!seen[nei]) { // ...that hasn't been used yet
                        seen[nei] = true; // mark that we've entered the room
                        stack.push(nei); // add the key to the todo list
                    }
            }

            for (boolean v: seen)  // if any room hasn't been visited, return false
                if (!v) return false;
            return true;
        }
    }

    private boolean isEmpty() {
        return false;
    }
}







