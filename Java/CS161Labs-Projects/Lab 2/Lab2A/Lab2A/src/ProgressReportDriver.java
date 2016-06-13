import java.util.*;
import java.io.*; 
 
public class ProgressReportDriver {
	  public static void main(String[] args) throws IOException
	  {
		  Student tmpStudent;
		  
		  ProgressReport progressReport = new ProgressReport();
		  
		  progressReport.readInputFile();
		  progressReport.generateReport();
		  System.out.println("AFTER SORTING THE 2D ARRAY\n");
		  progressReport.sortByName();
		  progressReport.generateReport();
		  
		  System.out.println("SEARCH TEST");
		  
		  tmpStudent = null;
		  tmpStudent = progressReport.binarySearch(0, "Cooper_");
		  if (tmpStudent != null) 
			  System.out.println("Found " + tmpStudent.getName() +
					  "\tAverage = " + tmpStudent.getAverage() +
					  "\tGrade = " + tmpStudent.getGrade());
		  else System.out.println("Fail to find the student");

		  tmpStudent = null;
		  tmpStudent = progressReport.binarySearch(0, "Bronson"); //Bronson is in the second section, so doesn't find
		  if (tmpStudent != null) 
			  System.out.println("Found " + tmpStudent.getName() +
					  "\tAverage = " + tmpStudent.getAverage() +
					  "\tGrade = " + tmpStudent.getGrade());
		  else System.out.println("Fail to find the student");
		  
		  
		  
		  tmpStudent = null;
		  
		  tmpStudent = progressReport.binarySearch(1, "Diana__"); //Not in list
		  
		  
		  if (tmpStudent != null) 
			  System.out.println("Found " + tmpStudent.getName() +
					  "\tAverage = " + tmpStudent.getAverage() +
					  "\tGrade = " + tmpStudent.getGrade());
		  else System.out.println("Fail to find the student");
		  
		  
	  }
}