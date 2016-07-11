package edu.jhu.icm.csvuploader.util;

import com.google.gson.JsonObject;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Converts CSV records into queries.
 * Created by rliu14 on 7/11/16.
 */
@Component
public class QueryConverter {

    private DateFormat dateFormat;

    @Autowired
    public QueryConverter(String dateFormat) {
        this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    public List<JsonObject> convert(List<String> headers, List<CSVRecord> records) {
        Map<String, List<Query>> queries; // Map between metrics and list of queries.
        List<JsonObject> result = new ArrayList<>();

        for (CSVRecord r : records) {

        }

        return result;
    }

    private static class Query {

    }
}
