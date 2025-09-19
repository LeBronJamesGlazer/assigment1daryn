package org.example.metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVWriter implements AutoCloseable {
    private final PrintWriter writer;
    private boolean headerWritten = false;

    public CSVWriter(String filename) throws IOException {
        this.writer = new PrintWriter(new FileWriter(filename, true));
    }

    public void writeHeader() {
        if (!headerWritten) {
            writer.println("algorithm,n,seed,time_ns,max_depth,comparisons,swaps,allocations,extra_info");
            headerWritten = true;
        }
    }

    public void writeRow(
            String algorithm,
            int n,
            long seed,
            long timeNs,
            Metrics metrics,
            String extraInfo
    ) {
        writer.printf(
                "%s,%d,%d,%d,%d,%d,%d,%d,%s%n",
                algorithm,
                n,
                seed,
                timeNs,
                metrics.getMaxDepth(),
                metrics.getComparisons(),
                metrics.getSwaps(),
                metrics.getAllocations(),
                extraInfo == null ? "" : extraInfo
        );
    }

    @Override
    public void close() {
        writer.flush();
        writer.close();
    }
}