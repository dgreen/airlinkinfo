
package net.gwizlabs.airlinkinfo;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class TimestampDTO {

    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimestampDTO) == false) {
            return false;
        }
        TimestampDTO rhs = ((TimestampDTO) other);
        return (((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))));
    }

}
