package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "timeZone",
  "currentLocalTime",
  "currentUtcOffset",
  "standardUtcOffset",
  "hasDayLightSaving",
  "isDayLightSavingActive",
  "dstInterval"
})
@Generated("jsonschema2pojo")
public class TimeZoneInfo {

  @JsonProperty("timeZone")
  private String timeZone;

  @JsonProperty("currentLocalTime")
  private String currentLocalTime;

  @JsonProperty("currentUtcOffset")
  private CurrentUtcOffset currentUtcOffset;

  @JsonProperty("standardUtcOffset")
  private StandardUtcOffset standardUtcOffset;

  @JsonProperty("hasDayLightSaving")
  private boolean hasDayLightSaving;

  @JsonProperty("isDayLightSavingActive")
  private boolean isDayLightSavingActive;

  @JsonProperty("dstInterval")
  private DstInterval dstInterval;

  @JsonProperty("timeZone")
  public String getTimeZone() {
    return timeZone;
  }

  @JsonProperty("timeZone")
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  @JsonProperty("currentLocalTime")
  public String getCurrentLocalTime() {
    return currentLocalTime;
  }

  @JsonProperty("currentLocalTime")
  public void setCurrentLocalTime(String currentLocalTime) {
    this.currentLocalTime = currentLocalTime;
  }

  @JsonProperty("currentUtcOffset")
  public CurrentUtcOffset getCurrentUtcOffset() {
    return currentUtcOffset;
  }

  @JsonProperty("currentUtcOffset")
  public void setCurrentUtcOffset(CurrentUtcOffset currentUtcOffset) {
    this.currentUtcOffset = currentUtcOffset;
  }

  @JsonProperty("standardUtcOffset")
  public StandardUtcOffset getStandardUtcOffset() {
    return standardUtcOffset;
  }

  @JsonProperty("standardUtcOffset")
  public void setStandardUtcOffset(StandardUtcOffset standardUtcOffset) {
    this.standardUtcOffset = standardUtcOffset;
  }

  @JsonProperty("hasDayLightSaving")
  public boolean isHasDayLightSaving() {
    return hasDayLightSaving;
  }

  @JsonProperty("hasDayLightSaving")
  public void setHasDayLightSaving(boolean hasDayLightSaving) {
    this.hasDayLightSaving = hasDayLightSaving;
  }

  @JsonProperty("isDayLightSavingActive")
  public boolean isIsDayLightSavingActive() {
    return isDayLightSavingActive;
  }

  @JsonProperty("isDayLightSavingActive")
  public void setIsDayLightSavingActive(boolean isDayLightSavingActive) {
    this.isDayLightSavingActive = isDayLightSavingActive;
  }

  @JsonProperty("dstInterval")
  public DstInterval getDstInterval() {
    return dstInterval;
  }

  @JsonProperty("dstInterval")
  public void setDstInterval(DstInterval dstInterval) {
    this.dstInterval = dstInterval;
  }
}
