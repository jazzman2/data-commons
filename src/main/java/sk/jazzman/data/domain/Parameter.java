package sk.jazzman.data.domain;

import java.sql.SQLType;

public interface Parameter<T> {

    String getName();

    T getValue();

    SQLType getSQLType();
}
