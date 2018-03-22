// Java Program to illustrate reading from Text File
// using Scanner Class
import java.io.File;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

public class MergeSort {
    static long startTime;
    static long endTime;
    public static void merge(int numbers [], int i, int j, int k) {
	int mergedSize = k - i + 1;       // Size of merged partition
	int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
	int mergePos = 0;                 // Position to insert merged number
	int leftPos = 0;                  // Position of elements in left partition
	int rightPos = 0;                 // Position of elements in right partition
	leftPos = i;                      // Initialize left partition position
	rightPos = j + 1;                 // Initialize right partition position

	    


	// Add smallest element from left or right partition to merged numbers
	while (leftPos <= j && rightPos <= k) {
	    if (numbers[leftPos] < numbers[rightPos]) {
		mergedNumbers[mergePos] = numbers[leftPos];
		++leftPos;
	    }
	    else {
		mergedNumbers[mergePos] = numbers[rightPos];
		++rightPos;
	    }
	    ++mergePos;
	}

	// If left partition is not empty, add remaining elements to merged numbers
	while (leftPos <= j) {
	    mergedNumbers[mergePos] = numbers[leftPos];
	    ++leftPos;
	    ++mergePos;
	}

	// If right partition is not empty, add remaining elements to merged numbers
	while (rightPos <= k) {
	    mergedNumbers[mergePos] = numbers[rightPos];
	    ++rightPos;
	    ++mergePos;
	}

	// Copy merge number back to numbers
	for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
	    numbers[i + mergePos] = mergedNumbers[mergePos];
	}
    }






    
    public static void mergeSort(int numbers [], int i, int k) {
	int j = 0;

	if (i < k) {
	    j = (i + k) / 2;  // Find the midpoint in the partition

	    // Recursively sort left and right partitions
	    mergeSort(numbers, i, j);
	    mergeSort(numbers, j + 1, k);

	    // Merge left and right partition in sorted order
	    merge(numbers, i, j, k);
	}
	endTime = System.currentTimeMillis();
    }

    public static void main(String [] args) {
	
	long totalExec=0;
	long runningTotal=0;
	int p=0;
	
	int myListSize = 50000;
	String myTestFileName ="test.txt";
	
        int numbers [] = new int [myListSize];
	try{
	    Scanner scan = new Scanner(new File(myTestFileName));
	    //scan.useDelimiter(Pattern.compile(";"));
	    int c = 0;
	    while (scan.hasNextInt()) {
		numbers[c++]= scan.nextInt();
	    }
	    
	}catch (FileNotFoundException ex) {
	}
	
	//int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
	final int NUMBERS_SIZE = myListSize;
	int i = 0;
	/*
	  System.out.print("UNSORTED: ");
	  for (i = 0; i < NUMBERS_SIZE; ++i) {
	  System.out.print(numbers[i] + " ");
	*/
	System.out.println();
	
	startTime = System.currentTimeMillis();
	mergeSort(numbers, 0, NUMBERS_SIZE - 1);
        
	
	/*
	  System.out.print("SORTED: ");
	  for (i = 0; i < NUMBERS_SIZE; ++i) {
	  System.out.print(numbers[i] + " ");
	  }
	*/
	totalExec = endTime - startTime;
	System.out.println(p +" Total execution time: " + (totalExec) );
    
    
    return;
    }
};



