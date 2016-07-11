package edu.jhu.icm.csvuploader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Configurations for unit tests.
 * Created by rliu14 on 7/11/16.
 */
@Configuration
public class TestConfigurations {

    @Bean
    public String dateFormat() {
        return "yyyy-MM-dd HH:mm";
    }

    @Bean
    public org.apache.commons.configuration2.Configuration configurationFile() throws ConfigurationException {
        Configurations configurations = new Configurations();
        return configurations.ini(new File("test/test.conf"));
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

}
