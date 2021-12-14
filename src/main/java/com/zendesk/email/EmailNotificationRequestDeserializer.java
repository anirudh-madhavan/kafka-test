package com.zendesk.email;

import com.zendesk.core.kafka.serdes.ConsumerDeserializer;
import com.zendesk.email.model.EmailNotificationRequest;
import org.apache.kafka.common.protocol.types.Field.Str;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class EmailNotificationRequestDeserializer implements ConsumerDeserializer<String, String> {

  @Override
  public Deserializer<String> keyDeserializer() {
    return new StringDeserializer();
  }

  @Override
  public Deserializer<String> valueDeserializer() {
    return new StringDeserializer();
  }
}