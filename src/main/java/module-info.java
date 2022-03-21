module net.gwizlabs.airlinkinfo {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.compiler;
  requires com.fasterxml.jackson.databind;

  opens net.gwizlabs.airlinkinfo to
      javafx.fxml;

  exports net.gwizlabs.airlinkinfo;
}
