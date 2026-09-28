package com.kidacore.deskstop;

import com.kidacore.deskstop.component.Tray;
import com.kidacore.server.ApplicationServer;
import com.kidacore.server.config.DataSource;
import io.javalin.Javalin;
import javafx.application.Application;

import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DesktopApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        boolean initializeDatabase = DataSource.initialize();
        if (!initializeDatabase) {
            log.error("Unable to initialize database.");
            return;
        }

        Javalin server = ApplicationServer.init();
        server.start();
        new Tray().initialize(server, primaryStage);
    }
}