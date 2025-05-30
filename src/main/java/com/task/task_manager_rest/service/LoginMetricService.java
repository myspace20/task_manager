package com.task.task_manager_rest.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;


@Component
public class LoginMetricService {

        private final Counter customMetricCounter;

        public LoginMetricService(MeterRegistry meterRegistry) {
            customMetricCounter = Counter.builder("login_metric_counter")
                    .description("Number of login attempts")
                    .tags("authentication", "development")
                    .register(meterRegistry);
        }

        public void incrementCustomMetric() {
            customMetricCounter.increment();
        }
    }

