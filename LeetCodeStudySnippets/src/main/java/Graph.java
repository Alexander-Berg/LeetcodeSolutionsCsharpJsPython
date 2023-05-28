import java.util.*;

public class Graph {
    class NumberOfProvinces {
        public void dfs(int node, int[][] isConnected, boolean[] visit) {
            visit[node] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[node][i] == 1 && !visit[i]) {
                    dfs(i, isConnected, visit);
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int numberOfComponents = 0;
            boolean[] visit = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    numberOfComponents++;
                    dfs(i, isConnected, visit);
                }
            }

            return numberOfComponents;
        }
    }
    class SmallestStringWithSwaps {
        private int[] parent;
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            if (s == null || s.length() == 0) {
                return null;
            }
            parent = new int[s.length()];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            for (List<Integer> pair : pairs) {
                union(pair.get(0), pair.get(1));
            }

            Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
            char[] sChar = s.toCharArray();
            for (int i = 0; i < sChar.length; i++) {
                int root = find(i);
                map.putIfAbsent(root, new PriorityQueue<>());
                map.get(root).offer(sChar[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sChar.length; i++) {
                sb.append(map.get(find(i)).poll());
            }
            return sb.toString();
        }
        private int find(int index) {
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }
        private void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent < bParent) {
                parent[bParent] = aParent;
            } else {
                parent[aParent] = bParent;
            }
        }
    }
    class EvaluateDivision {
        private  Map<String, Map<String, Double>> makeGraph(List<List<String>> e, double[] values){
            // build a graph
            // like a -> b = values[i]
            // and b -> a  = 1.0 / values[i];
            Map<String, Map<String, Double>> graph = new HashMap<>();
            String u, v;

            for(int i = 0; i < e.size(); i++){
                u = e.get(i).get(0);
                v = e.get(i).get(1);

                graph.putIfAbsent(u, new HashMap<>());
                graph.get(u).put(v, values[i]);

                graph.putIfAbsent(v, new HashMap<>());
                graph.get(v).put(u, 1/values[i]);

            }
            return graph;
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = makeGraph(equations, values);

            double []ans = new double[queries.size()];

            // check for every Querie
            // store it in ans array;
            for(int i = 0; i < queries.size(); i++){
                ans[i] = dfs(queries.get(i).get(0) , queries.get(i).get(1) , new HashSet<>(), graph);
            }
            return ans;
        }

        public double dfs(String src, String dest, Set<String> visited, Map<String, Map<String, Double>> graph){
            // check the terminated Case
            // if string is not present in graph return -1.0;
            // like [a, e] or [x, x] :)
            if(graph.containsKey(src ) == false)
                return -1.0;

            // simply say check src and dest are equal :) then return dest
            // store it in weight varaible;
            //case like [a,a] also handle
            if(graph.get(src).containsKey(dest)){
                return graph.get(src).get(dest);
            }

            visited.add(src);

            for(Map.Entry<String, Double> nbr : graph.get(src).entrySet()){
                if(visited.contains(nbr.getKey()) == false){
                    double weight = dfs(nbr.getKey(), dest, visited, graph);

                    // if weight is not -1.0(terminate case)
                    // then mutliply it
                    // like in querie   a -> c => 2 * 3 = 6
                    if(weight != -1.0){
                        return nbr.getValue() * weight;
                    }
                }
            }
            return -1.0;
        }
    }

    // UnionFind.class
    class QuickUnionFind {
        private int[] root;

        public QuickUnionFind(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                for (int i = 0; i < root.length; i++) {
                    if (root[i] == rootY) {
                        root[i] = rootX;
                    }
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // App.java
// Test Case
    public class App {
        public void main(String[] args) throws Exception {
            QuickUnionFind uf = new QuickUnionFind(10);
            // 1-2-5-6-7 3-8-9 4
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.connected(1, 5)); // true
            System.out.println(uf.connected(5, 7)); // true
            System.out.println(uf.connected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.connected(4, 9)); // true
        }
    }

    // UnionFind.class
    class UnionFindByRank {
        private int[] root;
        private int[] rank;

        public UnionFindByRank(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != root[x]) {
                x = root[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // App.java
// Test Case
    public class App2 {
        public void main(String[] args) throws Exception {
            UnionFindByRank uf = new UnionFindByRank(10);
            // 1-2-5-6-7 3-8-9 4
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.connected(1, 5)); // true
            System.out.println(uf.connected(5, 7)); // true
            System.out.println(uf.connected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.connected(4, 9)); // true
        }
    }
    // UnionFind.class
    class UnionFindPathCompressionOptimization {
        private int[] root;

        public UnionFindPathCompressionOptimization(int size) {
            root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootY] = rootX;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // App.java
// Test Case
    public class App3 {
        public void main(String[] args) throws Exception {
            UnionFindPathCompressionOptimization uf = new UnionFindPathCompressionOptimization(10);
            // 1-2-5-6-7 3-8-9 4
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.connected(1, 5)); // true
            System.out.println(uf.connected(5, 7)); // true
            System.out.println(uf.connected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.connected(4, 9)); // true
        }
    }

    // UnionFind.class
    class OptimizedUnionFind {
        private int[] root;
        // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
        private int[] rank;

        public OptimizedUnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                // a standalone vertex with no connection to other vertices.
            }
        }

        // The find function here is the same as that in the disjoint set with path compression.
        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        // The union function with union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    // App.java
// Test Case
    public class App4 {
        public void main(String[] args) throws Exception {
            OptimizedUnionFind uf = new OptimizedUnionFind(10);
            // 1-2-5-6-7 3-8-9 4
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.connected(1, 5)); // true
            System.out.println(uf.connected(5, 7)); // true
            System.out.println(uf.connected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.connected(4, 9)); // true
        }
    }
    class DisjointSets {
        // Union Find
        public int findCircleNum(int[][] isConnected) {
            if (isConnected == null || isConnected.length == 0) {
                return 0;
            }

            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        uf.union(i, j);
                    }
                }
            }

            return uf.getCount();
        }

        class UnionFind {
            private int[] root;
            private int[] rank;
            private int count;

            UnionFind(int size) {
                root = new int[size];
                rank = new int[size];
                count = size;
                for (int i = 0; i < size; i++) {
                    root[i] = i;
                    rank[i] = 1;
                }
            }

            int find(int x) {
                if (x == root[x]) {
                    return x;
                }
                return root[x] = find(root[x]);
            }

            void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        root[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        root[rootX] = rootY;
                    } else {
                        root[rootY] = rootX;
                        rank[rootX] += 1;
                    }
                    count--;
                }
            }

            int getCount() {
                return count;
            }
        }
    }
}
