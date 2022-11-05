import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private double[] threshold; // percolation threshold
    private int numTrials; // number of trials

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        numTrials = trials;

        threshold = new double[trials];
        for (int i = 0; i < threshold.length; i++) { // store estimate for each trial
            // implements percolation
            Percolation perc = new Percolation(n); // initialize grid, all blocked
            while (!perc.percolates()) { // repeat until system percolates
                int row = StdRandom.uniform(n); // randomly open a blocked site
                int col = StdRandom.uniform(n);
                if (!perc.isOpen(row, col))
                    perc.open(row, col);
            }
            double estimate = (double) perc.numberOfOpenSites() / (n * n);
            threshold[i] = estimate;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
      return StdStats.mean(threshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(threshold);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - ((CONFIDENCE_95 * stddev())/Math.sqrt(numTrials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + ((CONFIDENCE_95 * stddev())/Math.sqrt(numTrials));
    }

    // test client (see below)
    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        PercolationStats test = new PercolationStats(Integer.parseInt(args[0]),
                                                     Integer.parseInt(args[1]));
        StdOut.println("mean()                    = " + test.mean());
        StdOut.println("stddev ()                 = " + test.stddev());
        StdOut.println("confidenceLow()           = " + test.confidenceLow());
        StdOut.println("confidenceHigh()          = " + test.confidenceHigh());
        StdOut.println("elapsed time              = " + sw.elapsedTime());
    }
}