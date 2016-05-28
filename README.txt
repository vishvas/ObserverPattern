PURPOSE: Implement Observer pattern on Binary Search Tree and update value of node using pattern. 

Description: Here total 3 trees are available. First One is original tree which is populated by reading the file and inserting the value in the tree, as value insert into the main tree backup-1 and backup-2 tree also inserted as they are observer of main tree. 
As per second argument value if it is even than, in main tree each node is updated by addition of that value. With that as per backup-1 is observer for even value it is also will be updated. For odd argument value main and backup-2 tree will be updated via observer. 

FILES: Driver.java, BST.java, FileProcessor.java, Node.java, ObserverI.java, SubjectI.java, BSTBuilder.java, EvenFilterImpl.java, OddEvenFilterI.java, OddFilterImpl.java

SAMPLE OUTPUT: Depends upon Input, However for input file:
10
30
25
5
3
4
6
7
35

Output:
3 4 5 6 7 10 25 30 35 
3 4 5 6 7 10 25 30 35 
3 4 5 6 7 10 25 30 35 
The sum of all the B-Numbers is: 125
The sum of all the B-Numbers is: 125
The sum of all the B-Numbers is: 125
8 9 10 11 12 15 30 35 45 
3 4 5 6 7 10 25 30 35 
8 9 10 11 12 15 30 35 45 
The sum of all the B-Numbers is: 175
The sum of all the B-Numbers is: 125
The sum of all the B-Numbers is: 175


COMPILE THE CODE: ant -buildfile src/build.xml all

RUN THE CODE: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 <Value to be add into each number like first element 3+5=8>

CHOICE OF DATA STRUCTURE: HashMap
->Complexity of Data Structure:
		
Space	O(n)
Search	O(1)
Insert	O(1) [Amortized]
Delete	O(1)
->Hashmap is unsynchorized key value pair storing of objects.
