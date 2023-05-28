import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InPlaceArrayOperations {

    class ReplaceElementswithGreatestonRightSide {
        public int[] replaceElements(int[] arr) {
            int max=-1;
            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]>max){
                    int temp=max;
                    max=arr[i];
                    arr[i]=temp;
                }
                else
                    arr[i]=max;
            }
            return arr;
        }
    }
    class RemoveDuplicatesSortedArray {
        public int removeDuplicates(int[] nums) {
            if(nums.length == 0)
                return 0;

            int addIndex = 1; //index that unique characters will be inserted at

            for(int i = 0; i < nums.length - 1; i++) {

                if(nums[i] < nums[i + 1]){ //if true, num[i + 1] is a new unique number
                    nums[addIndex] = nums[i + 1];
                    addIndex++;
                }
            }
            return addIndex;
        }
    }
    public int BetterRepeatedDeletionAlgorithm(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }
    class MoveZeroes {
        public void moveZeroes(int[] nums) {

            int snowBallSize = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]==0){
                    snowBallSize++;
                }
                else if (snowBallSize > 0) {
                    int t = nums[i];
                    nums[i]=0;
                    nums[i-snowBallSize]=t;
                }
            }
        }
    }
    class SortArraybyParity {
        public int[] sortArrayByParity(int[] A) {
            Integer[] B = new Integer[A.length];
            for (int t = 0; t < A.length; ++t)
                B[t] = A[t];

            Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

            for (int t = 0; t < A.length; ++t)
                A[t] = B[t];
            return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
        }
    }
    class RemoveElemetinArray {
        public int removeElement(int[] nums, int val) {
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != val){
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
    }

    class HeightChecker {
        public int heightChecker(int[] heights) {
            int sort[] = heights.clone();
            Arrays.sort(heights);
            int count = 0;
            for(int i = 0;i<heights.length;i++){
                if (heights[i] != sort[i]){
                    count++;
                }
            }
            return count;

        }
    }
    class ThirdMaximumNumber {
        public int thirdMax(int[] nums) {
            // Sort the array in non-increasing order.
            Arrays.sort(nums);

            // Reverse array to make it non-increasing.
            for (int index = 0; index < nums.length / 2; ++index) {
                int temp = nums[index];
                nums[index] = nums[nums.length - 1 - index];
                nums[nums.length - 1 - index] = temp;
            }

            int elemCounted = 1;
            int prevElem = nums[0];

            for (int index = 1; index < nums.length; ++index) {
                // Current element is different from previous.
                if (nums[index] != prevElem) {
                    elemCounted += 1;
                    prevElem = nums[index];
                }

                // If we have counted 3 numbers then return current number.
                if (elemCounted == 3) {
                    return nums[index];
                }
            }

            // We never counted 3 distinct numbers, return largest number.
            return nums[0];
        }
    }
    class FindAllNumbersDisappearedArray {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();

            int i = 0;
            while (i < nums.length) {
                int position = nums[i] - 1;
                if (nums[i] != nums[position]) {
                    int temp = nums[i];
                    nums[i] = nums[position];
                    nums[position] = temp;
                } else {
                    i++;
                }
            }

            for (i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    list.add(i + 1);
                }
            }

            return list;
        }
    }
}
