package sk.jazzman.data.domain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class DSL {

//    public static <T> Parameter<T> of(String parameterName, T parameterValue) {
//        return new DefaultParameter<>(parameterName, parameterValue);
//    }
//
//    public static Procedure of(String procedureName) {
//        return null;
//    }
//
//    public static WithProcedure withProcedure(String procedureName) {
////        return new of(procedureName);
//    }
//
//    public static <VALUE> ParameterChain withParameter(String parameterName, VALUE parameterValue) {
//        return withParameter(of(parameterName, parameterValue));
//    }
//
//    public static <VALUE> ParameterChain withParameter(Parameter<?> parameter) {
//        return new ParameterChainImpl(null, parameter);
//    }
//
//
//    public static <D> Result<D> execute(Procedure procedure, List<Parameter> parameters,) {
//        Connection c;
//        CallableStatement cs = c.prepareCall("");
//        Result<D> result;
//        long tStart = System.currentTimeMillis();
//        try {
//            parameters //
//                    .stream()//
//                    .map(parameter -> setObjectToStatement(() -> cs, () -> parameter));
//
//            cs.execute();
//            cs.
//        } catch (Exception ex) {
//            result = Result.failed(ex, System.currentTimeMillis() - tStart);
//        }
//        return null;
//    }
//
//    public static Try<?> setObjectToStatement(Supplier<CallableStatement> statementSupplier, Supplier<Parameter<?>> parameterSupplier) {
//        Try<?> retVal;
//        try {
//            Parameter<?> parameter = parameterSupplier.get();
//            statementSupplier.get().setObject(parameter.getName(), parameter.getValue(), parameter.getSQLType());
//            retVal = Try.success(parameter);
//        } catch (SQLException ex) {
//            retVal = Try.failed(ex);
//        }
//
//        return retVal;
//    }
//
//
//    private void test() {
//        withProcedure("test_procedure") //
//                .parameter(of("parameter1", "Value1"))//
//                .parameter(of("parameter2", Long.valueOf(100l))) //
//                .execute() //
//                .onError(throwable -> System.err.println("ERROR Log" + throwable.getMessage()))  //
//                .onSuccess(data -> System.out.println("SUCESS :)")) //
//                .get();
//
//    }

}
