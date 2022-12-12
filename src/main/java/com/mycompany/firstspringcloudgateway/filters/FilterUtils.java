package com.mycompany.firstspringcloudgateway.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.UUID;

@Component
public class FilterUtils {


    public static final String CORRELATION_ID = "tmx-correlation-id";

    public boolean isCorrelationId(HttpHeaders headers) {
        return headers.get(CORRELATION_ID) != null;
    }

    public String getCorrelationId(HttpHeaders headers) {
        List<String> value = headers.get(CORRELATION_ID);

        if (value == null) {
            return null;
        }

        return value.get(0);

    }

    public String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    public void setCorrelationId(ServerWebExchange exchange, String value) {
        exchange.mutate().request(
                exchange.getRequest().mutate()
                        .header(CORRELATION_ID, value)
                        .build()
        ).build();
    }
}
