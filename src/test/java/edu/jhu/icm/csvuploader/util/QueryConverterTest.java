package edu.jhu.icm.csvuploader.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import edu.jhu.icm.csvuploader.TestConfigurations;
import edu.jhu.icm.csvuploader.io.CsvReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by rliu14 on 7/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {TestConfigurations.class, QueryConverter.class})
public class QueryConverterTest {

    @Autowired
    private String dateFormat;

    @Autowired
    private QueryConverter queryConverter;

    @Autowired
    private Gson gson;

    @Test
    public void testDateConversion() throws ParseException {

        DateFormat format = new SimpleDateFormat(dateFormat);
        Date date = format.parse("1994-02-01 00:00");

        assertEquals(760060800000L, date.getTime());

    }

    @Test
    public void testQueryConversion() throws IOException, ParseException {

        CsvReader csvReader = new CsvReader("test/STUDY_00001.2224BN1416911131.RFP.csv");
        JsonElement e = queryConverter.convert(csvReader.getHeaders(), csvReader.getEntries(), "test");
        System.out.println(gson.toJson(e));

    }
}
