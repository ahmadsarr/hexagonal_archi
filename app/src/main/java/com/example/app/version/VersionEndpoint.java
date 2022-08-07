package com.example.app.version;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "version")
@Component
public class VersionEndpoint {

  private static final Map<String, Version> versions;

  static {
    versions = new HashMap<>();
    add(Version.builder()
        .versionName("0.1")
        .addNewFunctionality("Initiate template by follow hexagonal structure")
        .addNewFunctionality("Add monitoring endpoint")
        .addNewFunctionality("Add Cache Manager")
        .build());


  }

  private static void add(Version version) {
    versions.put(version.getVersionName(), version);

  }

  @ReadOperation
  public String versions() throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(versions.values());
  }
}
