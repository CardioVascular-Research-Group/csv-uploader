package edu.jhu.icm.csvuploader.util;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by rliu14 on 7/11/16.
 */
public class QueryConverterTest {

    private static String dateFormat = "yyyy-MM-dd HH:mm";

    @Test
    public void testDateConversion() throws ParseException {

        DateFormat format = new SimpleDateFormat(dateFormat);
        Date date = format.parse("1994-02-01 00:00");

        assertEquals(760060800000L, date.getTime());

    }
}
