Unbalanced BST
AVL Tree
HashTable
Insertion time 
(milliseconds)
40
34
32
Search time 
(milliseconds)
82
75
61


1)Who is in your group?
-Pawan (PK) Khatri & Pawan Chandra


2)How long did the project take?
-The project took a total of 6 hours. We met on two separate occasions for 3 hours each time and completed the project at a
nearby Starbucks.


3)Before you started, which data structure did you expect would be the fastest?
-We expected the AVL tree data structure to be the fastest.


4)Which data structure is the fastest?
-Based on the test results, the hash table data structure was the fastest comparing to the AVL tree data structure.


5)In general, which DataCounter dictionary implementation was "better": trees or hash
tables? Note that you will need to define "better" (ease of coding, ease of debugging,
memory usage, disk access patterns, runtime for average input, runtime for all input, etc.).
-In general, Hash Tables was the better DataCounter dictionary implementation because when storing data, it had a simple 
approach and it was easy to code. Figuring out collisions made it fun to use HashTables, which is another reason why it
is “better.”


6)Are there cases in which a particular data structure performs really well or badly in the
correlator? Enumerate the cases for each data structure.
-A particular data structure that performs poorly in the correlator is the unbalanced binary search tree. 
This structure is poor compared to the AVL tree or the Hash Table when sorting through and finding the frequency of each word.
An AVL tree and a Hash Table is more efficient due to the poor time complexity when a tree is unbalanced. 


7)Give a one to two paragraph explanation of whether or not you think Bacon wrote
-Shakespeare's plays based on the data you collected. No fancy statistical analysis here
(formal analysis comes later); keep it fun and simple.
There is little evidence to support the theory that Bacon was the writer for William Shakespeare. Their respective works have 
insignificant connection to one another, and different theories on Shakespeare's potential shadow writer only weakens any
suggestion that Bacon was responsible for Shakespeare's work.


8)Write Up your benchmarks (this is long). Your mission is to convince us that your
benchmark makes sense and that we should be interested in it if we are trying to
ascertain which data structure is better suited for your input. You will need to answer at
least the following (all formal analysis should answer something similar):
* What are you measuring?
* What is the definition of "better" given your measurement?
* The definition of “better” given our measurement is …
* Why is the measurement interesting in determining which is the superior algorithm for this project?
* What was your method of benchmarking?
* Our method of benchmarking consisted of …
* What were the sources of errors?
* What were your results?
* How did you interpret your results?
* What were your conclusions?
* Are there any interesting directions for future study?
You may attach this in a separate, non-plain-text file. If you do use a non-plaintext format
please ensure that the file extension matches the format. Also, please consider using
PDFs in place of proprietary formats (i.e .doc(x), .xls(x), .pages, .numbers, etc.) which will
just cause your grader extra headaches.


-The measurements of interest were the times for inserting and deleting elements from the AVL, HashTable, and BST data structure 
which was recorded as the time between the beginning and end of each operation. Errors in time measurements resulted from rounding
errors, and from differing memory allocation for each program run time. Additionally, there were errors in the java library because
we did not formally benchmark, meaning our comparisons of efficiency were not particularly effective. The HashTable 
implementation outperformed the other two implementations, a result which is congruous with online sources. AVL tree has an 
average worst case runtime of 0(log(n)) while HashTable's average worst case was 0(n). Meanwhile, HashTable's average case runtime 
is consistently 0(1). Meanwhile, Unbalanced Binary Tree is disregarded and is clearly inferior to both AVL Tree and HashTable. Both 
are efficient and practical for sorting data and their respective advantages and disadvantages should be compared when selecting the 
most efficient method.



9) What did you enjoy about this assignment? What did you hate? Could we have done anything better? 
-The assignment was really given the time. Both Pawan and I spent a lot of time before class working on this project. We were able to
get help from chegg and look at stackoverflow for guidence to get this far. We enjoyed working on the hash and avl portion of the coding
because it was somewhat easy to understand. Pawan and I are both taking 2 classes so if there was anything we could do better, it would 
be time management. 