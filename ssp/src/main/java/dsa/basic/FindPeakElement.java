package dsa.basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class FindPeakElement {

	/*
	 * Input = int[]
	 * Output = Peak Element / Max element value (not index)
	 * Many occurances = 1st occurance
	 * If empty array = return exception
	 * Should not sort
	 * 
	 * [Sorted Array]
	 * [Non Sorted Array]
	 * [All Same Elements]
	 * [Repeated Peaks]
	 * [Empty Array]
	 * [with Negative Elements]
	 * 
	 */
	
	@Test
	public void test1()
	{
		int[] input = {12,3,42,105,36};
		Assert.assertEquals(findMaxElement(input), 105);
	}

	@Test
	public void test2()
	{
		int[] input = {12,3,-242,105,36};
		Assert.assertEquals(findMaxElement(input), 105);
	}
	
	@Test
	public void test3()
	{
		int[] input = {};
		Assert.assertEquals(findMaxElement(input), -999);
	}
	
	@Test
	public void test4()
	{
		int[] input = {1,2,3,4,5,88,99};
		Assert.assertEquals(findMaxElement(input), 99);
	}
	
	@Test
	public void test5()
	{
		int[] input = {99,2,99,4,5,88,99};
		Assert.assertEquals(findMaxElement(input), 99);
	}
	@Test
	public void test6()
	{
		int[] input = {11,11,11,11,11,11,11};
		Assert.assertEquals(findMaxElement(input), 11);
	}
	/* 
	 * 1. If empty return Exception
	 * 2. Max Value = first element in the array
	 * 3. Traverse the array from 2nd element till end of the array
	 * 4. If Max Value < Element In Array, Save the new element from Array to Max Value
	 * 5. End of the traversal, we will have te max element of the array in Max Value
	 */
	private int findMaxElement(int[] input) 
	{
		if (input.length == 0)
			return -999;

		if (input.length == 1)
			return input[0];

		int maxValue = input[0];

		for (int i = 1; i < input.length; i++) 
		{
			if (maxValue < input[i])
				maxValue = input[i];
		}
		return maxValue;
	}
}