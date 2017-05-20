/* 
   Anthony Doan
   CSc130 Assignment 1
   Due 2/20/2015
*/   

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class merge_sort{
	public static void main(String[] args){
		int arrSize; // size of the array
		
		Scanner input = new Scanner(System.in);
		System.out.println("Input:"); // how many inputs?
		arrSize = input.nextInt();
      System.out.println();
	
		int [] MaxArray = new int[arrSize]; // create array with the size of first input
	
		for(int i=0;i < MaxArray.length;i++){
			int next = input.nextInt();
			MaxArray[i] = next; //store list of unsorted numbers
		}
		//merge sort the array
		MaxArray = merge_sort(MaxArray); 
		
		System.out.println("\nOutput:");
      System.out.print("The sorted result is: ");
      for(int i =0; i< MaxArray.length; i++){
			System.out.print(MaxArray[i] + " "); //output the sorted array
		}	
		
		// median
		double median = 0;
		if( (MaxArray.length) % 2 == 0){  // checks if the array length is an even number
			int mid1 = (MaxArray.length-1)/2; //getting middle values
			int mid2 = MaxArray[mid1+1];
			int mid3 = MaxArray[mid1];
			median = (double)(mid2 + mid3)/2; //the mean of the two middle values
			System.out.println("\nThe median is: " + median);				
		}else{ // for odd array length just take the middle cell
		int mid = MaxArray.length/2;
		System.out.println("\nThe median is: " +MaxArray[mid]);
		}
	}
	
	public static int [] merge_sort(int [] arr){
		if(arr.length <= 1){
			return arr;
		}
      // split the array into two arrays
		int mid = arr.length/2; 
		int [] left = new int [mid]; 
		int [] right;
      // whether odd or even will determine the length of the right array   
		if(arr.length %2 == 0){ 
			right = new int [mid];
		}else{
			right = new int[mid+1];
		}
		int [] result = new int[arr.length]; // creating a different array to store
			
		for(int i=0; i< mid; i++){ // left side
			left[i]= arr[i];
		}
		int x = 0;
			
		for(int j=mid; j< arr.length; j++){ // the right side
			if (x < right.length){
				right[x] = arr[j];
				x++;
			}
		}		
      // sorting the two arrays recursively	
		left = merge_sort(left);
		right = merge_sort(right);
		//patch together the left and right
		result = merge(left,right);
		return result;
	}
   
	public static int [] merge(int [] left, int [] right){
		int fullLength = left.length + right.length;
		int [] result = new int [fullLength]; //create array to store the merged array
		int indexL = 0; 
		int indexR = 0;
		int indexRes = 0;
		
		while(indexL < left.length || indexR < right.length){ // checking the length of right and left
			if(indexL < left.length && indexR < right.length){ 
				if(left[indexL] <= right[indexR]){ //compare and copy
					result[indexRes] = left[indexL];
					indexL++;
					indexRes++;		
				} else{
					result[indexRes] = right[indexR]; //compare and copy over
					indexR++;
					indexRes++;
				}
			}else if(indexL < left.length){ //checking if all left inputs were transfered
				result[indexRes] = left[indexL];
				indexL++;
				indexRes++;
			}else if(indexR < right.length){ //checking if all right inputs were transfered
				result[indexRes] = right[indexR];
				indexR++;
				indexRes++;
			}
		}
		return result; //return merged array
	}
}