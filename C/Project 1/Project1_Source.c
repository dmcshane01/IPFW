/*
* Name: Daniel DelyMcShane
* Login: cs232
* Date: 2/22/2016
* File: project1.c
* Sources of Help:The C programming language
* The program reads in an upper bound and lower bound from command line and prints out all prime numbers
* in between
*/


#include <stdio.h>
#include <string.h>

#define TRUE 1		//since C doesn't support boolean we use 1 as TRUE and 0 as FALSE
#define FALSE 0

int is_prime(int n); //declare function

int main(int argc, char *argv[])
{

	int lowerBound = atoi(argv[1]); //read in lower bound from command line
	int upperBound = atoi(argv[2]);//upper bound from command line
	int i;

	for(i = lowerBound; i <= upperBound; i++)
	{
		if(is_prime(i) == TRUE) //if function returns true we print out the integer that was used as arguement
		{
			printf("%d\n",i);
		}

	}

}

int is_prime(int n) 
{
	if(n <= 1) //if N is less than or equal to 1 it is not prime
	{
		return FALSE;
	}
	else if(n <= 3) //if its 2 or 3 its prime
	{
		return TRUE;
	}
	else if(n%2 == 0 || n%3 == 0) //if it is divisible by 2 or 3 it is not prime
	{
		return FALSE;
	}
	else
	{
		int a = 5;
		while((a*a) <= n)
		{
			if(n%a == 0 || n%(a+2) == 0)
			{
				return FALSE;
			}
			a = a+6;
		}
		return TRUE;
	}
}