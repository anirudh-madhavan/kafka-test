package com.zendesk.email.kafka;

import com.zendesk.core.kafka.consumers.KafkaConsumerInterceptor;
import com.zendesk.core.kafka.consumers.KafkaConsumers;
import com.zendesk.core.logging.ZendeskLogger;
import io.vertx.kafka.client.consumer.KafkaConsumerRecord;

public class KafkaEmailNotificationInterceptor implements KafkaConsumerInterceptor {

  private static final ZendeskLogger log = ZendeskLogger.forEnclosingClass();

  @Override
  public KafkaConsumers apply(KafkaConsumers consumers) {
    consumers.consumer("send_email", "email_notification")
        .subscribe(this::handle, this::handleError);
    return consumers;
  }

  public void handle(KafkaConsumerRecord<String, String> record) {
    log.atInfo().log("Message received: %s", record.record().value());
  }

  public void handleError(Throwable t) {
    log.atSevere().log("Error reading topic: %s", t.getMessage());
  }

}