package edu.jhu.icm.csvuploader;

import com.google.gson.Gson;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Annotated application configuration.
 * Created by rliu14 on 7/8/16.
 */
@Configuration
@ComponentScan(basePackages = "edu.jhu.icm.csvuploader")
public class ApplicationConfigs {

    @Bean
    public String version() {
        return "v1.0, updated 7/11/2016";
    }

    @Bean
    public String dateFormat() {
        return "yyyy-MM-dd HH:mm";
    }

    @Bean
    public org.apache.commons.configuration2.Configuration configurationFile() throws ConfigurationException {
        Configurations configurations = new Configurations();
        return configurations.ini(new File("csvuploader.conf"));
    }

    @Bean
    public String tsdbRoot(org.apache.commons.configuration2.Configuration configurationFile) { // Chaining dependency.
        return configurationFile.getString("tsdb-root");
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
