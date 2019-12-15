# COMP482
Assignments for Algorithm Design Class

COMP 482 Project 2

Idea:
You will be given a set of integers and need to find the ith smallest using three methods1.  Sort the integers (maybe with a built in sort).2.  Use the natural variant of quick sort.3.  Use the median of medians method.

Input Format:
The input file will be called input2.txt and be in the same directory as the java and class files.The first line will be the values of i(the item desired) andN(the number of items) separated by white space.  

The remaining lines will consist of at least N additional integers (only the firs t N should be used - any extra ignored) separated by white space.

Output:The output will be the ith smallest value out of the N values calculated using the the three methods.  
In other words, the output should be the result you would get by sorting the N items and returning the item in array position i. A reminder of how the methods work.

SORT - use any sort (including Arrays.sort or Collections.sort) and return the ith item.

QUICKSORT Variant - choose a pivot in any way you wish (first item, random item, last item, ...)  and split the array into items smaller than the pivot and items larger than the pivot.  Recurse on the side that contains the ith item.  

MEDIAN OF MEDIANS - pseudocode

Details:The program must be written in Java.  The program must compile with the command javac *.java and run  with  the  command  java  Project2.   One  common  problem  students  have  with  this  is  placing  the  classes  into packages.  Don’t do this (just use the default package).  Output should be sent to System.out.  The program should be reasonably commented, indented, structured.  The program should be submitted by placing all files in a directory named after you, zipping this directory and submitting via canvas (ie if the professor was submitting then all files would be placed in a directory called JohnNoga, this directory would be zipped, and uploaded in canvas).
