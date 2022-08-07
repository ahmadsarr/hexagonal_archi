package com.example.app.interceptor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class VisitorInterceptor implements HandlerInterceptor {

  private final MeterRegistry meterRegistry;
  private final Counter globalVisitorCter;
  

  @Autowired
  public VisitorInterceptor(MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
    this.globalVisitorCter = meterRegistry.counter("global.visitor.counter",
        "global.visitors.counter", "visitors");
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    globalVisitorCter.increment();
    return true;
  }
}
