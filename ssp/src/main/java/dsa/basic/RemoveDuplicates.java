package dsa.basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class RemoveDuplicates {

	//    {2,3,4,5,6}
	//    target = 5
	//    {2,3,4,6}
	//
	//    {2,3,4,5,5,6}
	//    target = 5
	//    {2,3,4,6}
	// Remove target element from the given array

	@Test
	public void test1()
	{
		int[] input = {2,3,4,5,6};
		int target = 5;

		Assert.assertArrayEquals(removeWithoutExtraSpace(input,target), new int[]{2,3,4,6});
	}

	@Test 
	public void test2() 
	{ 
		int[] input = {2,5,23,14,5,6}; 
		int target = 5;

		Assert.assertArrayEquals(removeWithoutExtraSpace(input,target), new int[]{2,23,14,6}); 
	}

	@Test 
	public void test3() 
	{ 
		int[] input = {2,3,4,6}; 
		int target = 5;
		Assert.assertArrayEquals(removeWithoutExtraSpace(input,target), input); 
	}


	//@Test 
	public void test4() 
	{ 
		int[] input = {5,5,5,5}; 
		int target = 5;
		Assert.assertArrayEquals(removeTargetSinglePass(input,target), new int[] {});
	}

	// Create a array list
	// Iterate the input array
	// If current element in the array not matches the target
	// Add to the list
	// Create a new array and push the items in list to new array
	// Return the created array
	private int[] removeTargetElementUsingList(int[] input, int target) 
	{
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < input.length; i++) 
		{
			if(input[i] != target) data.add(input[i]);

		}

		int[] returnData = new int[data.size()];
		for (int i = 0; i < data.size(); i++) 
		{
			returnData[i] = data.get(i);    
		}
		return returnData;
	}

	/*
	 * 1. Traverse Array
	 * 2. Find the Target Occurance Count
	 * 3. Create a new Array with Length of Original Array minus TOC
	 * 4. Add the elements from input array to new array without the target element
	 * 5. Return the new array
	 * 6. Else a null array gets returned
	 * 
	 */
	private int[] removeTargetUsingArray(int[] input, int target) 
	{
		int occuranceCount = 0;
		for (int i = 0; i < input.length; i++) 
		{
			if(input[i] == target) 
				occuranceCount++;
		}

		if (occuranceCount == 0)
			return input;

		if (occuranceCount == input.length)
			return new int[] {};

		int[] outputArray = new int[input.length-occuranceCount];

		occuranceCount = 0;
		for (int i = 0; i < input.length; i++) 
		{
			if(input[i] != target) 
				outputArray[occuranceCount++] = input[i];
		}
		System.out.println(Arrays.toString(outputArray));
		return outputArray;
	}

	private int[] removeTargetSinglePass(int[] input, int target) 
	{
		int occuranceCount = 0;
		int[] outputArray = new int[input.length];
		int index =0;

		for (int i = 0; i < input.length; i++) 
		{
			if(input[i] == target) 
				occuranceCount++;
			else 
				outputArray[index++] = input[i];
		}
		outputArray = Arrays.copyOfRange(outputArray, 0, outputArray.length-occuranceCount);

		System.out.println(Arrays.toString(outputArray));
		return outputArray;
	}

	private int[] removeWithoutExtraSpace(int[] input, int target) 
	{
		int ptr = 0;
		int count = 0;

		for (int i=0; i<input.length; i++)
		{
			if (input[i] != target)
			{
				input[ptr] = input [i];
				ptr++;
			}
		}

		System.out.println(Arrays.toString(input));
		return Arrays.copyOfRange(input, 0, ptr);

	}
}