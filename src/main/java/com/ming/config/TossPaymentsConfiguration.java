package com.ming.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "toss.payments")
@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TossPaymentsConfiguration {

    private String clientKey;

    private String secretKey;

}
