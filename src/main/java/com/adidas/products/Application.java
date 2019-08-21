package com.adidas.products;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class Application implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    @Value("${DATABASE_URI}")
    private String database;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /* (non-Javadoc)
     * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.log(Level.INFO, "Application started with command-line arguments: {}",
                Arrays.toString(args.getSourceArgs()));
        LOGGER.log(Level.INFO, "NonOptionArgs: {}", args.getNonOptionArgs());
        LOGGER.log(Level.CONFIG, "OptionNames: {}", args.getOptionNames());

        for (String name : args.getOptionNames()) {
            LOGGER.log(Level.CONFIG, String.format("arg-%s = %s", name , args.getOptionValues(name)));
        }

        boolean containsOption = args.containsOption(database);
        if (containsOption) {
            LOGGER.log(Level.CONFIG, "Injected Database Location: ", args.getOptionValues(database));
            database = args.getOptionValues(database).get(0);
        }
        LOGGER.log(Level.CONFIG, String.format("Reading Database from: %s", database));
    }

}
