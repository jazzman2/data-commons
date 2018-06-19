package sk.jazzman.data.domain;

import java.sql.SQLType;

public class DefaultParameter<VALUE> implements Parameter<VALUE> {
    private final String name;
    private final VALUE value;
    private final SQLType sqlType;

    public DefaultParameter(String name, VALUE value, SQLType sqlType) {
        this.name = name;
        this.value = value;
        this.sqlType = sqlType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public VALUE getValue() {
        return value;
    }

    @Override
    public SQLType getSQLType() {
        return null;
    }
}
