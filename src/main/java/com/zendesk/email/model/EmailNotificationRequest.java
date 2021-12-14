package com.zendesk.email.model;

import lombok.Data;

@Data
public class EmailNotificationRequest {

  private String tweeterName;

  private String emailRecipient;

}
