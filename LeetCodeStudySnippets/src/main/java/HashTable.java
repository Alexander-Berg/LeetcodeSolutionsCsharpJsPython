import java.lang.reflect.Type;
import java.util.*;

public class HashTable {
    class MyHashSet {
        boolean[] setArray;

        public MyHashSet() {
            setArray = new boolean[1000000 + 1];
        }

        public void add(int key) {
            setArray[key] = true;
        }

        public void remove(int key) {
            setArray[key] = false;
        }

        public boolean contains(int key) {
            return setArray[key];
        }
    }

// TC: O(1)
// SC: O(10^6 + 1) => O(1)


    // "static void main" must be defined in a public class.
    public class HashSetMain {
        public static void main(String[] args) {
            // 1. initialize the hash set
            Set<Integer> hashSet = new HashSet<>();
            // 2. add a new key
            hashSet.add(3);
            hashSet.add(2);
            hashSet.add(1);
            // 3. remove the key
            hashSet.remove(2);
            // 4. check if the key is in the hash set
            if (!hashSet.contains(2)) {
                System.out.println("Key 2 is not in the hash set.");
            }
            // 5. get the size of the hash set
            System.out.println("The size of has set is: " + hashSet.size());
            // 6. iterate the hash set
            for (Integer i : hashSet) {
                System.out.print(i + " ");
            }
            System.out.println("are in the hash set.");
            // 7. clear the hash set
            hashSet.clear();
            // 8. check if the hash set is empty
            if (hashSet.isEmpty()) {
                System.out.println("hash set is empty now!");
            }
        }
    }

    /*
     * Template for using hash set to find duplicates.
     */
    boolean findDuplicates(List<Type> keys) {
        // Replace Type with actual type of your key
        Set<Type> hashset = new HashSet<>();
        for (Type key : keys) {
            if (hashset.contains(key)) {
                return true;
            }
            hashset.add(key);
        }
        return false;
    }

    class HashMapArraysIntersection {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet();
            List<Integer> arr = new ArrayList<>();

            for (int i : nums1) {
                set.add(i);
            }

            for (int i : nums2) {
                if (set.contains(i)) {
                    arr.add(i);
                    set.remove(i);
                }
            }

            int[] resultArray = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                resultArray[i] = arr.get(i);
            }

            return resultArray;
        }
    }

    // "static void main" must be defined in a public class.
    public class HashMapExample {
        public static void main(String[] args) {
            // 1. initialize a hash map
            Map<Integer, Integer> hashmap = new HashMap<>();
            // 2. insert a new (key, value) pair
            hashmap.putIfAbsent(0, 0);
            hashmap.putIfAbsent(2, 3);
            // 3. insert a new (key, value) pair or update the value of existed key
            hashmap.put(1, 1);
            hashmap.put(1, 2);
            // 4. get the value of specific key
            System.out.println("The value of key 1 is: " + hashmap.get(1));
            // 5. delete a key
            hashmap.remove(2);
            // 6. check if a key is in the hash map
            if (!hashmap.containsKey(2)) {
                System.out.println("Key 2 is not in the hash map.");
            }
            // 7. get the size of the hash map
            System.out.println("The size of hash map is: " + hashmap.size());
            // 8. iterate the hash map
            for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
                System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
            }
            System.out.println("are in the hash map.");
            // 9. clear the hash map
            hashmap.clear();
            // 10. check if the hash map is empty
            if (hashmap.isEmpty()) {
                System.out.println("hash map is empty now!");
            }
        }
    }

    class HashMapTemplate {
        /*
         * Template for using hash map to find duplicates.
         * Replace ReturnType with the actual type of your return value.

        ReturnType aggregateByKey_hashmap(List<Type>& keys) {
            // Replace Type and InfoType with actual type of your key and value
            Map<Type, InfoType> hashmap = new HashMap<>();
            for (Type key : keys) {
                if (hashmap.containsKey(key)) {
                    if (hashmap.get(key) satisfies the requirement) {
                        return needed_information;
                    }
                }
                // Value can be any information you needed (e.g. index)
                hashmap.put(key, value);
            }
            return needed_information;
        }

         */
    }

    public class MimimumIndexSumofTwo {
        public String[] findRestaurant(String[] list1, String[] list2) {
            HashMap<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i].equals(list2[j])) {
                        if (!map.containsKey(i + j))
                            map.put(i + j, new ArrayList<String>());
                        map.get(i + j).add(list1[i]);
                    }
                }
            }
            int min_index_sum = Integer.MAX_VALUE;
            for (int key : map.keySet())
                min_index_sum = Math.min(min_index_sum, key);
            String[] res = new String[map.get(min_index_sum).size()];
            return map.get(min_index_sum).toArray(res);
        }
    }


    // Definition for a binary tree node.
    public class TreeNodeD {
        int val;
        TreeNodeD left;
        TreeNodeD right;

        TreeNodeD() {
        }

        TreeNodeD(int val) {
            this.val = val;
        }

        TreeNodeD(int val, TreeNodeD left, TreeNodeD right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class FindDuplicateSubtrees {
        public List<TreeNodeD> findDuplicateSubtrees(TreeNodeD root) {
            List<TreeNodeD> res = (List<TreeNodeD>) new LinkedList();
            traverse(root, new HashMap<>(), res);
            return res;
        }

        public String traverse(TreeNodeD node, Map<String, Integer> cnt,
                               List<TreeNodeD> res) {
            if (node == null) {
                return "";
            }
            String representation = "(" + traverse(node.left, cnt, res) + ")" +
                    node.val + "(" + traverse(node.right, cnt, res) +
                    ")";
            cnt.put(representation, cnt.getOrDefault(representation, 0) + 1);
            if (cnt.get(representation) == 2) {
                res.add(node);
            }
            return representation;
        }
    }
    class JewelsStones {
        public static int numJewelsInStones(String jewels, String stones) {
            char[] jewArr = jewels.toCharArray();
            char[] stoneArr = stones.toCharArray();
            int ans = 0;

            for (int i = 0; i < jewArr.length; i++) {
                for (int j = 0; j < stoneArr.length; j++) {
                    if (jewArr[i] == stoneArr[j]) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
    class DesignHashMap{
        final ListNode[] nodes = new ListNode[10_000];

        public void put(int key, int value){
            int i = idx(key);
            if(nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if(prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key){
            int i = idx(key);
            if(nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key){
            int i = idx(key);
            if(nodes[i] != null){
                ListNode prev = find(nodes[i], key);
                if(prev.next != null)
                    prev.next = prev.next.next;
            }
        }

        int idx(int key){return Integer.hashCode(key) % nodes.length;}

        ListNode find(ListNode bucket, int key){
            ListNode node = bucket, prev = null;
            for(; node != null && node.key != key; node = node.next)
                prev = node;
            return prev;
        }

        class ListNode{
            int key, val;
            ListNode next;

            ListNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
    }
}
