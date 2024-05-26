package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DemoComponent {

  public void test() {
    String submissionId = ThreadContext.get("submissionId");
    log.info("Up and running. submissionId: {}", submissionId);
  }
}
