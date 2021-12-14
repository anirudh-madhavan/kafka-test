package com.zendesk.email.http;

import com.zendesk.email.http.HttpControllers;
import com.zendesk.core.bindings.AbstractDiModule;
import com.zendesk.core.http.middleware.modules.HttpInsightsModule;

class HttpModule extends AbstractDiModule {

  @Override
  protected void configure() {
    install(new HttpInsightsModule());
    install(new HttpControllers());

  }
}