package net.gwizlabs.airlinkinfo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

  // map to GUI controls in fxml file
  @FXML private TextField locationTB;
  @FXML private TextField dateTB;
  @FXML private TextField timeTB;

  // Left Panel
  @FXML private TextField typeTB0;
  @FXML private TextField availableTB0;
  @FXML private TextField satellitesTB0;
  @FXML private TextField bandTB0;
  @FXML private TextField bandwidthTB0;
  @FXML private TextField signalStrengthTB0;
  @FXML private TextField rssiTB0;
  @FXML private TextField rsrpTB0;
  @FXML private TextField rsrqTB0;
  @FXML private TextField sinrTB0;

  // Right Panel
  @FXML private TextField typeTB1;
  @FXML private TextField availableTB1;
  @FXML private TextField satellitesTB1;
  @FXML private TextField bandTB1;
  @FXML private TextField bandwidthTB1;
  @FXML private TextField signalStrengthTB1;
  @FXML private TextField rssiTB1;
  @FXML private TextField rsrpTB1;
  @FXML private TextField rsrqTB1;
  @FXML private TextField sinrTB1;

  // speed test
  @FXML private Button testTB;
  @FXML private TextField downTB;
  @FXML private TextField upTB;

  @FXML
  private void runTest() {
    //
  }

  public void updateDisplay(AirLinkDTO info) {}
}
