
package net.gwizlabs.airlinkinfo;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class LocationDTO {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.latitude)^(Double.doubleToLongBits(this.latitude)>>> 32))));
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.longitude)^(Double.doubleToLongBits(this.longitude)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationDTO) == false) {
            return false;
        }
        LocationDTO rhs = ((LocationDTO) other);
        return ((Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(rhs.latitude))&&(Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(rhs.longitude)));
    }

}
