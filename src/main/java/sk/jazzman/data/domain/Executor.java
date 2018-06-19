package sk.jazzman.data.domain;

import javax.sql.DataSource;
import java.util.List;

public interface Executor {
    <D> Result<D> execute(Procedure procedure, List<Parameter<?>> parameterList, DataSource dataSource);
}
