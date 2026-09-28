package com.kidacore.server.config;

import com.kidacore.deskstop.config.SysProp;
import com.kidacore.server.enums.PreferenceEnum;
import com.kidacore.server.repository.PreferenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlite3.SQLitePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public final class DataSource {
    private static Jdbi jdbi;

    public static boolean initialize () {
        Path dataSourcePath = SysProp.getAppDataDir().resolve(PreferenceEnum.DATABASE_NAME.getValue());
        try {
            Files.createDirectories(dataSourcePath.getParent());
        } catch (IOException e) {
            log.error("Unable to create database directory");
            return false;
        }

        jdbi = Jdbi.create("jdbc:sqlite:" +dataSourcePath)
            .installPlugin(new SQLitePlugin())
            .installPlugin(new SqlObjectPlugin());

        initSysSchema();
        return true;
    }

    public static Jdbi getJdbi () {
        if (jdbi == null) {
            log.error("Database has not been initialized yet");
        }
        return jdbi;
    }

    public static void initSysSchema () {
        PreferenceRepository dao = DataSource.getJdbi().onDemand(PreferenceRepository.class);
        dao.createTable();
    }
}