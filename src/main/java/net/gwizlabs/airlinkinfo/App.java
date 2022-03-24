package net.gwizlabs.airlinkinfo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** JavaFX App */
public class App extends Application {

  private static Scene scene;

  private static PrimaryController primaryController;
  private static UdpServer server;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"), 800, 800);
    stage.setScene(scene);
    stage.show();
  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    Parent gui = fxmlLoader.load();

    // get the controller that goes with this form so we can send JSON to display
    // and register it with server
    primaryController = fxmlLoader.getController();
    server.registerGui(primaryController);

    return gui;
  }

  public static void main(String[] args) {
    server = new UdpServer(21010);
    server.start(); // runs in its own thread
    launch();
    System.exit(0); //
  }
}