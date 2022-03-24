/*
 * Author: David G. Green <DGreen@uab.edu>
 * Assignment:  airlinkInfo - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/** UDP Server which invokes a display update */
public class UdpServer extends Thread {

  private final int port;
  private PrimaryController gui;

  public UdpServer(int port) {
    this.port = port;
  }

  public void registerGui(PrimaryController p) {
    gui = p;
  }

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
  /**
   * Server for broadcast UDPs to collect json payload and send to gui controller to unpack and
   * display
   *
   * <p>Assumes entire update in one UDP pack of 2048 chars or less (Example was 1189)
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
        gui.updateDisplay(info);
      } catch (JsonProcessingException e) {
        System.out.println("Error in Json Processin: " + e);
      }
    }
  }
}
