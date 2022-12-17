package com.mycompany.firstspringcloudgateway.filters;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// @Order(1)
// @Component
@RequiredArgsConstructor
public class TrackingPreFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(TrackingPreFilter.class);
    private final FilterUtils filterUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders headers = exchange.getRequest().getHeaders();

        if (filterUtils.isCorrelationId(headers)) {

            logger.debug("tmx-correlation-id found in request: {}", filterUtils.getCorrelationId(headers));
        } else {

            String uuid = filterUtils.generateCorrelationId();
            filterUtils.setCorrelationId(exchange, uuid);
            logger.debug("tmx-correlation-id added to request: {}", uuid);
        }

        return chain.filter(exchange);
    }

}
