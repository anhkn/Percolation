/* *****************************************************************************
 *  Operating system: MacOS
 *  Compiler: IntelliJ
 *  Text editor / IDE: IntelliJ
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithms, Part I or II: No
 *
 *  Hours to complete assignment (optional):
 *
 **************************************************************************** */

Programming Assignment 1: Percolation


/* *****************************************************************************
 *  Describe the data structures (i.e., instance variables) you used to
 *  implement the Percolation API.
 **************************************************************************** */

 I used 6 instance variables, including a boolean 2-D array to store the grid,
 4 ints to store the number of open sites, size of the grid, and to implement
 the virtual top and bottom sites. Finally, I also used the weighted quick union
 object data type.
 The boolean array is initally set to all false, as all the sites are closed. If
 a site is opened, site is set to true. The number of open sites is set to 0,
 and is incremented everytime a site is opened. The size is set by the client.
 The virtual top and bottom sites are set to be the first and last index in the
 weighted quick union array, which are 0 and the number of sites + 1. The
 weighted quick union object allows access to the API methods such as union, and
 find.


/* *****************************************************************************
 *  Briefly describe the algorithms you used to implement each method in
 *  the Percolation API.
 **************************************************************************** */
open(): opens the site (row, col) if it is not open already
isOpen(): checks if given site is open
isFull(): checks if given site is full
numberOfOpenSites(): returns the number of open sites
percolates(): checks if the system percolates

/* *****************************************************************************
 *  First, implement Percolation using QuickFindUF.
 *  What is the largest values of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 *
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
25      0.047
50      0.14
100     1.254
200     25.574
250     59.67

/* *****************************************************************************
 *  Describe the strategy you used for selecting the values of n.
 **************************************************************************** */
I began at 25, and kept doubling n until I passed 60 seconds, then reduced
number of trials until the time was under 60 seconds.


/* *****************************************************************************
 *  Next, implement Percolation using WeightedQuickUnionUF.
 *  What is the largest values of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 *
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
400          0.771
800          3.192
1600         17.457
2000         34.219
2400         58.155
 

/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */




/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */




/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */
