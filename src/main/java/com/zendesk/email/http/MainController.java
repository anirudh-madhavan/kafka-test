package com.zendesk.email.http;

import com.zendesk.core.http.Middleware;
import com.zendesk.core.http.middleware.insights.InsightLogging;
import com.zendesk.core.logging.ZendeskLogger;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import javax.inject.Inject;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = {@Inject})
class MainController implements Middleware {

  private static final ZendeskLogger logger = ZendeskLogger.forEnclosingClass();

  @Override
  public Router apply(Router router) {
    router.get("/api/hello").handler(ctx -> {
      ctx.response()
          .setStatusCode(200)
          .setChunked(true)
          .write(new JsonObject().put("message", "hello world!").encode())
          .end();
      InsightLogging.with(ctx, logger.atInfo()).log("We said hello!");
    });
    return router;
  }
}
