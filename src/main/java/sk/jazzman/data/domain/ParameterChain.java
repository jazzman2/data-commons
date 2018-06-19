package sk.jazzman.data.domain;

import java.util.List;

public interface ParameterChain {
    ParameterChain add(Parameter<?> parameter);



    List<Parameter<?>> collect();

}
