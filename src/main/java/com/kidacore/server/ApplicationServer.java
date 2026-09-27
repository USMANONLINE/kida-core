package com.kidacore.server;

import com.kidacore.server.config.Default;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationServer {

    public static void init () {
        var server = Javalin.create(config -> {
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/spa";
                staticFileConfig.location = Location.CLASSPATH;
            });
        }).start(Default.SERVER_PORT);
        log.info("Server is up and running ...");
    }
}