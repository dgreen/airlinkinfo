/*
 * Author: David G. Green <DGreen@uab.edu>
 * Assignment:  airlinkInfo - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package net.gwizlabs.airlinkinfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** */
public class TestDate {

  /** @param args the command line arguments */
  public static void main(String[] args) throws ParseException {

    DateFormat df = new SimpleDateFormat("MMddyyyy HHmm z");
    Date date = df.parse("03172022 1422 UTC");
    System.out.println(date);
  }
}
