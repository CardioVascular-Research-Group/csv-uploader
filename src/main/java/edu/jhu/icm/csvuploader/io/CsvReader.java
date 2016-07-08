package edu.jhu.icm.csvuploader.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads CSVs.
 * Created by rliu14 on 7/8/16.
 */
public class CsvReader {

    private List<String> headers;

    public CsvReader(String filename) throws IOException {

        headers = new ArrayList<>();

        Reader in = new FileReader(filename);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);


    }

    public List<String> getHeaders() {
        return headers;
    }
}
