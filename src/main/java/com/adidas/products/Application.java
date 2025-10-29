package com.adidas.products;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

import com.adidas.products.model.*;
import com.adidas.products.repository.ProductRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application implements ApplicationRunner {

    private static final Logger LOGGER = Logger.getLogger("Adidas");

    private final ProductRepository productRepository;

    @Value("${DATABASE_URI:defaultDatabase}")
    private String database;

    public Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.log(Level.INFO, "Application started with command-line arguments: {0}",
                Arrays.toString(args.getSourceArgs()));

        if (args.containsOption("DATABASE_URI")) {
            database = args.getOptionValues("DATABASE_URI").get(0);
            LOGGER.log(Level.CONFIG, "Injected Database Location: {0}", database);
        }

        LOGGER.log(Level.CONFIG, String.format("Reading Database from: %s", database));

    }
}
