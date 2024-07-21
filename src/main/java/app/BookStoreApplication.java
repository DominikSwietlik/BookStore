package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookStoreApplication {
    private static final Logger logger = LoggerFactory.getLogger(BookStoreApplication.class);

    public static void main(String[] args) {
        logger.info("Starting BookStore application...");
        SpringApplication.run(BookStoreApplication.class, args);
        logger.info("BookStore application started successfully.");
    }
}