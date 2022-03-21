package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class WanStateDTO {

  private String friendlyName;
  private int status;
  private boolean active;
  private String networkType;
  private double signalStrength;
  private String bandNo;
  private int bandwidth;
  private double rssi;
  private double rsrp;
  private double rsrq;
  private double sinr;

  public String getFriendlyName() {
    return friendlyName;
  }

  public void setFriendlyName(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getNetworkType() {
    return networkType;
  }

  public void setNetworkType(String networkType) {
    this.networkType = networkType;
  }

  public double getSignalStrength() {
    return signalStrength;
  }

  public void setSignalStrength(double signalStrength) {
    this.signalStrength = signalStrength;
  }

  public String getBandNo() {
    return bandNo;
  }

  public void setBandNo(String bandNo) {
    this.bandNo = bandNo;
  }

  public int getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(int bandwidth) {
    this.bandwidth = bandwidth;
  }

  @JsonProperty("RSSI")
  public double getRssi() {
    return rssi;
  }

  @JsonProperty("RSSI")
  public void setRssi(double rssi) {
    this.rssi = rssi;
  }

  @JsonProperty("RSRP")
  public double getRsrp() {
    return rsrp;
  }

  @JsonProperty("RSRP")
  public void setRsrp(double rsrp) {
    this.rsrp = rsrp;
  }

  @JsonProperty("RSRQ")
  public double getRsrq() {
    return rsrq;
  }

  @JsonProperty("RSRQ")
  public void setRsrq(double rsrq) {
    this.rsrq = rsrq;
  }

  @JsonProperty("SINR")
  public double getSinr() {
    return sinr;
  }

  @JsonProperty("SINR")
  public void setSinr(double sinr) {
    this.sinr = sinr;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result =
        ((result * 31)
            + ((int)
                (Double.doubleToLongBits(this.rssi)
                    ^ (Double.doubleToLongBits(this.rssi) >>> 32))));
    result = ((result * 31) + ((this.bandNo == null) ? 0 : this.bandNo.hashCode()));
    result = ((result * 31) + this.bandwidth);
    result =
        ((result * 31)
            + ((int)
                (Double.doubleToLongBits(this.rsrq)
                    ^ (Double.doubleToLongBits(this.rsrq) >>> 32))));
    result =
        ((result * 31)
            + ((int)
                (Double.doubleToLongBits(this.signalStrength)
                    ^ (Double.doubleToLongBits(this.signalStrength) >>> 32))));
    result = ((result * 31) + (this.active ? 1 : 0));
    result =
        ((result * 31)
            + ((int)
                (Double.doubleToLongBits(this.rsrp)
                    ^ (Double.doubleToLongBits(this.rsrp) >>> 32))));
    result = ((result * 31) + ((this.networkType == null) ? 0 : this.networkType.hashCode()));
    result = ((result * 31) + ((this.friendlyName == null) ? 0 : this.friendlyName.hashCode()));
    result = ((result * 31) + this.status);
    result =
        ((result * 31)
            + ((int)
                (Double.doubleToLongBits(this.sinr)
                    ^ (Double.doubleToLongBits(this.sinr) >>> 32))));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof WanStateDTO) == false) {
      return false;
    }
    WanStateDTO rhs = ((WanStateDTO) other);
    return (((((((((((Double.doubleToLongBits(this.rssi) == Double.doubleToLongBits(rhs.rssi))
                                            && ((this.bandNo == rhs.bandNo)
                                                || ((this.bandNo != null)
                                                    && this.bandNo.equals(rhs.bandNo))))
                                        && (this.bandwidth == rhs.bandwidth))
                                    && (Double.doubleToLongBits(this.rsrq)
                                        == Double.doubleToLongBits(rhs.rsrq)))
                                && (Double.doubleToLongBits(this.signalStrength)
                                    == Double.doubleToLongBits(rhs.signalStrength)))
                            && (this.active == rhs.active))
                        && (Double.doubleToLongBits(this.rsrp)
                            == Double.doubleToLongBits(rhs.rsrp)))
                    && ((this.networkType == rhs.networkType)
                        || ((this.networkType != null)
                            && this.networkType.equals(rhs.networkType))))
                && ((this.friendlyName == rhs.friendlyName)
                    || ((this.friendlyName != null) && this.friendlyName.equals(rhs.friendlyName))))
            && (this.status == rhs.status))
        && (Double.doubleToLongBits(this.sinr) == Double.doubleToLongBits(rhs.sinr)));
  }
}
