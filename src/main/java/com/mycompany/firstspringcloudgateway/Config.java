package com.mycompany.firstspringcloudgateway;

import com.mycompany.firstspringcloudgateway.filters.FilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class Config {

    Logger logger = LoggerFactory.getLogger(Config.class);

    // @Bean
    // public GlobalFilter addCorrelationIdPostFilter(FilterUtils filterUtils) {
    //     return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(
    //             () -> {
    //                 HttpHeaders headers = exchange.getRequest().getHeaders();
    //                 String uuid = filterUtils.getCorrelationId(headers);
    //                 exchange.getResponse().getHeaders().add(FilterUtils.CORRELATION_ID, uuid);
    //
    //                 logger.debug("add correlation Id to response: {}", uuid);
    //             }
    //
    //     ));
    // }

}
