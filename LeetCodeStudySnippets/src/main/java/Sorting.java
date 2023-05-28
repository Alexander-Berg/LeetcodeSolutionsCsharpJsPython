import java.io.OptionalDataException;
import java.util.*;

import static jdk.vm.ci.code.CodeUtil.K;

public class Sorting {

    public class SortingExample {
        public void sortByLength(String[] arr) {
            // Sorts a list of string by length of each string
         //   Arrays.sort(array(), new StringCompare());
        }
    }

    public class StringCompare implements Comparator<String> {
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            }
            return 0;
        }
    }
//Fast and Unstable
    public class SelectionSort {
        public void selectionSort(int[] arr) {
            // Mutates arr so that it is sorted via selecting the minimum element and
            // swapping it with the corresponding index
            int min_index;
            for (int i = 0; i < arr.length; i++) {
                min_index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min_index]) {
                        min_index = j;
                    }
                }
                // Swap current index with minimum element in rest of list
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
    }
    //(VerySlow and Stable Sorting)
    public class BubbleSort {
        public void bubbleSort(int[] arr) {
            // Mutates arr so that it is sorted via swapping adjacent elements until
            // the arr is sorted.
            boolean hasSwapped = true;
            while (hasSwapped) {
                hasSwapped = false;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] > arr[i + 1]) {
                        // Swap adjacent elements
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        hasSwapped = true;
                    }
                }
            }
        }
    }
    //For Small Arrays or Inputs,Stable
    public class InsertionSort {
        public void insertionSort(int[] arr) {
            // Mutates elements in arr by inserting out of place elements into appropriate
            // index repeatedly until arr is sorted
            for (int i = 1; i < arr.length; i++) {
                int currentIndex = i;
                while (currentIndex > 0 && arr[currentIndex - 1] > arr[currentIndex]) {
                    // Swap elements that are out of order
                    int temp = arr[currentIndex];
                    arr[currentIndex] = arr[currentIndex - 1];
                    arr[currentIndex - 1] = temp;
                    currentIndex -= 1;
                }
            }
        }
    }

    class InsertionSortList {
        public LinkedList.ListNode insertionSortList(LinkedList.ListNode head) {
            LinkedList.ListNode dummy = new LinkedList.ListNode();
            LinkedList.ListNode curr = head;

            while (curr != null) {
                // At each iteration, we insert an element into the resulting list.
                LinkedList.ListNode prev = dummy;

                // find the position to insert the current node
                while (prev.next != null && prev.next.val <= curr.val) {
                    prev = prev.next;
                }

                LinkedList.ListNode next = curr.next;
                // insert the current node to the new list
                curr.next = prev.next;
                prev.next = curr;

                // moving on to the next iteration
                curr = next;
            }

            return dummy.next;
        }
    }
    //Fast,Not Stable, expensive Sorting
    public class HeapSorting {
        public void heapSort(int[] arr) {
            // Mutates elements in lst by utilizing the heap data structure
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, arr.length, i);
            }

            for (int i = arr.length - 1; i > 0; i--) {
                // swap last element with first element
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                // note that we reduce the heap size by 1 every iteration
                maxHeapify(arr, i, 0);
            }
        }

        private void maxHeapify(int[] arr, int heapSize, int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;
            if (left < heapSize && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                maxHeapify(arr, heapSize, largest);
            }
        }
    }
    //Fast extra memory, good in big data with small range of integers
