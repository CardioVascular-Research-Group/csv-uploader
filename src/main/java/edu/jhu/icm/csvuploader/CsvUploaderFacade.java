package edu.jhu.icm.csvuploader;


import edu.jhu.icm.csvuploader.io.CsvReader;
import edu.jhu.icm.csvuploader.tsdb.TsdbUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Facade for CSV uploader.
 * Created by rliu14 on 7/8/16.
 */
@Component
public class CsvUploaderFacade {

    @Autowired
    private TsdbUploader tsdbUploader;

    public CsvUploaderFacade() {

    }

    public void uploadFile(String filename, String subjectId) throws IOException {
        CsvReader reader = new CsvReader(filename);
    }

}
