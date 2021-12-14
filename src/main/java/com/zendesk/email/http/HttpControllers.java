package com.zendesk.email.http;

import com.zendesk.core.bindings.AbstractDiModule;
import com.zendesk.core.http.Middleware;

public class HttpControllers extends AbstractDiModule {

  @Override
  protected void configure() {
    bindMulti(Middleware.class).to(MainController.class);
  }
}
