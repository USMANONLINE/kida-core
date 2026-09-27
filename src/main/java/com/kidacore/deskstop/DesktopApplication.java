package com.kidacore.deskstop;

import com.kidacore.deskstop.component.Tray;
import com.kidacore.server.ApplicationServer;
import javafx.application.Application;

import javafx.stage.Stage;

public class DesktopApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        ApplicationServer.init();
        new Tray().initialize(primaryStage);
    }
}