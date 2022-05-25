package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "dstName",
  "dstOffsetToUtc",
  "dstOffsetToStandardTime",
  "dstStart",
  "dstEnd",
  "dstDuration"
})
@Generated("jsonschema2pojo")
public class DstInterval {

  @JsonProperty("dstName")
  private String dstName;

  @JsonProperty("dstOffsetToUtc")
  private DstOffsetToUtc dstOffsetToUtc;

  @JsonProperty("dstOffsetToStandardTime")
  private DstOffsetToStandardTime dstOffsetToStandardTime;

  @JsonProperty("dstStart")
  private String dstStart;

  @JsonProperty("dstEnd")
  private String dstEnd;

  @JsonProperty("dstDuration")
  private DstDuration dstDuration;

  @JsonProperty("dstName")
  public String getDstName() {
    return dstName;
  }

  @JsonProperty("dstName")
  public void setDstName(String dstName) {
    this.dstName = dstName;
  }

  @JsonProperty("dstOffsetToUtc")
  public DstOffsetToUtc getDstOffsetToUtc() {
    return dstOffsetToUtc;
  }

  @JsonProperty("dstOffsetToUtc")
  public void setDstOffsetToUtc(DstOffsetToUtc dstOffsetToUtc) {
    this.dstOffsetToUtc = dstOffsetToUtc;
  }

  @JsonProperty("dstOffsetToStandardTime")
  public DstOffsetToStandardTime getDstOffsetToStandardTime() {
    return dstOffsetToStandardTime;
  }

  @JsonProperty("dstOffsetToStandardTime")
  public void setDstOffsetToStandardTime(DstOffsetToStandardTime dstOffsetToStandardTime) {
    this.dstOffsetToStandardTime = dstOffsetToStandardTime;
  }

  @JsonProperty("dstStart")
  public String getDstStart() {
    return dstStart;
  }

  @JsonProperty("dstStart")
  public void setDstStart(String dstStart) {
    this.dstStart = dstStart;
  }

  @JsonProperty("dstEnd")
  public String getDstEnd() {
    return dstEnd;
  }

  @JsonProperty("dstEnd")
  public void setDstEnd(String dstEnd) {
    this.dstEnd = dstEnd;
  }

  @JsonProperty("dstDuration")
  public DstDuration getDstDuration() {
    return dstDuration;
  }

  @JsonProperty("dstDuration")
  public void setDstDuration(DstDuration dstDuration) {
    this.dstDuration = dstDuration;
  }
}
