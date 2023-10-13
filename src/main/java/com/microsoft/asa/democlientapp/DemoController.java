package com.microsoft.asa.democlientapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Configuration
public class DemoController {

    @Value("${hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds:0}")
    private String hystrixTimeoutInMilliseconds;

    @Value("${feign.client.config.default.connectTimeout:0}")
    private String feignConnectTimeout;

    @Value("${feign.client.config.default.readTimeout:0}")
    private String feignReadTimeout;

    @Value("${security.oauth2.resource.user-info-uri:none}")
    private String securityUserInfoUri;

    @Value("${spring.sleuth.sampler.probability:0}")
    private String springSleuthSamplerProbability;

    @GetMapping("/hello")
    public String helloBase() {
        return "Hello";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/configs")
    public Map<String, String> getConfigs() {
        HashMap<String, String> configs = new HashMap<>();
        configs.put("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", hystrixTimeoutInMilliseconds);
        configs.put("feign.client.config.default.connectTimeout", feignConnectTimeout);
        configs.put("feign.client.config.default.readTimeout", feignReadTimeout);
        configs.put("security.oauth2.resource.user-info-uri", securityUserInfoUri);
        configs.put("spring.sleuth.sampler.probability", springSleuthSamplerProbability);
        return configs;
    }
}
