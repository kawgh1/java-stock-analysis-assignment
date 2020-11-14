package aggregators;

import fileprocessors.StockFileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AggregatorProcessor<T extends Aggregator> {
    // this T represents any T Aggregator
    T aggregator;
    String file;

    public AggregatorProcessor(T aggregator, String file) {
        super();
        this.aggregator = aggregator;
        this.file = file;
    }

    public double runAggregator(int columnIndex) throws IOException {

        StockFileReader fileReader = new StockFileReader(file);
        List<String> lines = fileReader.readFileData();
        columnIndex--;

        for(String line : lines){
            String[] numbers = line.split(",");
            Double value = Double.parseDouble(numbers[columnIndex]);
            aggregator.add(value);
        }

        Double number = aggregator.calculate();
        return number;

    }

}
