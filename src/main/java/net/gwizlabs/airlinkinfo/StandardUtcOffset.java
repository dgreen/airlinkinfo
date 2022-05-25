package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"seconds", "milliseconds", "ticks", "nanoseconds"})
@Generated("jsonschema2pojo")
public class StandardUtcOffset {

  @JsonProperty("seconds")
  private int seconds;

  @JsonProperty("milliseconds")
  private int milliseconds;

  @JsonProperty("ticks")
  private long ticks;

  @JsonProperty("nanoseconds")
  private long nanoseconds;

  @JsonProperty("seconds")
  public int getSeconds() {
    return seconds;
  }

  @JsonProperty("seconds")
  public void setSeconds(int seconds) {
    this.seconds = seconds;
  }

  @JsonProperty("milliseconds")
  public int getMilliseconds() {
    return milliseconds;
  }

  @JsonProperty("milliseconds")
  public void setMilliseconds(int milliseconds) {
    this.milliseconds = milliseconds;
  }

  @JsonProperty("ticks")
  public long getTicks() {
    return ticks;
  }

  @JsonProperty("ticks")
  public void setTicks(long ticks) {
    this.ticks = ticks;
  }

  @JsonProperty("nanoseconds")
  public long getNanoseconds() {
    return nanoseconds;
  }

  @JsonProperty("nanoseconds")
  public void setNanoseconds(long nanoseconds) {
    this.nanoseconds = nanoseconds;
  }
}
