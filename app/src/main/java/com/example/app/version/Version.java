package com.example.app.version;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class Version {

  private String versionName;
  private List<String> newFunctionalities;
  private List<String> bugfixes;

  public static class VersionBuilder {

    public VersionBuilder() {
      versionName = StringUtils.EMPTY;
      newFunctionalities = new ArrayList<>();
      bugfixes = new ArrayList<>();
    }

    public VersionBuilder addNewFunctionality(String functionality) {
      newFunctionalities.add(functionality);
      return this;
    }

    public VersionBuilder addNewBugFix(String bugFix) {
      bugfixes.add(bugFix);
      return this;
    }

  }
}
