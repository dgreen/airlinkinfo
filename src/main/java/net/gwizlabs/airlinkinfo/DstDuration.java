package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "days",
  "nanosecondOfDay",
  "hours",
  "minutes",
  "seconds",
  "milliseconds",
  "subsecondTicks",
  "subsecondNanoseconds",
  "bclCompatibleTicks",
  "totalDays",
  "totalHours",
  "totalMinutes",
  "totalSeconds",
  "totalMilliseconds",
  "totalTicks",
  "totalNanoseconds"
})
@Generated("jsonschema2pojo")
public class DstDuration {

  @JsonProperty("days")
  private int days;

  @JsonProperty("nanosecondOfDay")
  private long nanosecondOfDay;

  @JsonProperty("hours")
  private int hours;

  @JsonProperty("minutes")
  private int minutes;

  @JsonProperty("seconds")
  private int seconds;

  @JsonProperty("milliseconds")
  private int milliseconds;

  @JsonProperty("subsecondTicks")
  private int subsecondTicks;

  @JsonProperty("subsecondNanoseconds")
  private int subsecondNanoseconds;

  @JsonProperty("bclCompatibleTicks")
  private long bclCompatibleTicks;

  @JsonProperty("totalDays")
  private double totalDays;

  @JsonProperty("totalHours")
  private int totalHours;

  @JsonProperty("totalMinutes")
  private int totalMinutes;

  @JsonProperty("totalSeconds")
  private int totalSeconds;

  @JsonProperty("totalMilliseconds")
  private long totalMilliseconds;

  @JsonProperty("totalTicks")
  private long totalTicks;

  @JsonProperty("totalNanoseconds")
  private long totalNanoseconds;

  @JsonProperty("days")
  public int getDays() {
    return days;
  }

  @JsonProperty("days")
  public void setDays(int days) {
    this.days = days;
  }

  @JsonProperty("nanosecondOfDay")
  public long getNanosecondOfDay() {
    return nanosecondOfDay;
  }

  @JsonProperty("nanosecondOfDay")
  public void setNanosecondOfDay(long nanosecondOfDay) {
    this.nanosecondOfDay = nanosecondOfDay;
  }

  @JsonProperty("hours")
  public int getHours() {
    return hours;
  }

  @JsonProperty("hours")
  public void setHours(int hours) {
    this.hours = hours;
  }

  @JsonProperty("minutes")
  public int getMinutes() {
    return minutes;
  }

  @JsonProperty("minutes")
  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

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

  @JsonProperty("subsecondTicks")
  public int getSubsecondTicks() {
    return subsecondTicks;
  }

  @JsonProperty("subsecondTicks")
  public void setSubsecondTicks(int subsecondTicks) {
    this.subsecondTicks = subsecondTicks;
  }

  @JsonProperty("subsecondNanoseconds")
  public int getSubsecondNanoseconds() {
    return subsecondNanoseconds;
  }

  @JsonProperty("subsecondNanoseconds")
  public void setSubsecondNanoseconds(int subsecondNanoseconds) {
    this.subsecondNanoseconds = subsecondNanoseconds;
  }

  @JsonProperty("bclCompatibleTicks")
  public long getBclCompatibleTicks() {
    return bclCompatibleTicks;
  }

  @JsonProperty("bclCompatibleTicks")
  public void setBclCompatibleTicks(long bclCompatibleTicks) {
    this.bclCompatibleTicks = bclCompatibleTicks;
  }

  @JsonProperty("totalDays")
  public double getTotalDays() {
    return totalDays;
  }

  @JsonProperty("totalDays")
  public void setTotalDays(double totalDays) {
    this.totalDays = totalDays;
  }

  @JsonProperty("totalHours")
  public int getTotalHours() {
    return totalHours;
  }

  @JsonProperty("totalHours")
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }

  @JsonProperty("totalMinutes")
  public int getTotalMinutes() {
    return totalMinutes;
  }

  @JsonProperty("totalMinutes")
  public void setTotalMinutes(int totalMinutes) {
    this.totalMinutes = totalMinutes;
  }

  @JsonProperty("totalSeconds")
  public int getTotalSeconds() {
    return totalSeconds;
  }

  @JsonProperty("totalSeconds")
  public void setTotalSeconds(int totalSeconds) {
    this.totalSeconds = totalSeconds;
  }

  @JsonProperty("totalMilliseconds")
  public long getTotalMilliseconds() {
    return totalMilliseconds;
  }

  @JsonProperty("totalMilliseconds")
  public void setTotalMilliseconds(long totalMilliseconds) {
    this.totalMilliseconds = totalMilliseconds;
  }

  @JsonProperty("totalTicks")
  public long getTotalTicks() {
    return totalTicks;
  }

  @JsonProperty("totalTicks")
  public void setTotalTicks(long totalTicks) {
    this.totalTicks = totalTicks;
  }

  @JsonProperty("totalNanoseconds")
  public long getTotalNanoseconds() {
    return totalNanoseconds;
  }

  @JsonProperty("totalNanoseconds")
  public void setTotalNanoseconds(long totalNanoseconds) {
    this.totalNanoseconds = totalNanoseconds;
  }
}
