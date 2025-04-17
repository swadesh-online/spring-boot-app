package com.veinchain.rest.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomRoute extends RouteBuilder {

    @Override
        public void configure() throws Exception {
        var cronExpression = "0 0/1 * * * ?"; // every minute
        // formatter :: https://www.freeformatter.com/cron-expression-generator-quartz.html

        fromF("quartz://myGroup/myTimerName?cron=%s", cronExpression)
                .routeId("cronTriggerRoute")
                .log("🚀 Triggered by Quartz Cron - ${date:now:yyyy-MM-dd HH:mm:ss}");
    }
}
