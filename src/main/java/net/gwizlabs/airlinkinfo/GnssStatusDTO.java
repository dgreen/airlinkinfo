
package net.gwizlabs.airlinkinfo;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class GnssStatusDTO {

    private boolean fix;
    private int numberSatellites;

    public boolean isFix() {
        return fix;
    }

    public void setFix(boolean fix) {
        this.fix = fix;
    }

    public int getNumberSatellites() {
        return numberSatellites;
    }

    public void setNumberSatellites(int numberSatellites) {
        this.numberSatellites = numberSatellites;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+(this.fix? 1 : 0));
        result = ((result* 31)+ this.numberSatellites);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GnssStatusDTO) == false) {
            return false;
        }
        GnssStatusDTO rhs = ((GnssStatusDTO) other);
        return ((this.fix == rhs.fix)&&(this.numberSatellites == rhs.numberSatellites));
    }

}
