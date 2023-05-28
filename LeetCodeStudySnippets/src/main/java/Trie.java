import java.util.*;

public class Trie {
    public class MaxXor2NumbersinArray {
        public int findMaximumXOR(int[] nums) {
            int max = 0, mask = 0;
            for(int i = 31; i >= 0; i--){
                mask = mask | (1 << i);
                Set<Integer> set = new HashSet<>();
                for(int num : nums){
                    set.add(num & mask);
                }
                int tmp = max | (1 << i);
                for(int prefix : set){
                    if(set.contains(tmp ^ prefix)) {
                        max = tmp;
                        break;
                    }
                }
            }
            return max;
        }
    }

    class PalindromePairs {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> ret = new ArrayList<>();
            if (words == null || words.length < 2) return ret;
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i=0; i<words.length; i++) map.put(words[i], i);
            for (int i=0; i<words.length; i++) {
                // System.out.println(words[i]);
                for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                    String str1 = words[i].substring(0, j);
                    String str2 = words[i].substring(j);
                    if (isPalindrome(str1)) {
                        String str2rvs = new StringBuilder(str2).reverse().toString();
                        if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(map.get(str2rvs));
                            list.add(i);
                            ret.add(list);
                            // System.out.printf("isPal(str1): %s\n", list.toString());
                        }
                    }
                    if (isPalindrome(str2)) {
                        String str1rvs = new StringBuilder(str1).reverse().toString();
                        // check "str.length() != 0" to avoid duplicates
                        if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(i);
                            list.add(map.get(str1rvs));
                            ret.add(list);
                            // System.out.printf("isPal(str2): %s\n", list.toString());
                        }
                    }
                }
            }
            return ret;
        }

        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left++) !=  str.charAt(right--)) return false;
            }
            return true;
        }
    }


    class MapSum {
        HashMap<String, Integer> map;
        TrieNode root;
        public MapSum() {
            map = new HashMap();
            root = new TrieNode();
        }
        public void insert(String key, int val) {
            int delta = val - map.getOrDefault(key, 0);
            map.put(key, val);
            TrieNode cur = root;
            cur.score += delta;
            for (char c: key.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
                cur.score += delta;
            }
        }
        public int sum(String prefix) {
            TrieNode cur = root;
            for (char c: prefix.toCharArray()) {
                cur = cur.children.get(c);
                if (cur == null) return 0;
            }
            return cur.score;
        }
    }
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

class ReplaceWords {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode2 trie = new TrieNode2();
        for (String root: roots) {
            TrieNode2 cur = trie;
            for (char letter: root.toCharArray()) {
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode2();
                cur = cur.children[letter - 'a'];
            }
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        for (String word: sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode2 cur = trie;
            for (char letter: word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}

    class TrieNode2 {
        TrieNode2[] children;
        String word;
        TrieNode2() {
            children = new TrieNode2[26];
        }
    }


}
