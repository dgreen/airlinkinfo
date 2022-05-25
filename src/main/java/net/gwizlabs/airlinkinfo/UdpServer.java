/*
 * Author: David G. Green <d.green@ieee.org>
 * System:  airlinkInfo
 */

package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;

/** UDP Server which invokes a display update */
public class UdpServer extends Thread {

  private final int port;
  private PrimaryController gui;

  public UdpServer(int port) {
    this.port = port;
  }

  /**
   * Allow external object to register the PrimaryController which has a updateDisplay(info, tzText)
   *
   * @param p primaryController object
   */
  public void registerGui(PrimaryController p) {
    gui = p;
  }

  /** Run the thread */
  @Override
  public void run() {
    DatagramSocket socket;

    try {
      socket = new DatagramSocket(port); // parameter?
      service(socket);
    } catch (SocketException ex) {
      System.out.println("Socket error: " + ex.getMessage());
    } catch (IOException ex) {
      System.out.println("I/O error: " + ex.getMessage());
    }
  }

  // Default to Central
  String timeZoneText = "America/Chicago";
  Instant lastSuccessTzRequest = Instant.EPOCH;

  /**
   * Server for broadcast UDPs to collect json payload and send to gui controller to unpack and
   * display. Using the available timeZoneText (updated by calling acquireTimeZoneText() below.
   *
   * <p>Assumes entire update in one UDP pack of 2048 chars or less (Example was 1189)]]
   *
   * @param socket DatagramSocket listening on the port that Airlink is broadcasting to
   * @throws IOException
   */
  public void service(DatagramSocket socket) throws IOException {

    String jsonPayload;

    while (true) {
      DatagramPacket report = new DatagramPacket(new byte[2048], 2048);
      socket.receive(report);
      if (gui == null) { // don't process till GUI established
        continue;
      }
      jsonPayload = new String(report.getData(), 0, report.getLength());
      ObjectMapper objectMapper = new ObjectMapper();

      try {
        AirLinkDTO info = objectMapper.readValue(jsonPayload, AirLinkDTO.class);

        acquireTimeZoneText(info.getLocation(), objectMapper);

        gui.updateDisplay(info, timeZoneText);
      } catch (JsonProcessingException e) {
        System.out.println("Error in Json Processing: " + e);
      } catch (Exception e) {
        System.out.println("Another execption: " + e);
      }
    }
  }

  /**
   * Every 300 seconds obtain (if possible) a timezone information based on truck position using a
   * web request like
   * https://www.timeapi.io/api/TimeZone/coordinate?latitude=35.9524&longitude=-78.9642 as discussed
   * in https://www.timeapi.io/swagger/index.html.
   *
   * @param locInfo object containing Airlink data
   * @param objectMapper an object mapper
   * @throws IOException
   * @throws InterruptedException
   */
  public void acquireTimeZoneText(LocationDTO locInfo, ObjectMapper objectMapper)
      throws IOException, InterruptedException {

    // only call service every 5 mins for timezone
    if (Instant.now().isAfter(lastSuccessTzRequest.plusSeconds(300))) {

      // acquire TimeZone Information
      // https://www.timeapi.io/api/TimeZone/coordinate?latitude=35.9524&longitude=-78.9642

      String endPoint =
          "https://www.timeapi.io/api/TimeZone/coordinate?latitude="
              + locInfo.getLatitude()
              + "&longitude="
              + locInfo.getLongitude();

      var request = HttpRequest.newBuilder().uri(URI.create(endPoint)).build();
      var client = HttpClient.newHttpClient();
      var response = client.send(request, HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        TimeZoneInfo timeZoneInfo = objectMapper.readValue(response.body(), TimeZoneInfo.class);
        String tz = timeZoneInfo.getTimeZone();
        if (tz != null && !tz.equals("")) {
          timeZoneText = tz;
          lastSuccessTzRequest = Instant.now();
        }
      }
    }
  }
}
