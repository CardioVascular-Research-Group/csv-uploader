package edu.jhu.icm.csvuploader.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Reads CSVs.
 * Created by rliu14 on 7/8/16.
 */
public class CsvReader {

    public CsvReader(String filename) throws IOException {

        Reader in = new FileReader(filename);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
        }
    }
}
