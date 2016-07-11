package edu.jhu.icm.csvuploader.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for CSV reader.
 * Created by rliu14 on 7/8/16.
 */
public class CsvReaderTest {

    @Test
    public void testCsvReader() {
        try {
            CsvReader csvReader = new CsvReader("test/STUDY_00001.2224BN1416911131.RFP.csv");

            assertEquals(23, csvReader.getHeaders().size());
            assertEquals("Date", csvReader.getHeaders().get(0));
            assertEquals("NBP_SYS", csvReader.getHeaders().get(1));
            assertEquals("NBP_DIAS", csvReader.getHeaders().get(2));

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
