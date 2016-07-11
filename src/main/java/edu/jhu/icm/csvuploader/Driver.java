package edu.jhu.icm.csvuploader;

import org.apache.commons.cli.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

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
        Option version = new Option("v", "version", false, "Displays version information");

        Option filename = new Option("f", "filename", true, "File to read");
        Option subjectId = new Option("r", "subject-id", true, "Subject id");

        options.addOption(version);
        options.addOption(filename);
        options.addOption(subjectId);
    }

    private static void printHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("java -jar csvuploader.jar", options);
    }

    public static void main(String[] args) {

        registerOptions();

        CommandLineParser parser = new BasicParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            ApplicationContext context =  new AnnotationConfigApplicationContext(ApplicationConfigs.class);

            if (cmd.hasOption("version")) {
                String versionInfo = (String)context.getBean("version");
                System.out.println(versionInfo);

            } else if (cmd.hasOption("filename")) {
                String filename = cmd.getOptionValue("filename");
                String subjectId = filename;
                if (cmd.hasOption("subject-id")) subjectId = cmd.getOptionValue("subject-id");

                CsvUploaderFacade facade = (CsvUploaderFacade)context.getBean("csvUploaderFacade");
                facade.uploadFile(filename, subjectId);

            } else {
                printHelp();
            }

        } catch (ParseException | IOException | java.text.ParseException e) {
            System.err.println(e.getMessage());
        }

    }
}
