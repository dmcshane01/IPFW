//Daniel DelyMcShane
//CS232
//April 20th, 2016
//Reads in ints from a file and prints out min max and average

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>

#define ARRAYSIZE 7 //define arraysize for readiblity

//function max finds the max number in array and returns it
int max(int *arr)
{
	int max = arr[0];
	int i;
	for(i = 0; i < ARRAYSIZE ; i++)
	{
		if(arr[i] > max)
		{
			max = arr[i];
		}
	}

	return max;

}

//finds smallest number in array and returns it
int min(int *arr)
{
	int min = arr[0];
	int i;
	for(i = 0; i < ARRAYSIZE; i++)
	{
		if(arr[i] < min)
		{
			min = arr[i];
		}
	}

	return min;

}

//average returns the average of the array
double  average(int *arr)
{
	double average = 0;
	double total = 0;
	int i;
	for(i = 0; i < ARRAYSIZE; i++)
	{
		total = total + arr[i];
	}

	average = total / ARRAYSIZE;
	return average;
}


int main()
{

	FILE *fp = fopen("num.txt", "r"); //open file to read

	int arr[7];
	int i;

	for(i = 0; i < ARRAYSIZE; i++) //read numbers from file
	{
		fscanf(fp,"%d", &arr[i]);
	}

	//calls prints out min max and average of array
	printf("\nMax = %d", max(arr));
	printf("\nMin = %d", min(arr));
	printf("\nAverage = %f", average(arr));

}