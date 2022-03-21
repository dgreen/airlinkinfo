
package net.gwizlabs.airlinkinfo;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class GeneralInformationDTO {

    private double internalTemperature;

    public double getInternalTemperature() {
        return internalTemperature;
    }

    public void setInternalTemperature(double internalTemperature) {
        this.internalTemperature = internalTemperature;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.internalTemperature)^(Double.doubleToLongBits(this.internalTemperature)>>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeneralInformationDTO) == false) {
            return false;
        }
        GeneralInformationDTO rhs = ((GeneralInformationDTO) other);
        return (Double.doubleToLongBits(this.internalTemperature) == Double.doubleToLongBits(rhs.internalTemperature));
    }

}
