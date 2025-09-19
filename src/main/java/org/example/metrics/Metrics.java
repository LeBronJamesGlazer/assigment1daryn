package org.example.metrics;

public class Metrics {
    private long comparisons;
    private long swaps;
    private long allocations;
    private int currentDepth;
    private int maxDepth;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        allocations = 0;
        currentDepth = 0;
        maxDepth = 0;
    }

    public void incComparisons() {
        comparisons++;
    }

    public void incSwaps() {
        swaps++;
    }

    public void incAllocations() {
        allocations++;
    }

    public void enterRecursion() {
        currentDepth++;
        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }
    }

    public void exitRecursion() {
        if (currentDepth > 0) {
            currentDepth--;
        }
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getAllocations() {
        return allocations;
    }

    public int getMaxDepth() {
        return maxDepth;
    }
}