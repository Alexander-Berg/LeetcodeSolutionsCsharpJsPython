import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DecisionTree {
    class CalculateMaximumInformationGain {
        public double calculateMaxInfoGain(double[] petal_length, String[] species) {
            int n = species.length;

            flower[] fs = new flower[n];
            for(int i=0; i<n ; i++){
                fs[i] = new flower(petal_length[i], species[i]);
            }

            Arrays.sort(fs);

            double startingEntropy = calculateEntropy(fs,0,n);

            if(startingEntropy==0.0){
                return 0;
            }

            double bestGain=0.0;

            for(int q=1; q<n; q++){
                if(fs[q].petal!= fs[q-1].petal){
                    double cutEntropy = ( calculateEntropy(fs,0,q)*q
                            + calculateEntropy(fs,q,n)*(n-q)) / n;
                    if(cutEntropy==0.0){
                        return startingEntropy;
                    }
                    bestGain = Math.max(bestGain, startingEntropy - cutEntropy);
                }
            }

            return bestGain;
        }

        class flower implements Comparable<flower>{
            double petal;
            String species;

            public flower(double petal, String species){
                this.petal = petal;
                this.species = species;
            }

            public int compareTo(flower b){
                double diff = this.petal - b.petal;

                if( diff > 0){
                    return 1;
                }else if(diff<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        }

        //this calculates entropy of a group. The group can be specified as the values
        // in the input array from index s up to (but not including) index t.
        public double calculateEntropy(flower[] input, int s, int t) {
            int n = t-s;

            HashMap<String, MutableInt> H = new HashMap<>();

            for(int i=s; i<t; i++){
                MutableInt q = H.get(input[i].species);
                if(q==null){
                    H.put(input[i].species, new MutableInt());
                }else{
                    q.increment();
                }
            }

            double totalEntropy=0;
            for(MutableInt a : H.values()){
                double prob = (double)a.get() / n;
                System.out.println(prob);
                totalEntropy -= prob * (Math.log(prob) / Math.log(2) );
                //change-of-base formula
            }

            return totalEntropy;
        }
    }

    //someone made this up on StackOverflow
//see https://stackoverflow.com/a/107987
//This makes HashMaps faster when you are using the "value" part of the
//key-value pair as a counter.
    class MutableInt {
        int value = 1; // note that we start at 1 since we're counting
        public void increment () { ++value;      }
        public int  get ()       { return value; }
    }

    class CalculateEntropy {
        public double calculateEntropy(int[] input) {
            double entropy = 0.0;
            double probability;

            List<Integer> tempList = new ArrayList<>();

            for (int tempValue : input) {
                if (!tempList.contains(tempValue)) {
                    tempList.add(tempValue);
                    double numCount = 0.0;
                    for (int anInput : input) {
                        if (tempValue == anInput) {
                            numCount++;
                        }
                    }

                    probability = numCount / input.length;
                    entropy += (-probability * (Math.log(probability) / Math.log(2)));
                }
            }

            return entropy;
        }
    }

   /* TreeNode build_decision_tree([samples]) {

        // base cases:
        - the target attributes of the samples are uniform
                - the current depth of tree exceeds the max_tree_depth
                - the number of samples is less than the minimal_node_size

        // 1). we create a leaf node and return.
        if (any of the above cases holds) {
            leaf_node = create_leaf_node([samples]);
            return leaf_node;
        }

        // 2). find the best attribute to split on, (also the best value to split)
        feature_to_split, split_value = find_best_split([samples]);

        // 3). split the samples list into two sublists
        left_samples, right_samples = split([samples], feature_to_split, split_value);

        // 4). create a decision node.
        new_node = create_node(feature_to_split, split_value);

        // 5). for each sublist, recursively call the function to create the subtrees.
        new_node.left = build_decision_tree(left_samples);
        new_node.right = build_decision_tree(right_samples);

        // 6). return the newly-created node
        return new_node;
    }
*/
}