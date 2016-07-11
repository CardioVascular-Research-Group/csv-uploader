package edu.jhu.icm.csvuploader.tsdb;

import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Tsdb uploader component.
 * Created by rliu14 on 7/11/16.
 */
@Component
public class TsdbUploader {

    private String tsdbRoot;

    @Autowired
    public TsdbUploader(String tsdbRoot) {
        this.tsdbRoot = tsdbRoot;
    }

    public void upload(JsonElement query) {

    }

}
