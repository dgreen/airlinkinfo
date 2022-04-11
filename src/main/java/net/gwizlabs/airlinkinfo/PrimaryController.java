package net.gwizlabs.airlinkinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.fxml.FXML;
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

  private TextField[][] wanStateTB;

  // speed test
  // @FXML private Button testTB;
  // @FXML private TextField downTB;
  // @FXML private TextField upTB;

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
    TextField[][] wanStateTBi = {
      {
        typeTB0,
        availableTB0,
        bandTB0,
        bandwidthTB0,
        signalStrengthTB0,
        rssiTB0,
        rsrpTB0,
        rsrqTB0,
        sinrTB0
      },
      {
        typeTB1,
        availableTB1,
        bandTB1,
        bandwidthTB1,
        signalStrengthTB1,
        rssiTB1,
        rsrpTB1,
        rsrqTB1,
        sinrTB1
      },
    };
    wanStateTB = wanStateTBi;
  }

  @FXML
  private void runTest() {
    //
  }

  public void makeTestObject() {
    String jsonInfo = "";
    /*        """
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
        """; */

    ObjectMapper objectMapper = new ObjectMapper();

    try {
      AirLinkDTO info = objectMapper.readValue(jsonInfo, AirLinkDTO.class);
      updateDisplay(info);
    } catch (JsonProcessingException e) {
      System.out.println("Error in Json Processing: " + e);
    }
  }

  /**
   * Update the display based on new info
   *
   * @param info object version of the original JSON from Airlink
   */
  public void updateDisplay(AirLinkDTO info) {
    Platform.runLater(
        () -> {
          locationTB.setText(
              "" + info.getLocation().getLatitude() + ", " + info.getLocation().getLongitude());

          satellitesTB.setText("" + info.getGnssStatus().getNumberSatellites());

          dateTB.setText("" + info.getTimestamp().getDate());
          timeTB.setText("" + info.getTimestamp().getTime());
        });

    var wanStates = info.getWanState();

    for (WanStateDTO wanState : wanStates) {
      if (wanState.getFriendlyName().contains("AT&T")) {
        // AT&T
        String colorInfo = colorPick(wanState);
        Platform.runLater(
            () -> {
              attGrid.setStyle(colorInfo);
            });
        setGrid(wanStateTB[0], wanState);
      } else if (wanState.getFriendlyName().contains("Verizon")) {
        // Verizon
        String colorInfo = colorPick(wanState);
        Platform.runLater(
            () -> {
              verizonGrid.setStyle(colorInfo);
            });
        setGrid(wanStateTB[1], wanState);
      }
    }
    System.gc();
  }

  private final double[] rsrpThresholds = new double[] {-80., -90., -100., -100000.};
  private final double[] rsrqThresholds = new double[] {-10., -15., -20., -100000.};
  private final double[] sinrThresholds = new double[] {20., 13., 0., -100000.};
  private final double[] rssiThresholds = new double[] {-65., -75., -85., -95., -100000.};

  // Changed to a constant strings to avoid making unnecessary objects on RPi

  private final String fourColors[] = {
    "-fx-background-color: #6ACE61",
    "-fx-background-color: #FBFB43",
    "-fx-background-color: #F7BA30",
    "-fx-background-color: #EC031D"
  };
  private final String fiveColors[] = {
    "-fx-background-color: #6ACE61",
    "-fx-background-color: #FBFB43",
    "-fx-background-color: #F7BA30",
    "-fx-background-color: #EC031D",
    "-fx-background-color: #AB0312"
  };
  private final String textColors[] = {
    "-fx-text-inner-color: #000000",
    "-fx-text-inner-color: #000000",
    "-fx-text-inner-color: #000000",
    "-fx-text-inner-color: #FFFFFF",
    "-fx-text-inner-color: #FFFFFF"
  };

  /**
   * Set grid elements using textFields array of elements using wanstate values. Colorize values
   * based on values
   *
   * <p>Ranges and colors are from 4G (LTE) colors in this article:
   * https://wiki.teltonika-networks.com/view/Mobile_Signal_Strength_Recommendations
   *
   * @param textFields references into a Grid
   * @param wanState values for one wan from AirLink
   */
  private void setGrid(TextField[] textFields, WanStateDTO wanState) {

    Platform.runLater(
        () -> {
          // type
          textFields[0].setText("" + wanState.getNetworkType());
          // available
          textFields[1].setText("" + (wanState.getStatus() == 1 ? "Yes" : "No"));
          textFields[1].setStyle(
              (wanState.getStatus() == 1
                  ? "-fx-background-color: LIGHTGREEN"
                  : "-fx-background-color: PINK"));
          // band
          textFields[2].setText("" + wanState.getBandNo());
          // bandwidth
          textFields[3].setText("" + wanState.getBandwidth());
          // signalStrength
          textFields[4].setText("" + wanState.getSignalStrength());
          // rssi
          setField(textFields[5], wanState.getRssi(), rssiThresholds, fiveColors);
          // rsrp
          setField(textFields[6], wanState.getRsrp(), rsrpThresholds, fourColors);
          // rsrq
          setField(textFields[7], wanState.getRsrq(), rsrqThresholds, fourColors);
          // sinr
          setField(textFields[8], wanState.getSinr(), sinrThresholds, fourColors);
        });
  }

  /**
   * Set the text field's text and color
   *
   * <p>If the value > threshold, use the corresponding color If on the last threshold, use the
   * corresponding color anyway
   *
   * @param tf textField to use
   * @param value actual value
   * @param threshold array of thresholds
   * @param colors array of color strings
   */
  private void setField(TextField tf, double value, double threshold[], String[] colors) {

    tf.setText("" + value);
    for (int i = 0; i < threshold.length; i++) {
      if (value > threshold[i] || (i == threshold.length - 1)) {
        String colorInfo = colors[i] + "; " + textColors[i];
        //        Platform.runLater(
        //            () -> {
        tf.setStyle(colorInfo);
        //            });
        break;
      }
    }
  }

  /**
   * Return a color based on LTE Active/Status
   *
   * <p>Changed to a constant string to avoid making unnecessary objects on RPi
   *
   * @param ws
   * @return "-fx-background-color: " + color
   */
  private String colorPick(WanStateDTO ws) {

    if (ws.isActive()) {
      return "-fx-background-color: LIGHTGREEN";
    }
    if (ws.getStatus() == 0) {
      return "-fx-background-color: PINK";
    }
    return "-fx-background-color: LIGHTGREY";
  }
}
