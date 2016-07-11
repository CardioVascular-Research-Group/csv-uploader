package edu.jhu.icm.csvuploader.tsdb;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Tsdb uploader component.
 * Created by rliu14 on 7/11/16.
 */
@Component
public class TsdbUploader {

    @Autowired
    private String tsdbRoot;

    @Autowired
    private Gson gson;


    public HttpResponse upload(JsonElement query) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost(tsdbRoot + "/api/put");
        StringEntity body = new StringEntity(gson.toJson(query), "UTF8");
        request.setEntity(body);
        request.setHeader("Content-Type", "application/json");

        return httpClient.execute(request);
    }

}
