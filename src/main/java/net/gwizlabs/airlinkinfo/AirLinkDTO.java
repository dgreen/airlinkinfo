package net.gwizlabs.airlinkinfo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class AirLinkDTO {

  private TimestampDTO timestamp;
  private String version;
  private String vehicleID;
  private LocationDTO location;
  private List<WanStateDTO> wanState = new ArrayList<>();
  private GnssStatusDTO gnssStatus;
  private GeneralInformationDTO generalInformation;

  public TimestampDTO getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(TimestampDTO timestamp) {
    this.timestamp = timestamp;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getVehicleID() {
    return vehicleID;
  }

  public void setVehicleID(String vehicleID) {
    this.vehicleID = vehicleID;
  }

  public LocationDTO getLocation() {
    return location;
  }

  public void setLocation(LocationDTO location) {
    this.location = location;
  }

  public List<WanStateDTO> getWanState() {
    return wanState;
  }

  public void setWanState(List<WanStateDTO> wanState) {
    this.wanState = wanState;
  }

  public GnssStatusDTO getGnssStatus() {
    return gnssStatus;
  }

  public void setGnssStatus(GnssStatusDTO gnssStatus) {
    this.gnssStatus = gnssStatus;
  }

  public GeneralInformationDTO getGeneralInformation() {
    return generalInformation;
  }

  public void setGeneralInformation(GeneralInformationDTO generalInformation) {
    this.generalInformation = generalInformation;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.gnssStatus == null) ? 0 : this.gnssStatus.hashCode()));
    result = ((result * 31) + ((this.wanState == null) ? 0 : this.wanState.hashCode()));
    result = ((result * 31) + ((this.location == null) ? 0 : this.location.hashCode()));
    result = ((result * 31) + ((this.vehicleID == null) ? 0 : this.vehicleID.hashCode()));
    result =
        ((result * 31)
            + ((this.generalInformation == null) ? 0 : this.generalInformation.hashCode()));
    result = ((result * 31) + ((this.version == null) ? 0 : this.version.hashCode()));
    result = ((result * 31) + ((this.timestamp == null) ? 0 : this.timestamp.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof AirLinkDTO) == false) {
      return false;
    }
    AirLinkDTO rhs = ((AirLinkDTO) other);
    return ((((((((this.gnssStatus == rhs.gnssStatus)
                                || ((this.gnssStatus != null)
                                    && this.gnssStatus.equals(rhs.gnssStatus)))
                            && ((this.wanState == rhs.wanState)
                                || ((this.wanState != null) && this.wanState.equals(rhs.wanState))))
                        && ((this.location == rhs.location)
                            || ((this.location != null) && this.location.equals(rhs.location))))
                    && ((this.vehicleID == rhs.vehicleID)
                        || ((this.vehicleID != null) && this.vehicleID.equals(rhs.vehicleID))))
                && ((this.generalInformation == rhs.generalInformation)
                    || ((this.generalInformation != null)
                        && this.generalInformation.equals(rhs.generalInformation))))
            && ((this.version == rhs.version)
                || ((this.version != null) && this.version.equals(rhs.version))))
        && ((this.timestamp == rhs.timestamp)
            || ((this.timestamp != null) && this.timestamp.equals(rhs.timestamp))));
  }
}
