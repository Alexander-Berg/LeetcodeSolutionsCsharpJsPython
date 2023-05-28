
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

// Definition for a Node.
class NodeO {
    public int val;
    public List<NodeO> children;

    public NodeO() {}

    public NodeO(int _val) {
        val = _val;
    }

    public NodeO(int _val, List<NodeO> _children) {
        val = _val;
        children = _children;
    }
};





class  NaryTreePreorderTraversal {
    public List<Integer> preorder(NodeO root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<NodeO> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class NaryTreePostorderTraversaln {
        List<Integer> list = new ArrayList<>();
        public List<Integer> postorder(NodeO root) {
            if (root == null)
                return list;

            for(NodeO node: root.children)
                postorder(node);

            list.add(root.val);

            return list;
        }
    }

 /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class  NaryTreeLevelOrderTraversal {
        public List<List<Integer>> levelOrder(NodeO root) {
            List<List<Integer>> ret = new LinkedList<>();

            if (root == null) return ret;

            Queue<NodeO> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> curLevel = new LinkedList<>();
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    NodeO curr = queue.poll();
                    curLevel.add(curr.val);
                    for (NodeO c : curr.children)
                        queue.offer(c);
                }
                ret.add(curLevel);
            }

            return ret;
        }
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

        class MaximumDepthNaryTree {
            public int maxDepth(NodeO root) {
                if(root == null) return 0;

                Queue<NodeO> queue = new LinkedList<>();
                queue.offer(root);

                int depth = 0;

                while(!queue.isEmpty())
                {
                    int size = queue.size();

                    for(int i = 0; i < size; i++)
                    {
                        NodeO current = queue.poll();
                        for(NodeO child: current.children) queue.offer(child);
                    }

                    depth++;
                }

                return depth;
            }
        }


    }