//sort elements from 0 to K
    public class CountingSort {
        public void countingSort(int[] arr) {
            // Sorts an array of integers where minimum value is 0 and maximum value is K
            int K = Arrays.stream(arr).max().getAsInt();
            int[] counts = new int[K + 1];
            for (int elem : arr) {
                counts[elem] += 1;
            }
            // we now overwrite our original counts with the starting index
            // of each element in the final sorted array
            int startingIndex = 0;
            for (int i = 0; i < K + 1; i++) {
                int count = counts[i];
                counts[i] = startingIndex;
                startingIndex += count;
            }

            int sortedArray[] = new int[arr.length];
            for (int elem : arr) {
                sortedArray[counts[elem]] = elem;
                // since we have placed an item in index counts[elem], we need to
                // increment counts[elem] index by 1 so the next duplicate element
                // is placed in appropriate index
                counts[elem] += 1;
            }

            // common practice to copy over sorted list into original arr
            // it's fine to just return the sortedArray at this point as well
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sortedArray[i];
            }
        }
    }


    public class CountingSort2 {
        public void countingSort(int[] arr) {
            // Sorts an array of integers (handles shifting of integers to range 0 to K)
            int shift = Arrays.stream(arr).min().getAsInt();
            int K = Arrays.stream(arr).max().getAsInt() - shift;
            int[] counts = new int[K + 1];
            for (int elem : arr) {
                counts[elem - shift] += 1;
            }
            // we now overwrite our original counts with the starting index
            // of each element in the final sorted array
            int startingIndex = 0;
            for (int i = 0; i < K + 1; i++) {
                int count = counts[i];
                counts[i] = startingIndex;
                startingIndex += count;
            }

            int sortedArray[] = new int[arr.length];
            for (int elem : arr) {
                sortedArray[counts[elem - shift]] = elem;
                // since we have placed an item in index counts[elem], we need to
                // increment counts[elem] index by 1 so the next duplicate element
                // is placed in appropriate index
                counts[elem - shift] += 1;
            }

            // common practice to copy over sorted list into original arr
            // it's fine to just return the sortedArray at this point as well
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sortedArray[i];
            }
        }
    }

    class MinimumAbsoluteDifference {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> res = new ArrayList();
            //sort elements
            Arrays.sort(arr);
            //init our min difference value
            int min = Integer.MAX_VALUE;
            //start looping over array to find real min element. Each time we found smaller difference
            //we reset resulting list and start building it from scratch. If we found pair with the same
            //difference as min - add it to the resulting list
            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                if (diff < min) {
                    min = diff;
                    res.clear();
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                } else if (diff == min) {
                    res.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
            return res;
        }
    }

    class QueryKthSmallestTrimmedNumber {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

            if (nums.length == 0)
                return new int[0];

            int[] result = new int[queries.length];
            int strLen = nums[0].length();
            int[] index = new int[1];

            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
                for (int i = index[0]; i < strLen; i++) {
                    if (nums[a].charAt(i) != nums[b].charAt(i))
                        return nums[b].charAt(i) - nums[a].charAt(i);
                }

                return b - a;
            });

            for (int i = 0; i < queries.length; i++) {
                index[0] = strLen - queries[i][1];
                queue.clear();

                for (int j = 0; j < nums.length; j++) {
                    queue.add(j);
                    if (queue.size() > queries[i][0])
                        queue.poll();
                }

                result[i] = queue.poll();
            }

            return result;
        }
    }

    class MaximumGap {
        public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            if(nums.length<2){
                return 0;
            }
            int c=0;
            for(int i=1;i<nums.length;i++){

                if(nums[i]-nums[i-1]>c){
                    c=nums[i]-nums[i-1];
                }
            }
            return c;

        }
    }
//For big amount of data to sort, stable, expensive
    public class LSDRadixSort {
        private static final int NUM_DIGITS = 10;

        public void initializeSortedArray(int size) {
            int[] mSortedArray = new int[0];
            if (mSortedArray == null) {
                mSortedArray = new int[size];
            }
        }

        public void countingSort(int[] arr, int placeVal) {
            // Sorts an array of integers where minimum value is 0 and maximum value is K
            int[] counts = new int[K];

            for (int elem : arr) {
                int current = elem / placeVal;
                counts[current % NUM_DIGITS] += 1;
            }

            // we now overwrite our original counts with the starting index
            // of each digit in our group of digits
            int startingIndex = 0;
            OptionalDataException mCounts = null;
            for (int i = 0; i < mCounts.length; i++) {
                int count = counts[i];
                counts[i] = startingIndex;
                startingIndex += count;
            }

            int[] sortedArray = new int[arr.length];
            for (int elem : arr) {
                int current = elem / placeVal;
                sortedArray[counts[current % NUM_DIGITS]] = elem;
                // since we have placed an item in index mCounts[current % NUM_DIGITS],
                // we need to increment mCounts[current % NUM_DIGITS] index by 1 so the
                // next duplicate digit is placed in appropriate index
                counts[current % NUM_DIGITS] += 1;
            }

            // common practice to copy over sorted list into original arr
            // it's fine to just return the sortedArray at this point as well
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sortedArray[i];
            }
        }

        public void radixSort(int[] arr) {
            int maxElem = Integer.MIN_VALUE;
            for (int elem : arr) {
                if (elem > maxElem) {
                    maxElem = elem;
                }
            }

            int placeVal = 1;
            while (maxElem / placeVal > 0) {
                countingSort(arr, placeVal);
                placeVal *= 10;
            }
        }
    }



    public class BucketSort {
        public void bucketSort(int[] arr, int K) {
            List<List<Integer>> buckets = new ArrayList<>(K);
            int shift = Arrays.stream(arr).min().getAsInt();
            int shft = 0;
            int maxValue = Arrays.stream(arr).max().getAsInt() - shft;
            // place elements into buckets
            double bucketSize = (double) maxValue / K;
            if (bucketSize < 1) {
                bucketSize = 1.0;
            }
            for (int elem : arr) {
                // same as K * arr[i] / max(lst)
                int index = (int) ((int) (elem - shift) / bucketSize);
                if (index == K) {
                    // put the max value in the last bucket
                    buckets.get(K - 1).add(elem);
                } else {
                    buckets.get(index).add(elem);
                }
            }

            // sort individual buckets
            for (List<Integer> bucket : buckets) {
                Collections.sort(bucket);
            }

            // convert sorted buckets into final output
            List<Integer> sortedList = new ArrayList<Integer>();
            for (List<Integer> bucket : buckets) {
                sortedList.addAll(bucket);
            }

            // perfectly fine to just return sortedList here
            // but common practice is to mutate original array with sorted elements
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sortedList.get(i);
            }
        }
    }
}


