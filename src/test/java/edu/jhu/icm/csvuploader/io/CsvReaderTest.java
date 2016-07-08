package edu.jhu.icm.csvuploader.io;

import org.junit.Test;

import java.io.IOException;

/**
 * Unit tests for CSV reader.
 * Created by rliu14 on 7/8/16.
 */
public class CsvReaderTest {

    @Test
    public void testCsvReader() {
        try {
            CsvReader csvReader = new CsvReader("data/STUDY_00001.2224BN1416911131.RFP.csv");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
