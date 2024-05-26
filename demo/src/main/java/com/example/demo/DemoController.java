package com.example.demo;

import io.opentelemetry.api.trace.Span;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class DemoController {

  private final DemoComponent demoComponent;

  @Autowired
  public DemoController(DemoComponent demoComponent) {
    this.demoComponent = demoComponent;
  }

  @GetMapping("/demo")
  public String demo() {
    ThreadContext.put("submissionId", "abcd");
    String traceId = Span.current().getSpanContext().getTraceId();
    log.info("traceId from code: {}", traceId);
    demoComponent.test();
    return "Hello from DemoController!";
  }
}