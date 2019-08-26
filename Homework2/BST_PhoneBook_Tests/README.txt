This folder contains solutions to the Binary Search Trees (Trees-Exercise 4), List Phone book and BST phone book (Trees-Exercise 5) 
and TreeExercise (Trees-Exercise 6 --Unsorted lists vs Binary Search trees). 

For the file TreeExercise, the input is a zip file that contains files data.csv and search.txt.

While comparing the perfomance of an unsorted list with a binary search tree, below is a sample of the output of the program TreeExercise.

Time to insert 1 million records in the BST phone book: 1981 milliseconds
Time to insert 1 million records in the list phone book: 1205 milliseconds

The time to find a record in the list phone book: 7663 milliseconds
The time to find a record in the BST phone book: 21 milliseconds.

find() was called 1000 times in both cases.

Explanation for find().

a. find() in a binary search tree takes O(log N) with N the number of elements in the tree. 
For each call to find(), N gets divided in two.

b. find() in a list phone book takes O(N). Since the list is unsorted, you have to go through 
all elements to find the desired element. 
