import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {

    // instance variables
    private boolean[][] grid; // open or closed 2-D grid
    private int openSites; // number of sites open
    private int size; // length of the grid
    private int topSite = 0; // virtual top site
    private int bottomSite; // virtual bottom site
    private final QuickFindUF id; // uses weighted QU algorithm API

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        // initialize grid
        openSites = 0;
        size = n;
        grid = new boolean[n][n];
        bottomSite = n * n + 1;
        id = new QuickFindUF(n * n + 2);
    }
    // converts from 2d site to 1d union-find index
    private int convert(int row, int col) {
        return size * row + col + 1;
    }

    // check if valid index
    private void validate(int p) {
        int n = grid.length;
        if (p < 0 || p > n - 1) {
            throw new IllegalArgumentException("index " + p +
                           " is not between 0 and " + (n - 1));
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row);
        validate(col);
        if (grid[row][col]) return; // check if site already open
        grid[row][col]  = true;
        openSites++;
        // if top row
        if (row == 0)
            id.union(convert(row, col), topSite);
        // if bot row
        if (row == (size - 1))
            id.union(convert(row, col), bottomSite);

        // connect to neighbors
        if (row != 0) { // check if site above is open
            if (isOpen(row - 1, col))
                id.union(convert(row, col), convert(row - 1, col)); // connect them
        }

        if (col != (size - 1)) { // check if site right is open
            if (isOpen(row, col + 1))
                id.union(convert(row, col), convert(row, col + 1)); // connect them
        }
        if (row != (size - 1)) { // check if site below is open
            if (isOpen(row + 1, col))
                id.union(convert(row, col), convert(row + 1, col)); // connect them
        }
        if (col != 0) { // check if site left is open
            if (isOpen(row, col - 1))
                id.union(convert(row, col), convert(row, col - 1)); // connect them
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row);
        validate(col);
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row);
        validate(col);
        return id.find(topSite) == id.find(convert(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return id.find(topSite) == id.find(bottomSite);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(2);
        p.open(0, 1);
        p.open(1, 1);
        StdOut.print(p.percolates());
        StdOut.print(p.numberOfOpenSites());
        StdOut.print(p.isOpen(1, 1));
        StdOut.print(p.isFull(1, 1));
    }
}