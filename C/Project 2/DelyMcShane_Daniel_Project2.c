/*
* Name: Daniel DelyMcShane
* Login: cs232
* Date: April 2, 2016
* File: DelyMcShane_Daniel_Project2.c
* Instruction: README 
* This program uses a singly linked list to keep record of student files. Users can add, display, and delete student records. Program also writes the student info to a file upon termination
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define TRUE 1
#define FALSE 0

//define student struct
typedef struct student{

	char name[100];
	int year;
	char major[10];
	double gpa;
}Student;


//define node for Linked List
typedef struct node{

	Student *data;
	struct node *next;

}Node;


Node *head = NULL; //global variable for head of Linked List



//stringToLower takes a string as an argument and sets each character to lowercase
void stringToLower(char *str)
{
		int length = strlen(str);
		int i;
		for(i = 0; i < length; i++)
		{
			str[i] = tolower(str[i]);
		}

}

//addRecord takes the address of a Student struct as an argument and creates a node in the linked list and stores the Student
void addRecord(Student *add)
{
	Node *temp = head; //create a temp node at head node to traverse list

	
	Node *newNode = (Node*)malloc(sizeof(Node)); //allocate memory and create a new Node to store student data
	newNode->next = NULL; //Set link of node to NULL
	newNode->data = add; //Link the new node to the new Student

	if(temp == NULL) //if temp is NULL then the head is NULL, so we make that our head
	{
		head = newNode;
	}
	else
	{
		while(temp->next != NULL) //gets our temp node to last Node in list
		{
			temp = temp->next;
		}

		temp->next = newNode; //Link the tail of the Linked List to the new node

	}

}


//deleteRecord takes a string as an argument and then checks to see if there is a matching record in the list and deletes it
void deleteRecord(char *name)
{

	
	Node *temp = head; //create temp node to traverse the list
	
	Node *deleteNode = NULL; //node to mark the node that needs deleted


	if(findName(name) == TRUE)//check to make sure name is in records
	{

		if(strcmp(head->data->name, name) == 0) //if the record is the head of the list
		{
			if(head->next != NULL) //if the head is not the only record in the list
			{
				head = head->next; //set the head node the the next in the list, removing the previous node from our list

				//temp = NULL; //set the temp head node to NULL to skip the while loop
			}
			else
				head = NULL; //if the head is the only node in the list just set it to NULL to remove record

			return;
		}

		while(temp != NULL) //This loop is for if there is more than one node in the list
		{

			if(strcmp(temp->next->data->name, name) == 0) //Each loop checks to see if the record is a match
			{
				deleteNode = temp->next;//if it is a match mark the node to be deleted

				if(deleteNode->next == NULL) //if node is last in list
				{
					temp->next = NULL; //remove link to node we want deleted
					break;
				}
				else //node is not last in list
				{
					temp->next = deleteNode->next; //sets the link of the leading node to the node after deleteNode
					break;
				}
	
			}
			
			temp = temp->next; //traverses through list each loop
		}


	}
		
}

//findName takes a string as an argument and checks to see if there is a matching record in the list using sequential search
int  findName(char *nameFind)
{

	Node *temp = head; //temp node to traverse list
	
	while(temp != NULL) //while still records in linked list
	{

		if (strcmp(temp->data->name, nameFind) == 0) //check to see if strings match
		{

			return TRUE;
		}
		temp = temp->next; //traverses linked list
	}

	return FALSE; //return false/0 if not found

}


//Prints menu to screen
void menu()
{


	printf("##############################################\n");
	printf("# Student Record Management system           #\n");
	printf("# Add a record ----Please press 'A' or 'a'   #\n");
	printf("# Display records --Please press 'D' or 'd'  #\n");
	printf("# Delete a record ----Please press 'E' or 'e'#\n");
	printf("# Exit --Please press 'X' or 'x'             #\n");
	printf("##############################################\n\n");

}

//displayAllRecords traverses the Linked list and prints out the info in each record
void displayAllRecords()
{

	Node *temp = head; //temp node to traverse list

	if(head == NULL) //list is empty
	{
		printf("SORRY. NO STUDENT’S RECORD CAN BE FOUND!");
	}
	else
	{

		while(temp != NULL)
		{
			printf("\nNAME: %s\nYEAR:: %d\nMAJOR: %s\nGPA: %.2f\n>>>>>>>>>>\n",temp->data->name, temp->data->year, temp->data->major, temp->data->gpa);
		
		temp = temp->next;
		}
	}
}

void writeToFile() //Appends to student records to txt file, or creates file and writes to it
{

	Node *temp = head;//to traverse list

	FILE *fp = fopen("StudentRecords.txt", "ab+"); //opens txt file or creates if not open

	while(temp != NULL)
	{
		fprintf(fp, "\nNAME: %s\nYEAR:: %d\nMAJOR: %s\nGPA: %.2f\n>>>>>>>>>>\n",temp->data->name, temp->data->year, temp->data->major, temp->data->gpa); //write student info to file
		
		temp = temp->next;
	}
	
	fclose(fp); //close file

}
int main(){

	
	char choice; //user-input to determine menu functions
	char inName[100]; //stores name input

	Student *stud; //declare stud as an address of a Student struct

	for(;;) //Infinite for loop to output menu
	{
		
	
		
		menu(); //output menu

		scanf(" %c", &choice); //get user input
		getchar();

		if(choice == 'A' || choice == 'a')//Add a student's record to Linked List
		{
			char name[100];
			int year;
			char major[10];
			double gpa;
			printf("\nEnter the student's name: \n");
			scanf(" %[^\n]s",name); //gets user input string and accepts white space characters for input
			printf("\nEnter the student's major: \n");
			scanf(" %[^\n]s", major);
			printf("\nEnter the student's year: \n");
			scanf("%d", &year);
			printf("\nEnter the student's GPA: \n");
			scanf("%lf", &gpa);
			
			if(findName(name) == TRUE) //dont add to list if name already exists in record
			{
				printf("SORRY. THE STUDENT ALREADY EXISTS!\n");
			}
			else
			{
				stringToLower(name); //store string in lower case
				stud = (Student*)malloc(sizeof(Student)); //allocate new memory for a new student struct and give address to stud
				
				//copy student into to Student record
				strcpy(stud->name, name); 
				strcpy(stud->major, major);
				stud->year = year;
				stud->gpa = gpa;
				
				//add new record to list
				addRecord(stud);
			}
			
		}
		else if(choice == 'd' || choice == 'D') //outputs student records
		{
			displayAllRecords();
		}
		else if(choice == 'e' || choice == 'E') //delete record
		{
			printf("Enter the student's name whos record you would like to delete\n");
			scanf(" %[^\n]s",inName);
			stringToLower(inName);
			deleteRecord(inName);
		}
		else if(choice == 'x' || choice == 'X') //terminate program
		{
			writeToFile();
			return 0;
		}
		else
			printf("Invalid input\n");
	}

}
