// Importing utility classes
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SpecialAlgortims {
    // import required classes and packages


    // create KruskalAlgorithm class to create minimum spanning tree of the given graph
    class KruskalAlgorithm {
        //create class Edge to create an edge of the graph that implements Comparable interface
        class Edge implements Comparable<Edge> {
            int source, destination, weight;

            public int compareTo(Edge edgeToCompare) {
                return this.weight - edgeToCompare.weight;
            }
        };

        // create class Subset for union
        class Subset {
            int parent, value;
        };

        //initialize vertices, edges and edgeArray
        int vertices, edges;
        Edge edgeArray[];

        // using constructor to create a graph
        KruskalAlgorithm(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
            edgeArray = new Edge[this.edges];
            for (int i = 0; i < edges; ++i)
                edgeArray[i] = new Edge();  //create edge for all te edges given by the user
        }

        // create applyKruskal() method for applying Kruskal's Algorithm
        void applyKruskal() {

            // initialize finalResult array to store the final MST
            Edge finalResult[] = new Edge[vertices];
            int newEdge = 0;
            int index = 0;
            for (index = 0; index < vertices; ++index)
                finalResult[index] = new Edge();

            // using sort() method for sorting the edges
            Arrays.sort(edgeArray);

            // create an array of the vertices of type Subset for the subsets of vertices
            Subset subsetArray[] = new Subset[vertices];

            // aloocate memory to create vertices subsets
            for (index = 0; index < vertices; ++index)
                subsetArray[index] = new Subset();

            // it is used to create subset with single element
            for (int vertex = 0; vertex < vertices; ++vertex) {
                subsetArray[vertex].parent = vertex;
                subsetArray[vertex].value = 0;
            }
            index = 0;

            // use for loop to pick the smallers edge from the edges and increment the index for next iteration
            while (newEdge < vertices - 1) {
                // create an instance of Edge for next edge
                Edge nextEdge = new Edge();
                nextEdge = edgeArray[index++];

                int nextSource = findSetOfElement(subsetArray, nextEdge.source);
                int nextDestination = findSetOfElement(subsetArray, nextEdge.destination);

                //if the edge doesn't create cycle after including it, we add it in the result and increment the index
                if (nextSource != nextDestination) {
                    finalResult[newEdge++] = nextEdge;
                    performUnion(subsetArray, nextSource, nextDestination);
                }
            }
            for (index = 0; index < newEdge; ++index)
                System.out.println(finalResult[index].source + " - " + finalResult[index].destination + ": " + finalResult[index].weight);
        }

        // create findSetOfElement() method to get set of an element
        int findSetOfElement(Subset subsetArray[], int i) {
            if (subsetArray[i].parent != i)
                subsetArray[i].parent = findSetOfElement(subsetArray, subsetArray[i].parent);
            return subsetArray[i].parent;
        }

        // create performUnion() method to perform union of two sets
        void performUnion(Subset subsetArray[], int sourceRoot, int destinationRoot) {

            int nextSourceRoot = findSetOfElement(subsetArray, sourceRoot);
            int nextDestinationRoot = findSetOfElement(subsetArray, destinationRoot);

            if (subsetArray[nextSourceRoot].value < subsetArray[nextDestinationRoot].value)
                subsetArray[nextSourceRoot].parent = nextDestinationRoot;
            else if (subsetArray[nextSourceRoot].value > subsetArray[nextDestinationRoot].value)
                subsetArray[nextDestinationRoot].parent = nextSourceRoot;
            else {
                subsetArray[nextDestinationRoot].parent = nextSourceRoot;
                subsetArray[nextSourceRoot].value++;
            }
        }

        //main() method starts
        public void main(String[] args) {

            int v, e;
            //create scanner class object to get input from user
            Scanner sc = new Scanner(System.in);

            //show custom message
            System.out.println("Enter number of vertices: ");

            //store user entered value into variable v
            v = sc.nextInt();

            //show custom message
            System.out.println("Enter number of edges");

            //store user entered value into variable e
            e = sc.nextInt();

            KruskalAlgorithm graph = new KruskalAlgorithm(v, e);        // use for creating Graph

            for(int i = 0; i < e; i++){
                System.out.println("Enter source value for edge["+ i +"]");
                graph.edgeArray[i].source = sc.nextInt();

                System.out.println("Enter destination value for edge["+ i +"]");
                graph.edgeArray[i].destination = sc.nextInt();

                System.out.println("Enter weight for edge["+i+"]");
                graph.edgeArray[i].weight = sc.nextInt();
            }

            // call applyKruskal() method to get MST
            graph.applyKruskal();
        }
    }
    // Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue


    // Main class DPQ
    public class GFG {

        // Member variables of this class
        private int dist[];
        private Set<Integer> settled;
        private PriorityQueue<Node> pq;
        // Number of vertices
        private int V;
        List<List<Node> > adj;

        // Constructor of this class
        public GFG(int V)
        {

            // This keyword refers to current object itself
            this.V = V;
            dist = new int[V];
            settled = new HashSet<Integer>();
            pq = new PriorityQueue<Node>(V, new Node());
        }

        // Method 1
        // Dijkstra's Algorithm
        public void dijkstra(List<List<Node> > adj, int src)
        {
            this.adj = adj;

            for (int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;

            // Add source node to the priority queue
            pq.add(new Node(src, 0));

            // Distance to the source is 0
            dist[src] = 0;

            while (settled.size() != V) {

                // Terminating condition check when
                // the priority queue is empty, return
                if (pq.isEmpty())
                    return;

                // Removing the minimum distance node
                // from the priority queue
                int u = pq.remove().node;

                // Adding the node whose distance is
                // finalized
                if (settled.contains(u))

                    // Continue keyword skips execution for
                    // following check
                    continue;

                // We don't have to call e_Neighbors(u)
                // if u is already present in the settled set.
                settled.add(u);

                e_Neighbours(u);
            }
        }

        // Method 2
        // To process all the neighbours
        // of the passed node
        private void e_Neighbours(int u)
        {

            int edgeDistance = -1;
            int newDistance = -1;

            // All the neighbors of v
            for (int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);

                // If current node hasn't already been processed
                if (!settled.contains(v.node)) {
                    edgeDistance = v.cost;
                    newDistance = dist[u] + edgeDistance;

                    // If new distance is cheaper in cost
                    if (newDistance < dist[v.node])
                        dist[v.node] = newDistance;

                    // Add the current node to the queue
                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

        // Main driver method
        public void main(String arg[])
        {

            int V = 5;
            int source = 0;

            // Adjacency list representation of the
            // connected edges by declaring List class object
            // Declaring object of type List<Node>
            List<List<Node> > adj
                    = new ArrayList<List<Node> >();

            // Initialize list for every node
            for (int i = 0; i < V; i++) {
                List<Node> item = new ArrayList<Node>();
                adj.add(item);
            }

            // Inputs for the GFG(dpq) graph
            adj.get(0).add(new Node(1, 9));
            adj.get(0).add(new Node(2, 6));
            adj.get(0).add(new Node(3, 5));
            adj.get(0).add(new Node(4, 3));

            adj.get(2).add(new Node(1, 2));
            adj.get(2).add(new Node(3, 4));

            // Calculating the single source shortest path
            GFG dpq = new GFG(V);
            dpq.dijkstra(adj, source);

            // Printing the shortest path to all the nodes
            // from the source node
            System.out.println("The shorted path from node :");

            for (int i = 0; i < dpq.dist.length; i++)
                System.out.println(source + " to " + i + " is "
                        + dpq.dist[i]);
        }
    }

    // Class 2
// Helper class implementing Comparator interface
// Representing a node in the graph
    class Node implements Comparator<Node> {

        // Member variables of this class
        public int node;
        public int cost;

        // Constructors of this class

        // Constructor 1
        public Node() {}

        // Constructor 2
        public Node(int node, int cost)
        {

            // This keyword refers to current instance itself
            this.node = node;
            this.cost = cost;
        }

        public Node(int x, int i, int matrix) {
        }

        // Method 1
        @Override public int compare(Node node1, Node node2)
        {

            if (node1.cost < node2.cost)
                return -1;

            if (node1.cost > node2.cost)
                return 1;

            return 0;
        }
    }



    class Graph
    {
        //vertices of the graph
        private int V;
        //edges in the graph
        private List<Edge> edges;
        //creating a constructor of the Graph class and generating getters and setters
        public Graph(int v)
        {
            V = v;
            edges = new ArrayList<Edge>();
        }
        public int getV()
        {
            return V;
        }
        public void setV(int v)
        {
            V = v;
        }
        public List<Edge> getEdges()
        {
            return edges;
        }
        public void setEdges(List<Edge> edges)
        {
            this.edges = edges;
        }
        public void addEdge(int u, int v, int w)
        {
            Edge e = new Edge(u, v, w);
            edges.add(e);
        }
    }
    class Edge
    {
        //it is the source vertex
        private int u;
        //it is the destination vertex
        private int v;
        //it denotes the weight on edge
        private int w;
        //generating getters and setters
        public int getU()
        {
            return u;
        }
        public void setU(int u)
        {
            this.u = u;
        }
        public int getV()
        {
            return v;
        }
        public void setV(int v)
        {
            this.v = v;
        }
        public int getW()
        {
            return w;
        }
        public void setW(int w)
        {
            this.w = w;
        }
        //creating constructor of the Edge class
        public Edge(int u, int v, int w)
        {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public class BellmanFordImplementation
    {
        public void main(String args[])
        {
            Graph g = createGraph();
            int distance[] = new int[g.getV()];
            boolean hasNegativeCycle = getShortestPaths(g, 1, distance);
            if(!hasNegativeCycle)
            {
                System.out.println("Vertex \t: Distance");
                for(int i = 1; i < distance.length; i++)
                    System.out.println("\t"+i + " " + "\t\t"+(distance[i] == Integer.MAX_VALUE ? "-" : distance[i]));
            }
            else
            {
                System.out.println("Negative cycle exists in the graph, no solution found!!!");
            }
        }
        private Graph createGraph()
        {
            int v = 7;
//creating a graph having 7 vertices
            Graph g = new Graph(v);
//adding edges to the graph
            g.addEdge(1, 2, 4);
            g.addEdge(1, 4, 9);
            g.addEdge(2, 3, -1);
            g.addEdge(3, 6, 3);
            g.addEdge(4, 3, 2);
            g.addEdge(4, 5, -5);
            g.addEdge(5, 6, 0);
//returns graph
            return g;
        }
        //Bellman-Ford logic
        public static boolean getShortestPaths(Graph g, int source, int[] distance)
        {
            int V = g.getV();
//initializing distances from source to other vertices
            for(int i = 1; i < V; i++)
            {
                distance[i] = Integer.MAX_VALUE;
            }
//source vertex initialize to 0
            distance[source] = 0;
//relaxing edges
            for(int i = 1; i < V; i++)
            {
//iterate over edges
                for(Edge e: g.getEdges())
                {
                    int u = e.getU(), v = e.getV(), w = e.getW();
                    if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)
                    {
//calculates distance
                        distance[v] = distance[u] + w;
                    }
                }
            }
//checks if there exist negative cycles in graph G
            for(Edge e: g.getEdges())
            {
                int u = e.getU(), v = e.getV(), w = e.getW();
                if(distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + w)
                {
                    return true;
                }
            }
            return false;
        }
    }

    class FloydWarshall {
        final static int INF = Integer.MAX_VALUE;

        public void FloydWarshall() {

        }

        // O(n^3)
        int[][] floydWarshall(int A[][]) {
            int n = A.length;
            int D[][] = createDistanceMatrix(A, n);

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (D[i][k] < INF && D[k][j] < INF)
                            D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }

            return D;
        }

        // O(n^2)
        int[][] createDistanceMatrix(int A[][], int n) {
            int D[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        D[i][j] = 0;
                    else if (A[i][j] == 0)
                        D[i][j] = INF;
                    else
                        D[i][j] = A[i][j];
                }
            }
            return D;
        }
    }

    class TopologicalSortingAlgorithm {
        Map <Integer, List<Integer>> groupGraph;
        Map <Integer, List<Integer>> itemGraph;

        int[] groupsIndegree;
        int[] itemsIndegree;

        private void buildGraphOfGroups(int[] group, List<List<Integer>> beforeItems, int n) {
            for (int i=0;i<group.length;i++) {
                int toGroup = group[i];
                List <Integer> fromItems = beforeItems.get(i);
                for (int fromItem : fromItems) {
                    int fromGroup = group[fromItem];
                    if(fromGroup != toGroup) {
                        groupGraph.computeIfAbsent(fromGroup, x->new ArrayList()).add(toGroup);
                        groupsIndegree[toGroup]++;
                    }
                }
            }
        }

        private void buildGraphOfItems(List<List<Integer>> beforeItems, int n) {
            for (int i=0;i<n;i++) {
                List<Integer> items = beforeItems.get(i);
                for (Integer item : items) {
                    itemGraph.computeIfAbsent(item, x->new ArrayList()).add(i);
                    itemsIndegree[i]++;
                }
            }
        }

        private List<Integer> topologicalSortUtil(Map <Integer, List<Integer>> graph, int[] indegree, int n) {
            List <Integer> list = new ArrayList<Integer>();
            Queue queue = new Queue();
            for (int key : graph.keySet()) {
                if(indegree[key] == 0) {
                    queue.add(key);
                }
            }

            while(!queue.isEmpty()) {
                int node = queue.poll();
                n--;
                list.add(node);
                for (int neighbor : graph.get(node)) {
                    indegree[neighbor] --;
                    if(indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            return n == 0 ? list : new ArrayList();
        }

        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            groupGraph = new HashMap();
            itemGraph = new HashMap();

            // Each item belongs to a group. If an item doesn't have a group it forms it's own isolated group.
            for (int i=0;i<group.length;i++) {
                if(group[i] == -1) group[i] = m++;
            }

            for (int i=0;i<m;i++) {
                groupGraph.put(i, new ArrayList());
            }

            for (int i=0;i<n;i++) {
                itemGraph.put(i, new ArrayList());
            }

            groupsIndegree = new int[m];
            itemsIndegree = new int[n];

            // form graph structure across different groups and also calculate indegree.
            buildGraphOfGroups(group, beforeItems, n);

            // form graph structure across different items and also calculate indegree.
            buildGraphOfItems(beforeItems, n);

            // Topological ordering of the groups.
            List<Integer> groupsList = topologicalSortUtil(groupGraph, groupsIndegree, m);
            // Topological ordering of the items.
            List<Integer> itemsList = topologicalSortUtil(itemGraph, itemsIndegree, n);

            // Detect if there are any cycles.
            if(groupsList.size() == 0 || itemsList.size() == 0) return new int[0];

            // This Map holds relative order of items in the same group computed in the loop below.
            Map <Integer, List<Integer>> groupsToItems = new HashMap();

            for (Integer item : itemsList) {
                groupsToItems.computeIfAbsent(group[item], x->new ArrayList()).add(item);
            }

            int[] ans = new int[n];
            int idx = 0;
            for (Integer grp : groupsList) {
                List <Integer> items = groupsToItems.getOrDefault(grp, new ArrayList());
                for (Integer item : items) {
                    ans[idx++] = item;
                }
            }

            return ans;
        }
    }




    //1. Flood Fill
    public class FloodFill {
        public static void main(String[] args) {
            String map = "##....###!#...###..!#.#..#..s!####.#...!##...###.";
            String[] lines = map.split("!");
            char[][] grid = new char[lines.length][lines[0].length()];
            for (int j=0;j<grid.length;j++) for (int i=0;i<grid[j].length;i++) grid[j][i] = lines[j].charAt(i);
            floodFill(grid, new boolean[grid.length][grid[0].length], 2, 8); //row 2, 8 is where the 's' is
            for (int j=0;j<grid.length;j++) {
                for (int i=0;i<grid[j].length;i++) System.out.print(grid[j][i]);
                System.out.println();
            }
        }
        static void floodFill(char[][] grid, boolean[][] visited, int r, int c) {
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
            if(visited[r][c]) return;
            visited[r][c] = true;
            if(grid[r][c]=='#') return;
            if(grid[r][c]=='.') grid[r][c] = '*';
            floodFill(grid,visited,r+1,c);
            floodFill(grid,visited,r-1,c);
            floodFill(grid,visited,r,c+1);
            floodFill(grid,visited,r,c-1);
        }
    }


    //2. Flood Count
    public class FloodCount{
        public static void main(String[] args) {
            //Create the char[][] grid:
            String map = "##....###!#...###..!#.#..#..s!####.#...!##...###.";
            String[] lines = map.split("!");
            char[][] grid = new char[lines.length][lines[0].length()];
            for (int j=0;j<grid.length;j++) for (int i=0;i<grid[j].length;i++) grid[j][i] = lines[j].charAt(i);

            //Run floodCount on the grid given a start position and an empty visited array
            int count = floodCount(grid, new boolean[grid.length][grid[0].length], 2, 8); //row 2, 8 is where the 's' is

            //Print the resulting grid which hasn't changed:
            for (int j=0;j<grid.length;j++) {
                for (int i=0;i<grid[j].length;i++) System.out.print(grid[j][i]);
                System.out.println();
            }

            //Print the sum count
            System.out.println(count);
        }

        //floodCount algorithm:
        static int floodCount(char[][] grid, boolean[][] visited, int r, int c) {
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
            if(visited[r][c]) return 0;
            visited[r][c] = true;
            if(grid[r][c]=='#') return 0;
            int out = 0;
            if(grid[r][c]=='.') out++;
            out += floodCount(grid,visited,r+1,c);
            out += floodCount(grid,visited,r-1,c);
            out += floodCount(grid,visited,r,c+1);
            out += floodCount(grid,visited,r,c-1);
            return out;
        }
    }

    //LeeAlgorithm


    public class LeeAlgorithm {

        private final int matrixWidth = 7, matrixHeight = 7;
        private int matrix[][] = new int[matrixWidth][matrixHeight];
        private boolean matrixVisited[][] = new boolean[matrixWidth][matrixHeight];
        private ArrayList<Node> nodeList = new ArrayList<Node>();
        private final int MAXITERATIONS = 1000;
        private final int OBSTACLE = -1;


/*
 find the shortest path between start and goal

 */

        public LeeAlgorithm() {
            matrix[4][1]=OBSTACLE; matrixVisited[4][1]=true;
            matrix[3][1]=OBSTACLE; matrixVisited[3][1]=true;
            matrix[2][3]=OBSTACLE; matrixVisited[2][3]=true;
            matrix[4][3]=OBSTACLE; matrixVisited[4][3]=true;
            matrix[5][3]=OBSTACLE; matrixVisited[5][3]=true;
            //matrix[1][0]=OBSTACLE; matrixVisited[1][0]=true; no path
            matrix[0][1]=OBSTACLE; matrixVisited[0][1]=true;
        }

        private ArrayList<Node> findPath(Node start, Node goal) {

            if (nodeList.isEmpty()) {
                nodeList.add(start);
                matrixVisited[start.getX()][start.getY()] = true;
            }

            for (int i = 1; i < MAXITERATIONS; i++) {

                nodeList = markNeighbors(nodeList, i);

                if (matrix[goal.getX()][goal.getY()] != 0) {
                    System.out.println("Path exists");
                    break;
                }

                if (i == MAXITERATIONS - 1) {
                    System.out.println("No Path exists");
                    System.exit(0);
                }
            }

            ArrayList<Node> pathList = backtraceFromGoal(goal, start);

            return pathList;
        }


/*
 First step

  mark all unlabeled neighbors of points which are marked with i, with i+1
 */

        private ArrayList<NodeO> markNeighbors(ArrayList<NodeO> neighborList, int iteration) {

            ArrayList<NodeO> neighbors = new ArrayList<>();

            for (NodeO nodeO : neighborList) {

                if (nodeO.getY() + 1 < matrix.length && matrixVisited[nodeO.getX()][nodeO.getY() + 1] == false) {

                    Node node1 = new Node(nodeO.getX(), nodeO.getY() + 1);
                    neighbors.add(node1);
                    matrix[nodeO.getX()][nodeO.getY() + 1] = iteration;
                    matrixVisited[nodeO.getX()][nodeO.getY() + 1] = true;
                }

                if (nodeO.getY() >= 1 && matrixVisited[nodeO.getX()][nodeO.getY() - 1] == false) {

                    Node node2 = new Node(node.getX(), node.getY() - 1);
                    neighbors.add(node2);
                    matrix[nodeO.getX()][nodeO.getY() - 1] = iteration;
                    matrixVisited[nodeO.getX()][nodeO.getY() - 1] = true;
                }

                if (nodeO.getX() + 1 < matrix.length && matrixVisited[nodeO.getX() + 1][nodeO.getY()] == false) {

                    Node node3 = new Node(nodeO.getX() + 1, nodeO.getY());
                    neighbors.add(node3);
                    matrix[nodeO.getX() + 1][nodeO.getY()] = iteration;
                    matrixVisited[nodeO.getX() + 1][nodeO.getY()] = true;
                }

                if (nodeO.getX() >= 1 && matrixVisited[nodeO.getX() - 1][nodeO.getY()] == false) {

                    Node node4 = new Node(nodeO.getX()-1, nodeO.getY() );
                    neighbors.add(node4);
                    matrix[nodeO.getX() - 1][nodeO.getY()] = iteration;
                    matrixVisited[nodeO.getX() - 1][nodeO.getY()] = true;
                }
            }
            return neighbors;
        }

/*
 Second step

  from goal Node go to next node that has a lower mark than the current node
  add this node to path until start Node is reached
 */

        private ArrayList<NodeO> backtraceFromGoal(NodeO fromGoal, NodeO toStart) {

            ArrayList<NodeO> pathList = new ArrayList<NodeO>();

            pathList.add(fromGoal);
            NodeO currentNode = null;

            while (!pathList.get(pathList.size() - 1).equals(toStart)) {

                NodeO currentNodeO = pathList.get(pathList.size() - 1);
                NodeO n = getNeighbor(currentNode);
                pathList.add(n);
                n = currentNode;
            }
            return pathList;
        }

/*
  get Neighbor of node with smallest matrix value, todo shuffle
 */

        private NodeO getNeighbor(NodeO nodeO) {

            ArrayList<NodeO> possibleNeighbors = new ArrayList<NodeO>();

            if (nodeO.getY() + 1 < matrix.length && matrixVisited[nodeO.getX()][nodeO.getY() + 1] == true &&
                    matrix[nodeO.getX()][nodeO.getY() + 1]!=OBSTACLE) {

                Node n = new Node(nodeO.getX(), nodeO.getY() + 1, matrix[nodeO.getX()][nodeO.getY() + 1]);
                possibleNeighbors.add(n);
            }

            if (nodeO.getY() >= 1 && matrixVisited[nodeO.getX()][nodeO.getY() - 1] == true &&
                    matrix[nodeO.getX()][nodeO.getY() -1 ]!=OBSTACLE) {

                Node n = new Node(nodeO.getX(), nodeO.getY() - 1, matrix[nodeO.getX()][nodeO.getY() - 1]);
                possibleNeighbors.add(n);
            }

            if (nodeO.getX() + 1 < matrix.length && matrixVisited[nodeO.getX() + 1][nodeO.getY()] == true &&
                    matrix[nodeO.getX() + 1][nodeO.getY()]!=OBSTACLE) {

                Node n = new Node(nodeO.getX() + 1, nodeO.getY(), matrix[nodeO.getX() + 1][nodeO.getY()]);
                possibleNeighbors.add(n);
            }

            if (nodeO.getX() >= 1 && matrixVisited[nodeO.getX() - 1][nodeO.getY()] == true &&
                    matrix[nodeO.getX() - 1][nodeO.getY()]!=OBSTACLE) {

                Node n = new Node(nodeO.getX() - 1, nodeO.getY(), matrix[nodeO.getX() - 1][nodeO.getY()]);
                possibleNeighbors.add(n);
            }

            Collections.sort(possibleNeighbors, new Comparator<NodeO>() {
                @Override
                public int compare(NodeO first, NodeO second) {
                    return first.getValue() - second.getValue();
                }
            });

            NodeO n = possibleNeighbors.remove(0);

            return n;
        }

        private void printSolution(ArrayList<NodeO> output) {

            System.out.println("Shortest Path:");
            for (NodeO n : output) {
                int x=n.getX();
                int y=n.getY();
                System.out.println(n.toString());
                matrix[x][y]=0;
            }

            System.out.println("");

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {

                    if(matrix[i][j]!=0 && matrix[i][j]!=OBSTACLE) {
                        matrix[i][j]=1;
                    }

                    if(matrixVisited[i][j]==false) {
                        matrix[i][j]=1;
                    }

                    if(matrix[i][j]==OBSTACLE) {
                        System.out.print("O ");
                    }

                    else {

                        System.out.print(matrix[i][j]+" ");
                    }
                }
                System.out.println("");
            }
        }

        public void main(String[] args) {
            LeeAlgorithm l = new LeeAlgorithm();
            ArrayList<NodeO> output = l.findPath(new NodeO(0, 0), new NodeO(5, 4));

            l.printSolution(output);

        }

        private ArrayList<NodeO> findPath(NodeO nodeO, NodeO nodeO1) {
            return null;
        }
    }

    class NodeO {

        private int x;
        private int y;
        private int value;

        public NodeO(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public NodeO(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean equals(NodeO n) {
            if (this.x == n.x && this.y == n.y) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public
    class KadanesAlgorithm{
        public
        static void main(String[] args) {
            int[] a = {-2, -3, 4, -1, -3};
            System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
        }
        static int maxSubArraySum(int a[]) {
            int size = a.length;
            int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
            for (int i = 0; i < size; i++) {
                max_ending_here = max_ending_here + a[i];
                if (max_so_far < max_ending_here) max_so_far = max_ending_here;
                if (max_ending_here < 0) max_ending_here = 0;
            }
            return max_so_far;
        }
    }

    // Java program to implement
// the above approach

//Floyd’s Cycle Finding Algorithm

    class FloydsCycleFindingAlgorithm{

        static class Node {
            int data;
            Node next;

            Node(int data)
            {
                this.data = data;
                next = null;
            }
        };

        // initialize a new head for the linked list
        static Node head = null;
        static class Linkedlist {
            // insert new value at the start
            void insert(int value)
            {
                Node newNode = new Node(value);
                if (head == null)
                    head = newNode;
                else {
                    newNode.next = head;
                    head = newNode;
                }
            }

            // detect if there is a loop
            // in the linked list
            boolean detectLoop()
            {
                Node slowPointer = head,
                        fastPointer = head;

                while (slowPointer != null
                        && fastPointer != null
                        && fastPointer.next != null) {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next.next;
                    if (slowPointer == fastPointer)
                        return true;
                }

                return false;
            }
        }

        public static void main(String[] args)
        {
            Linkedlist l1 = new Linkedlist();
            // inserting new values
            l1.insert(10);
            l1.insert(20);
            l1.insert(30);
            l1.insert(40);
            l1.insert(50);

            // adding a loop for the sake
            // of this example
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = head;

            // loop added;

            if (l1.detectLoop())
                System.out.print("Loop exists in the"
                        + " Linked List" +"\n");
            else
                System.out.print("Loop does not exists "
                        + "in the Linked List" +"\n");

        }
    }

// This code is contributed by 29AjayKumar

/**
 ** Java Program to implement Knuth Morris Pratt Algorithm
 **/



    /** Class KnuthMorrisPratt **/
    public class KnuthMorrisPratt
    {
        /** Failure array **/
        private int[] failure;
        /** Constructor **/
        public KnuthMorrisPratt(String text, String pat)
        {
            /** pre construct failure array for a pattern **/
            failure = new int[pat.length()];
            fail(pat);
            /** find match **/
            int pos = posMatch(text, pat);
            if (pos == -1)
                System.out.println("\nNo match found");
            else
                System.out.println("\nMatch found at index "+ pos);
        }
        /** Failure function for a pattern **/
        private void fail(String pat)
        {
            int n = pat.length();
            failure[0] = -1;
            for (int j = 1; j < n; j++)
            {
                int i = failure[j - 1];
                while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
                    i = failure[i];
                if (pat.charAt(j) == pat.charAt(i + 1))
                    failure[j] = i + 1;
                else
                    failure[j] = -1;
            }
        }
        /** Function to find match for a pattern **/
        private int posMatch(String text, String pat)
        {
            int i = 0, j = 0;
            int lens = text.length();
            int lenp = pat.length();
            while (i < lens && j < lenp)
            {
                if (text.charAt(i) == pat.charAt(j))
                {
                    i++;
                    j++;
                }
                else if (j == 0)
                    i++;
                else
                    j = failure[j - 1] + 1;
            }
            return ((j == lenp) ? (i - lenp) : -1);
        }
        /** Main Function **/
        public void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Knuth Morris Pratt Test\n");
            System.out.println("\nEnter Text\n");
            String text = br.readLine();
            System.out.println("\nEnter Pattern\n");
            String pattern = br.readLine();
            KnuthMorrisPratt kmp = new KnuthMorrisPratt(text, pattern);
        }
    }

    // JAVA program for implementation of KMP pattern
// searching algorithm

    class KMP_String_Matching {
        void KMPSearch(String pat, String txt)
        {
            int M = pat.length();
            int N = txt.length();

            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);

            int i = 0; // index for txt[]
            while ((N - i) >= (M - j)) {
                if (pat.charAt(j) == txt.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == M) {
                    System.out.println("Found pattern "
                            + "at index " + (i - j));
                    j = lps[j - 1];
                }

                // mismatch after j matches
                else if (i < N
                        && pat.charAt(j) != txt.charAt(i)) {
                    // Do not match lps[0..lps[j-1]] characters,
                    // they will match anyway
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
        }

        void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0

            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (len != 0) {
                        len = lps[len - 1];

                        // Also, note that we do not increment
                        // i here
                    }
                    else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }

        // Driver code
        public void main(String args[])
        {
            String txt = "ABABDABACDABABCABAB";
            String pat = "ABABCABAB";
            new KMP_String_Matching().KMPSearch(pat, txt);
        }
    }
// This code has been contributed by Amit Khandelwal.


// Java program of Quick Select
import java.util.Arrays;

    class GFG {

        // partition function similar to quick sort
        // Considers last element as pivot and adds
        // elements with less value to the left and
        // high value to the right and also changes
        // the pivot position to its respective position
        // in the final array.
        public static int partition(int[] arr, int low,
                                    int high)
        {
            int pivot = arr[high], pivotloc = low;
            for (int i = low; i <= high; i++) {
                // inserting elements of less value
                // to the left of the pivot location
                if (arr[i] < pivot) {
                    int temp = arr[i];
                    arr[i] = arr[pivotloc];
                    arr[pivotloc] = temp;
                    pivotloc++;
                }
            }

            // swapping pivot to the final pivot location
            int temp = arr[high];
            arr[high] = arr[pivotloc];
            arr[pivotloc] = temp;

            return pivotloc;
        }

        // finds the kth position (of the sorted array)
        // in a given unsorted array i.e this function
        // can be used to find both kth largest and
        // kth smallest element in the array.
        // ASSUMPTION: all elements in arr[] are distinct
        public static int kthSmallest(int[] arr, int low,
                                      int high, int k)
        {
            // find the partition
            int partition = partition(arr, low, high);

            // if partition value is equal to the kth position,
            // return value at k.
            if (partition == k - 1)
                return arr[partition];

                // if partition value is less than kth position,
                // search right side of the array.
            else if (partition < k - 1)
                return kthSmallest(arr, partition + 1, high, k);

                // if partition value is more than kth position,
                // search left side of the array.
            else
                return kthSmallest(arr, low, partition - 1, k);
        }

        // Driver Code
        public static void main(String[] args)
        {
            int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
            int[] arraycopy
                    = new int[] { 10, 4, 5, 8, 6, 11, 26 };

            int kPosition = 3;
            int length = array.length;

            if (kPosition > length) {
                System.out.println("Index out of bound");
            }
            else {
                // find kth smallest value
                System.out.println(
                        "K-th smallest element in array : "
                                + kthSmallest(arraycopy, 0, length - 1,
                                kPosition));
            }
        }
    }

// This code is contributed by Saiteja Pamulapati

    import java.io.*;

    class GFG
    {

        // Function to find majority element
        public static int findMajority(int[] nums)
        {
            int count = 0, candidate = -1;

            // Finding majority candidate
            for (int index = 0; index < nums.length; index++) {
                if (count == 0) {
                    candidate = nums[index];
                    count = 1;
                }
                else {
                    if (nums[index] == candidate)
                        count++;
                    else
                        count--;
                }
            }

            // Checking if majority candidate occurs more than
            // n/2 times
            count = 0;
            for (int index = 0; index < nums.length; index++) {
                if (nums[index] == candidate)
                    count++;
            }
            if (count > (nums.length / 2))
                return candidate;
            return -1;

            // The last for loop and the if statement step can
            // be skip if a majority element is confirmed to
            // be present in an array just return candidate
            // in that case
        }

        // Driver code
        public static void main(String[] args)
        {
            int arr[] = { 1, 1, 1, 1, 2, 3, 4 };
            int majority = findMajority(arr);
            System.out.println(" The majority element is : "
                    + majority);
        }
    }

// This code is contributed by Arnav Sharma

}
