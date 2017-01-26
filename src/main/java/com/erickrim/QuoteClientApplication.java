package com.erickrim;

import com.erickrim.backend.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuoteClientApplication implements CommandLineRunner {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(QuoteClientApplication.class);

    @Autowired
    private QuoteService quoteService;

	public static void main(String[] args) {
		SpringApplication.run(QuoteClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        quoteService.getQuote();
	}
}
