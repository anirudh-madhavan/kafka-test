package com.zendesk.email;

import com.zendesk.email.kafka.KafkaEmailNotificationInterceptor;
import com.zendesk.core.config.factories.AppSettingsOptions;
import com.zendesk.core.kafka.consumers.KafkaConsumerVerticleBuilder;
import com.zendesk.core.starter.StarterApp;

public final class ServiceStarter {

  /**
   * Starts the kafka-test service.
   *
   * @param args any args to the running service.
   */
  public static void main(String[] args) {
    StarterApp
        .create("kafka-test", new AppSettingsOptions(), args)
        .withVerticle(KafkaConsumerVerticleBuilder.from()
            .withInterceptor(KafkaEmailNotificationInterceptor.class))
        .start();
  }
}
