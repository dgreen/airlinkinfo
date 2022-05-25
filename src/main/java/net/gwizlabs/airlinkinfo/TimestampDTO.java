package net.gwizlabs.airlinkinfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  /**
   * Get a Date object
   *
   * @return date object
   */
  public Date getDAO() {
    Date dt;

    DateFormat df = new SimpleDateFormat("MMddyyyy HHmm z");
    try {
      dt = df.parse(getDate() + " " + getTime() + " UTC");
    } catch (ParseException e) {
      System.out.println(e);
      dt = new Date();
    }
    return dt;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.date == null) ? 0 : this.date.hashCode()));
    result = ((result * 31) + ((this.time == null) ? 0 : this.time.hashCode()));
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
    return (((this.date == rhs.date) || ((this.date != null) && this.date.equals(rhs.date)))
        && ((this.time == rhs.time) || ((this.time != null) && this.time.equals(rhs.time))));
  }
}
