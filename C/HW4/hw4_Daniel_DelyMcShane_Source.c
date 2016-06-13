/*
* Name: Daniel DelyMcShane
* Login: cs232
* Date: 02/12/2016
* File: hw4.c
* Sources of Help: Google, Stack Overflow, for how to skip white sace in the second scanf in while
* Temperature conversion program. User inputs number of converts they need to do and the convert type
*/

#include <stdio.h>

//F = C * 1.8 + 32.0
//C = (F – 32.0) / 1.8

//declare functions
double Convert_F_To_C(double far);
double Convert_C_To_F(double cel);


int main()
{

	int counter = 0; //counter for while loop

	//ask user for amount of temp conversions and store them in counter var
	printf("How many temperature conversions would you like to perform?: ");
	scanf("%d", &counter);
	getchar();

	//int i is iterator for while loop, temp stores user input and type stores temp type
	int i = 0;
	double temp = 0;
	char type;

	while( i < counter)
	{
		printf("[#%d] Enter the degree you want to convert: ", i + 1);
		scanf("%lf", &temp);
		getchar();
		printf("Is this a Fahrenheit or Celsius temperature? [F/C]:");
		scanf("%c", &type);
		getchar();
		
		//if statement checks for if user inputs cel or far, and if invalid runs loop again
		if(type == 'c' || type == 'C')
		{
			double f = Convert_C_To_F(temp);
			printf("%8.2f C = %8.2f F\n", temp,f );	
		}
		else if (type == 'f' || type == 'F')
		{
			double c = Convert_F_To_C(temp);
			printf("%8.2f F = %8.2f C\n", temp,c );
		}
		else
		{
			printf("Invalid temperature input");
			i--; //subtract one from iterator so that loop stays on the same iteration as the invalid input
		}

		i++;
	}

	return 0;	

}

double Convert_F_To_C(double far)
{

	double cel = (far - 32.0) / 1.8;

	return cel;
}

double Convert_C_To_F(double cel)
{
	double far = (cel * 1.8) + 32.0;
	
	return far;
}