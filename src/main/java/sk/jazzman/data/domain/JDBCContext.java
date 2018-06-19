package sk.jazzman.data.domain;

import javax.sql.DataSource;

public class JDBCContext {
    private ParameterChain parameterChain;
    private final Procedure procedure;
    private DataSource dataSource;
    private Executor executor;

    private JDBCContext(Procedure procedure) {
        this.procedure = procedure;
    }

    public static JDBCContext create(Procedure procedure) {
        return new JDBCContext(procedure);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(Parameter parameter) {
        this.parameterChain = parameterChain == null ? ParameterChainImpl.create(parameter) : parameterChain.add(parameter);
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public <D> Result<D> execute(){
        return executor.execute(procedure,parameterChain.collect(),dataSource);
    }
}
