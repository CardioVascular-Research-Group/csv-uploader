package edu.jhu.icm.csvuploader;


import com.google.gson.JsonElement;
import edu.jhu.icm.csvuploader.io.CsvReader;
import edu.jhu.icm.csvuploader.tsdb.TsdbUploader;
import edu.jhu.icm.csvuploader.util.HeaderMapping;
import edu.jhu.icm.csvuploader.util.QueryConverter;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;

/**
 * Facade for CSV uploader.
 * Created by rliu14 on 7/8/16.
 */
@Component
public class CsvUploaderFacade {

    @Autowired
    private TsdbUploader tsdbUploader;

    @Autowired
    private HeaderMapping headerMapping;

    @Autowired
    private QueryConverter queryConverter;

    public CsvUploaderFacade() {

    }

    public void uploadFile(String filename, String subjectId) throws IOException, ParseException {
        CsvReader reader = new CsvReader(filename);
        JsonElement query = queryConverter.convert(headerMapping.convert(reader.getHeaders()), reader.getEntries(), subjectId);
        HttpResponse response = tsdbUploader.upload(query);

    }

}
