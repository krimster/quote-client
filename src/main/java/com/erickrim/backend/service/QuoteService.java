package com.erickrim.backend.service;

import com.erickrim.backend.persistence.domain.Quote;
import com.erickrim.backend.persistence.domain.QuoteLine;
import com.erickrim.backend.persistence.repositories.QuoteRepository;
import com.erickrim.backend.persistence.repositories.ValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Created by krime on 1/25/17.
 */
@Service
@Transactional(readOnly = true)
public class QuoteService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(QuoteService.class);

    @Value("${spring.quote.url}")
    private String quoteUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private QuoteRepository quoteRepository;

    @Transactional
    @Scheduled(fixedRate=10000)
    public void getQuote() {

        Quote quote = restTemplate.getForObject(quoteUrl, Quote.class);

        QuoteLine savedQuoteLine = valueRepository.findOne(quote.getValue().getId());

        if (savedQuoteLine == null) {
            quoteRepository.save(quote);
            LOG.info("Saved quote  {}" , quote.toString());
        }
    }


}
