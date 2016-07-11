package edu.jhu.icm.csvuploader;


import org.apache.commons.configuration2.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Facade for CSV uploader.
 * Created by rliu14 on 7/8/16.
 */
@Component
public class CsvUploaderFacade {

    @Autowired
    private Configuration configurationFile;

    public CsvUploaderFacade() {

    }

    public void uploadFile(String filename) {

    }

    public void setConfigurations(Configuration configurationFile) {
        this.configurationFile = configurationFile;
    }
}
