module net.gwizlabs.airlinkinfo {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.compiler;
  requires com.fasterxml.jackson.databind;
  requires com.fasterxml.jackson.core;
  requires java.net.http;
  requires com.fasterxml.jackson.annotation; // requires jackson-annotations;

  opens net.gwizlabs.airlinkinfo to
      javafx.fxml;

  exports net.gwizlabs.airlinkinfo;
}
