package edu.jhu.icm.csvuploader.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public JsonArray convert(List<String> headers, List<CSVRecord> records, String subjectId) throws ParseException {
        JsonArray result = new JsonArray();

        JsonObject tags = new JsonObject();
        tags.addProperty("subject_id", subjectId);

        for (CSVRecord r : records) {
            Date date = dateFormat.parse(r.get(0));

            for (int c = 1; c < r.size(); c++) {
                String trimmedEntry = r.get(c).trim();
                if (trimmedEntry.length() > 0 && !trimmedEntry.equals("-999.9") && !trimmedEntry.equals("-888.8")) {
                    JsonObject query = new JsonObject();
                    query.addProperty("metric", headers.get(c));
                    query.addProperty("timestamp", date.getTime());
                    query.addProperty("value", Double.parseDouble(trimmedEntry));
                    query.add("tags", tags);
                    result.add(query);
                }
            }
        }

        return result;
    }
}
