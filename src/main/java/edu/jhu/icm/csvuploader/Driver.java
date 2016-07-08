package edu.jhu.icm.csvuploader;

import org.apache.commons.cli.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application to upload CSV files into OpenTSDB.
 * Created by rliu14 on 7/8/16.
 */
public class Driver {

    static Options options = new Options();

    /**
     * Registers command line interface options.
     */
    private static void registerOptions() {
        options.addOption("f", "filename", true, "File to read");
    }

    public static void main(String[] args) {

        registerOptions();

        CommandLineParser parser = new BasicParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String filename = cmd.getOptionValue("filename");

            ApplicationContext context =  new AnnotationConfigApplicationContext(ApplicationConfigs.class);
            CsvUploaderFacade facade = (CsvUploaderFacade)context.getBean("csvUploaderFacade");


        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }

    }
}
