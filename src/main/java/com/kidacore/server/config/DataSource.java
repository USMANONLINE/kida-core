package com.kidacore.server.config;

import com.kidacore.deskstop.config.SysProp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    public static Connection getDataSourceCon () throws IOException, SQLException {
        Path dataSourcePath = SysProp.getAppDataDir().resolve(Default.DATABASE_NAME);
        Files.createDirectories(dataSourcePath.getParent());
        return DriverManager.getConnection("jdbc:sqlite:" +dataSourcePath);
    }
}