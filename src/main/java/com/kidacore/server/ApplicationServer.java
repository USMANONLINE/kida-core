package com.kidacore.server;

import com.kidacore.server.config.Default;
import com.kidacore.server.routes.PreferenceRoute;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationServer {

    public static Javalin init () {
        return Javalin.create(config -> {
            config.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/spa";
                staticFileConfig.location = Location.CLASSPATH;
            });
            new PreferenceRoute(config);
        });
    }
}