package client;

import aggregators.AggregatorProcessor;
import aggregators.MinAggregator;

import java.io.IOException;

public class AggregatorApp {

    public static void main(String[] args) throws IOException {
        MinAggregator agg = new MinAggregator();
        AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");
        double value = aggsProcessor.runAggregator(1);
        System.out.println(value);
    }
}
