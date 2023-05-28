import org.w3c.dom.Node;

import java.util.*;

public class Queue {
    public void add(int x) {
    }

    public int size() {

        return 0;
    }

    public int remove() {
        return 0;
    }

    public int peek() {
        return 0;
    }

    public int poll() {
        return 0;
    }

    public void offer(int neighbor) {
    }
// "static void main" must be defined in a public class.

    class MyQueue {
        // store elements
        private List<Integer> data;
        // a pointer to indicate the start position
        private int p_start;

        public void MyQueue() {
            data = new ArrayList<Integer>();
            p_start = 0;
        }

        /**
         * Insert an element into the queue. Return true if the operation is successful.
         */
        public boolean enQueue(int x) {
            data.add(x);
            return true;
        }

        ;

        /**
         * Delete an element from the queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty() == true) {
                return false;
            }
            p_start++;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            return data.get(p_start);
        }

        /**
         * Checks whether the queue is empty or not.
         */
        public boolean isEmpty() {
            return p_start >= data.size();
        }
    }

    ;

     class Queue2 {
        public void main(String[] args) {
            Queue q = new Queue();
            q.enQueue(5);
            q.enQueue(3);
            if (q.isEmpty() == false) {
                System.out.println(q.Front());
            }
            q.deQueue();
            if (q.isEmpty() == false) {
                System.out.println(q.Front());
            }
            q.deQueue();
            if (q.isEmpty() == false) {
                System.out.println(q.Front());
            }
        }
    }

    private int Front() {
        return 0;
    }

    private void deQueue() {
    }

    boolean isEmpty() {
        return false;
    }

    private void enQueue(int i) {
    }

    class MyCircularQueue {
        private int[] arr;
        private int rear, front;

        public MyCircularQueue(int N) {
            this.arr = new int[N];
            this.front = -1;
            this.rear = -1;
        }

        public boolean enQueue(int value) {
            if (front == -1 && rear == -1) {
                rear = front = 0;
                arr[rear] = value;
                return true;
            } else if ((rear + 1) % arr.length == front) {
                return false;
            } else {
                rear = (rear + 1) % arr.length;
                arr[rear] = value;
                return true;
            }
        }

        public boolean deQueue() {
            if (rear == -1 && front == -1) {
                return false;
            } else if (front == rear) {
                front = rear = -1;
                return true;
            } else {
                front = (front + 1) % arr.length;
                return true;
            }
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[rear];
        }

        public boolean isEmpty() {
            return (front == -1 && rear == -1);
        }

        public boolean isFull() {
            return (rear + 1) % arr.length == front;
        }
    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
// "static void main" must be defined in a public class.
    class Queuelibrary {
        public static void main(String[] args) {
            // 1. Initialize a queue.
            java.util.Queue<Integer> q = (java.util.Queue<Integer>) new LinkedList();
            // 2. Get the first element - return null if queue is empty.
            System.out.println("The first element is: " + q.peek());
            // 3. Push new element.
            q.offer(5);
            q.offer(13);
            q.offer(8);
            q.offer(6);
            // 4. Pop an element.
            q.poll();
            // 5. Get the first element.
            System.out.println("The first element is: " + q.peek());
            // 7. Get the size of the queue.
            System.out.println("The size is: " + q.size());
        }
    }

    class BFS1 {
        /**
         * Return the length of the shortest path between root and target node.
         */
        int BFS(Node root, Node target) {
            java.util.Queue<Node> queue;  // store all nodes which are waiting to be processed
            int step = 0;       // number of steps neeeded from root to current node
            // initialize
            // add root to queue;
            // BFS
            // while (queue is not empty){
            // iterate the nodes which are already in the queue
            // int size = queue.size();
            // for (int i = 0; i < size; ++i) {
            //     Node cur = the first node in queue;
            //    return step if cur is target;
            //    for (Node next : the neighbors of cur){
            //        add next to queue;
            //     }
            //    remove the first node from queue;
            //  }
            // step = step + 1;
            //}
            // return -1;          // there is no path from root to target
            //  }
            // }
            class BFS2 {
                /**
                 * Return the length of the shortest path between root and target node.
                 */
                void BFS(Node root, Node target) {
                    java.util.Queue<Node> queue;  // store all nodes which are waiting to be processed
                    Set<Node> visited;  // store all the nodes that we've visited
                    int step = 0;       // number of steps neeeded from root to current node
                    // initialize
                    //  add root to queue;
                    //  add root to visited;
                    // BFS
                    //while (queue is not empty) {
                    // iterate the nodes which are already in the queue
                    // int size = queue.size();
                    // for (int i = 0; i < size; ++i) {
                    //        Node cur = the first node in queue;
                    //      return step if cur is target;
                    //   for (Node next : the neighbors of cur) {
                    //        if (next is not in visited) {
                    //           add next to queue;
                    //          add next to visited;
                    //      }
                    //   }
                    //    remove the first node from queue;
                    //   }
                    //    step = step + 1;
                    //   }
                    //return -1;          // there is no path from root to target
                    //  }
//}

                }
            }
            return step;
        }
    }

    class BFS3 {
        public int openLock(String[] deadends, String target) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < deadends.length; i++) {
                set.add(deadends[i]);
            }

            Set<String> visited = new HashSet<>();

            java.util.Queue<String> q = (java.util.Queue<String>) new LinkedList();
            q.add("0000");
            visited.add("0000");
            int steps = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    String current = q.poll();

                    if (current.equals(target)) return steps;

                    StringBuilder sb = new StringBuilder(current);
                    for (int i = 0; i < 4; i++) {
                        char c = sb.charAt(i);
                        String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                        String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);

                        if (!visited.contains(s1) && !set.contains(current)) {
                            visited.add(s1);
                            q.offer(s1);
                        }
                        if (!visited.contains(s2) && !set.contains(current)) {
                            visited.add(s2);
                            q.offer(s2);
                        }
                    }
                }
                steps++;
            }

            return -1;
        }
    }
}







