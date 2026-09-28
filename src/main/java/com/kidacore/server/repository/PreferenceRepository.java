package com.kidacore.server.repository;

import com.kidacore.server.repository.projections.PreferencePair;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterConstructorMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface PreferenceRepository {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS `Preferences` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` VARCHAR(255) NOT NULL UNIQUE, `value` TEXT NOT NULL, `description` TEXT, `createdAt` DATETIME NOT NULL, `updatedAt` DATETIME NOT NULL)")
    void createTable();

    @SqlQuery("select name, value from Preferences p where p.name in (<names>)")
    @RegisterConstructorMapper(PreferencePair.class)
    List<PreferencePair> getPreferencePairByName (@BindList("names") List<String> names);
}