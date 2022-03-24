package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

public class PrimaryController {

  // map to GUI controls in fxml file
  @FXML private TextField locationTB;
  @FXML private TextField dateTB;
  @FXML private TextField timeTB;
  @FXML private TextField satellitesTB;

  // Left Panel
  @FXML private TitledPane attPane;
  @FXML private GridPane attGrid;
  @FXML private TextField typeTB0;
  @FXML private TextField availableTB0;
  @FXML private TextField bandTB0;
  @FXML private TextField bandwidthTB0;
  @FXML private TextField signalStrengthTB0;
  @FXML private TextField rssiTB0;
  @FXML private TextField rsrpTB0;
  @FXML private TextField rsrqTB0;
  @FXML private TextField sinrTB0;

  // Right Panel
  @FXML private TitledPane verizonPane;
  @FXML private GridPane verizonGrid;
  @FXML private TextField typeTB1;
  @FXML private TextField availableTB1;
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
  public void initialize() {
    //        enableReadyButtons();
    //        App.getStage().focusedProperty().addListener( (ObservableValue<? extends Boolean>
    // obj,Boolean oldVal,Boolean newVal) -> {
    //            // This listener reviews button status when
    //            // window gets input focus.
    //        if (newVal) { // The window has gained focus.
    //            enableReadyButtons();
    //        }
    //    });
    // makeTestObject();
  }

  @FXML
  private void runTest() {
    //
  }

  public void makeTestObject() {
    String jsonInfo =
        """
{
  "timestamp": {
    "date": "03182022",
    "time": "1453"
  },

  "version": "4.3.1.2",

  "vehicleID": "~",

  "location": {
    "latitude": 35.952372,
    "longitude": -78.964191
  },

  "wanState": [
    {
      "friendlyName": "Panel Ethernet 5",
      "status": 0,
      "active": false,
      "networkType": "Ethernet"
    },
    {
      "friendlyName": "Sierra Wireless EM75XX @ MiniCard USB3 CA (Cellular A) AT&T",
      "status": 1,
      "active": true,
      "networkType": "Cellular",
      "signalStrength": -65.000000,
      "bandNo": "14",
      "bandwidth": 10,
      "RSSI": -65.000000,
      "RSRP": -99.000000,
      "RSRQ": -15.600000,
      "SINR": 0.600000
    },
    {
      "friendlyName": "Sierra Wireless EM75XX @ MiniCard USB3 CB (Cellular B) Verizon",
      "status": 1,
      "active": false,
      "networkType": "Cellular",
      "signalStrength": -53.909092,
      "bandNo": "5",
      "bandwidth": 10,
      "RSSI": -50.000000,
      "RSRP": -75.000000,
      "RSRQ": -7.900000,
      "SINR": 20.600000
    }
  ],

  "gnssStatus": {
    "fix": true,
    "numberSatellites": 3
  },

  "generalInformation": {
    "internalTemperature": 26.666667
  }

}
    """;

    ObjectMapper objectMapper = new ObjectMapper();

    try {
      AirLinkDTO info = objectMapper.readValue(jsonInfo, AirLinkDTO.class);
      updateDisplay(info);
    } catch (JsonProcessingException e) {
      System.out.println("Error in Json Processing: " + e);
    }
  }

  public void updateDisplay(AirLinkDTO info) {
    locationTB.setText(
        "" + info.getLocation().getLatitude() + ", " + info.getLocation().getLongitude());

    satellitesTB.setText("" + info.getGnssStatus().getNumberSatellites());

    dateTB.setText("" + info.getTimestamp().getDate());
    timeTB.setText("" + info.getTimestamp().getTime());

    var wanStates = info.getWanState();

    for (WanStateDTO wanState : wanStates) {
      if (wanState.getFriendlyName().contains("AT&T")) {
        // AT&T
        attGrid.setStyle("-fx-background-color: " + colorPick(wanState));
        typeTB0.setText("" + wanState.getNetworkType());
        availableTB0.setText("" + (wanState.getStatus() == 1 ? "Yes" : "No"));
        bandTB0.setText("" + wanState.getBandNo());
        bandwidthTB0.setText("" + wanState.getBandwidth());
        signalStrengthTB0.setText("" + wanState.getSignalStrength());
        rssiTB0.setText("" + wanState.getRssi());
        rsrpTB0.setText("" + wanState.getRsrp());
        rsrqTB0.setText("" + wanState.getRsrq());
        sinrTB0.setText("" + wanState.getSinr());
      } else if (wanState.getFriendlyName().contains("Verizon")) {
        // Verizon
        verizonGrid.setStyle("-fx-background-color: " + colorPick(wanState));
        typeTB1.setText("" + wanState.getNetworkType());
        availableTB1.setText("" + (wanState.getStatus() == 1 ? "Yes" : "No"));
        bandTB1.setText("" + wanState.getBandNo());
        bandwidthTB1.setText("" + wanState.getBandwidth());
        signalStrengthTB1.setText("" + wanState.getSignalStrength());
        rssiTB1.setText("" + wanState.getRssi());
        rsrpTB1.setText("" + wanState.getRsrp());
        rsrqTB1.setText("" + wanState.getRsrq());
        sinrTB1.setText("" + wanState.getSinr());
      }
    }
  }

  private String colorPick(WanStateDTO ws) {

    if (ws.isActive()) {
      return "LIGHTGREEN";
    }
    if (ws.getStatus() == 0) {
      return "PINK";
    }
    return "LIGHTGREY";
  }
}
