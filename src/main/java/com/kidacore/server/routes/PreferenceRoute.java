package com.kidacore.server.routes;

import com.kidacore.server.dtos.request.PreferenceLst;
import com.kidacore.server.repository.projections.PreferencePair;
import com.kidacore.server.service.PreferenceService;
import io.javalin.config.JavalinConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class PreferenceRoute {
    public JavalinConfig config;
    public PreferenceService preferenceService;

    public PreferenceRoute(JavalinConfig config) {
        this.config = config;
        this.preferenceService = new PreferenceService();
        getPreferenceLstByName();
    }

    public void getPreferenceLstByName () {
        config.routes.post("/api/preference", ctx -> {
            PreferenceLst reqBody = ctx.bodyAsClass(PreferenceLst.class);
            List<PreferencePair> preferencePairList = this.preferenceService
                .getPreferenceLstByName(reqBody.getPreferenceLst());
            ctx.json(preferencePairList);
        });
    }
}