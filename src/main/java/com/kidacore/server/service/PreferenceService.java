package com.kidacore.server.service;


import com.kidacore.server.config.DataSource;
import com.kidacore.server.repository.PreferenceRepository;
import com.kidacore.server.repository.projections.PreferencePair;
import lombok.RequiredArgsConstructor;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class PreferenceService {
    private Jdbi jdbi;

    public PreferenceService () {
        jdbi = DataSource.getJdbi();
    }

    public List<PreferencePair> getPreferenceLstByName (List<String> names) {
        PreferenceRepository dao = DataSource.getJdbi().onDemand(PreferenceRepository.class);
        return dao.getPreferencePairByName(names);
    }
}