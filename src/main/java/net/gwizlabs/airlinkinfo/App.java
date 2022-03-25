/*
 * Author: David G. Green <d.green@ieee.org>
 * System:  airlinkInfo
 */
package net.gwizlabs.airlinkinfo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** An Airlink Cellular Status Display JavaFX App */
public class App extends Application {

  private static Scene scene;

  private static PrimaryController primaryController;
  private static UdpServer server;

  /**
   * Start a JavaFX application
   *
   * @param stage the stage representing the display
   * @throws IOException
   */
  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"), 800, 800);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Set the root of the scene's display nodes
   *
   * @param fxml
   * @throws IOException
   */
  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  /**
   * Load the fxml file to define the screen display and the linkage to the controller
   *
   * <p>We are storing a reference to the controller so that we can give it to the UDP server
   *
   * @param fxml - the file name (without extension)
   * @return root of the display description
   * @throws IOException
   */
  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    Parent gui = fxmlLoader.load();

    // get the controller that goes with this form so we can send JSON to display
    // and register it with server
    primaryController = fxmlLoader.getController();
    server.registerGui(primaryController);

    return gui;
  }

  /**
   * Program starts here, builds UdpServer and then launches the GUI
   *
   * <p>There is an exit(0) at the end of this method so when the GUI ends, the program will end
   * (also stopping the UDP server).
   *
   * @param args
   */
  public static void main(String[] args) {
    server = new UdpServer(21010);
    server.start(); // runs in its own thread
    launch();
    System.exit(0); // exit (also stops the UDP server which is running in its own thread.
  }
}