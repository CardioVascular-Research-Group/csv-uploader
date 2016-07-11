package edu.jhu.icm.csvuploader.io;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * Sandbox for experimenting with Apache HTTP Client.
 * Created by rliu14 on 7/11/16.
 */
public class HttpQueryTest {

    @Test
    public void testQuery() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();

        HttpPost query = new HttpPost("http://localhost:3001/api/suggest");
        StringEntity body = new StringEntity("{\"type\": \"metrics\"}");
        query.setEntity(body);
        query.setHeader("Content-Type", "application/json");

        HttpResponse response = client.execute(query);

        System.out.println(response);


        Scanner scanner = new Scanner(response.getEntity().getContent());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

    }

}
