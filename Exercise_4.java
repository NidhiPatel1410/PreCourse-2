// Time Complexity : Not sure
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this : Referred some documention and videos and coded but did not understood properly

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Your code here
        // length of two arrays to merge
        int n1 = m - l + 1;
        int n2 = r - m;

        // Declare 2 arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // For each of the two arrays, add values
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];

        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];

        }
        int i = 0, j = 0;
        int k = l;

        // Then compare two arrays and insert in original one to get the final sorted
        // array
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;

        }

        // For remaining elements in any of the one array, simply add all
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        // Write your code here
        // Call mergeSort from here

        if (l < r) {
            int m = (l + (r)) / 2;
            // Divide till it is single element
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted arrays
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}