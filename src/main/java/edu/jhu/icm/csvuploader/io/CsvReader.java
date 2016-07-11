package edu.jhu.icm.csvuploader.io;

import edu.jhu.icm.csvuploader.util.CsvEntry;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Reads CSVs.
 * Created by rliu14 on 7/8/16.
 */
public class CsvReader {

    private List<String> headers;
    private List<CsvEntry> entries;

    public CsvReader(String filename) throws IOException {

        headers = new ArrayList<>();
        entries = new ArrayList<>();

        Reader in = new FileReader(filename);
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
        Iterator<CSVRecord> i = records.iterator();
        CSVRecord r = i.next();

        for (String s : r) {
            headers.add(s.trim());
        }

        while (i.hasNext()) {
            entries.add(new CsvEntry(headers, i.next()));
        }
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<CsvEntry> getEntries() {
        return entries;
    }
}
