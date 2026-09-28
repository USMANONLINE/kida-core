package com.kidacore.server.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PreferenceEnum {
    SERVER_PORT("SERVER-PORT", "8080", "Application server port"),
    DATABASE_NAME("DATABASE-NAME", "kida-datasource", "Database name of the application"),
    DATABASE_DIR_NAME("DATABASE-DIR-NAME", "kida", "Database Directory name")
    ;

    private final String name;
    private final String value;
    private final String description;
}