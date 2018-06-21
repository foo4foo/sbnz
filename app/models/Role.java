package models;

import io.ebean.annotation.DbEnumType;
import io.ebean.annotation.DbEnumValue;


public enum Role {
    Doctor("1"),
    Administrator("2");

    String value;

    Role(String value) {
        this.value = value;
    }

    // map to DB INTEGER
    @DbEnumValue(storage = DbEnumType.INTEGER)
    public String getValue() {
        return value;
    }
}