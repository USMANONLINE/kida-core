package com.kidacore.deskstop.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.kidacore.server.config.Default.APP_NAME;

public class SysProp {

    public static Path getAppDataDir () {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return Paths.get(System.getenv("LOCALAPPDATA"), APP_NAME);
        }

        if (os.contains("mac")) {
            return Paths.get(System.getProperty("user.home"),
                "Library",
                "Application Support",
                APP_NAME
            );
        }

        return Paths.get(
            System.getProperty("user.home"),
            ".local",
            "share",
            APP_NAME
        );
    }
}