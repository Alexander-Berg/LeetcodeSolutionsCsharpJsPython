import java.io.OptionalDataException;
import java.util.Arrays;

public class Array {
    // The actual code for creating an Array to hold DVD's.
    DVD[] dvdCollection = new DVD[15];

    // A simple definition for a DVD.
    public class DVD {
        public String name;
        public int releaseYear;
        public String director;

        public DVD(String name, int releaseYear, String director) {
            this.name = name;
            this.releaseYear = releaseYear;
            this.director = director;
        }

        public String toString() {
            return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
        }

        // Firstly, we need to actually create a DVD object for The Avengers.
        DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");

// Next, we'll put it into the 8th place of the Array. Remember, because we
// started numbering from 0, the index we want is 7.
//    dvdCollection[7] = avengersDVD;

        DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

// Put "The Incredibles" into the 4th place: index 3.
//    dvdCollection[3] = incrediblesDVD;

// Put "Finding Dory" into the 10th place: index 9.
//    dvdCollection[9] = findingDoryDVD;

// Put "The Lion King" into the 3rd place: index 2.
//    dvdCollection[2] = lionKingDVD;

        DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
        //   dvdCollection[3] = starWarsDVD;

        // Print out what's in indexes 7, 10, and 3.
// System.out.println(dvdCollection[7]);
// System.out.println(dvdCollection[10]);
// System.out.println(dvdCollection[3]);

// Will print:

// The Avengers, directed by Joss Whedon, released in 2012
// null
// Star Wars, directed by George Lucas, released in 1977

        int[] squareNumbers = new int[10];

// Go through each of the Array indexes, from 0 to 9.
// for (int i = 0; i < 10; i++) {
        // We need to be careful with the 0-indexing. The next square number
        // is given by (i + 1) * (i + 1).
        // Calculate it and insert it into the Array at index i.
        //      int square = (i + 1) * (i + 1);
        //      squareNumbers[i] = square;

        // Go through each of the Array indexes, from 0 to 9.
//for (int i = 0; i < 10; i++) {
        // Access and print what's at the i'th index.
        //      System.out.println(squareNumbers[i]);
    }

// Will print:
// 1
// 4
// 9
// 16
// 25
// 36
// 49
// 64
// 81
// 100

// For each VALUE in the Array.
// for( int square :squareNumbers)


    // Print the current value of square.
    //      System.out.println(square);

// Prints exactly the same as the previous example.


    // Create a new array with a capacity of 6.
    class ArrayLength<i> {
        int[] array = new int[6];

        // Current length is 0, because it has 0 elements.
        int length = 0;

        // Add 3 items into it.
        {
            for (
                    int i = 0;
                    i < 3; i++) {
                array[i] = i * i;
                // Each time we add an element, the length goes up by one.
                length++;
            }

//System.out.println("The Array has a capacity of "+array.length);
//System.out.println("The Array has a length of "+length);
        }

        class Solution {
            public int findMaxConsecutiveOnes(int[] nums) {
                // Hint: Initialise and declare a variable here to
                // keep track of how many 1's you've seen in a row.
                for (int i = 0; i < nums.length; i++) {
                    // Do something with element nums[i].
                }
                return 0;
            }
        }

        {


            // Declare an integer array of 6 elements
            int[] intArray = new int[6];
            int length = 0;

// Add 3 elements to the Array
            for (
                    int i = 0;
                    i < 3; i++) {
                intArray[length] = i;
                length++;
            }
        }

        {
            OptionalDataException intArray[] = null;
            for (int i = 0; i < intArray.length; i++) {
                System.out.println("Index " + i + " contains " + intArray[i]);
            }

        }

        {
// Insert a new element at the end of the Array. Again,
// it's important to ensure that there is enough space
// in the array for inserting a new element.
            int[] intArray = new int[0];
            int length = 0;
            intArray[length] = 10;
            length++;
        }

        // First, we will have to create space for a new element.
// We do that by shifting each element one index to the right.
// This will firstly move the element at index 3, then 2, then 1, then finally 0.
// We need to go backwards to avoid overwriting any elements.
        {
            int[] intArray = new int[0];
            for (
                    int i = 3;
                    i >= 0; i--) {
                intArray[i + 1] = intArray[i];
            }

// Now that we have created space for the new element,
// we can insert it at the beginning.
            intArray[0] = 20;


        }
    }
    // Say we want to insert the element at index 2.
// First, we will have to create space for the new element.
    {
        int[] intArray = new int[0];
        for (int i = 4; i >= 2; i--) {
            // Shift each element one position to the right.
            intArray[i + 1] = intArray[i];
        }

// Now that we have created space for the new element,
// we can insert it at the required index.
        intArray[2] = 30;
    }
    class Solution {
        public void duplicateZeros(int[] arr) {
            int nums[]=new int[arr.length];
            int i=0;
            int j=0;
            while(j<nums.length && i<arr.length){
                if(arr[i]==0){
                    nums[j]=0;
                    if(j+1<nums.length){
                        nums[j+1]=0;
                    }
                    j+=2;
                    i++;
                }
                else{
                    nums[j]=arr[i];
                    j++;
                    i++;
                }
            }
            for(int k=0; k<nums.length; k++){
                arr[k]=nums[k];
            }
        }
    }

    public static boolean linearSearch(int[] array, int length, int element) {
        // Check for edge cases. Is the array null or empty?
        // If it is, then we return false because the element we're
        // searching for couldn't possibly be in it.
        if (array == null || length == 0) {
            return false;
        }

        // Carry out the linear search by checking each element,
        // starting from the first one.
        for (int i = 0; i < length; i++) {
            // We found the element at index i.
            // So we return true to say it exists.
            if (array[i] == element) {
                return true;
            }
        }

        // We didn't find the element in the array.
        return false;
    }

    class Solution2 {
        public boolean validMountainArray(int[] A) {
            int N = A.length;
            int i = 0;

            // walk up
            while (i+1 < N && A[i] < A[i+1])
                i++;

            // peak can't be first or last
            if (i == 0 || i == N-1)
                return false;

            // walk down
            while (i+1 < N && A[i] > A[i+1])
                i++;

            return i == N-1;
        }
    }
       // In Place Arrays

    public int[] squareEven(int[] array, int length) {

        // Check for edge cases.
        if (array == null) {
            return array;
        }

        // Iterate through the original array.
        for(int i = 0; i < length; i++) {

            // If the index is an even number, then we need to square the element
            // and replace the original value in the Array.
            if (i % 2 == 0) {
                array[i] *= array[i];
            }
            // Notice how we don't need to do *anything* for the odd indexes? :-)
        }

        // We just return the original array. Some problems on leetcode require you
        // to return it, and other's dont.
        return array;
    }

}







