package sk.jazzman.data.domain;

import java.util.*;

public class ParameterChainImpl implements ParameterChain {
    private final Parameter<?> parameter;
    private final ParameterChainImpl parent;

    private ParameterChainImpl(ParameterChainImpl parent, Parameter<?> parameter) {
        Objects.requireNonNull(parameter,"Parameter must not by null!");
        this.parent = parent;
        this.parameter = parameter;
    }

    public static ParameterChainImpl create(Parameter<?> parameter){
        return new ParameterChainImpl(null,parameter);
    }

    protected Optional<ParameterChainImpl> getParent(){
        return Optional.ofNullable(parent);
    }

    public Parameter<?> getParameter() {
        return parameter;
    }

    public ParameterChain add(Parameter<?> parameter){
        return new ParameterChainImpl(this,parameter);
    }

    @Override
    public List<Parameter<?>> collect() {
        return Collections.unmodifiableList(collect(this,new ArrayList<>()));
    }

    private List<Parameter<?>> collect(ParameterChainImpl node, List<Parameter<?>> list){
        List<Parameter<?>> retVal = node.getParent().map(parent -> collect(parent,list)).get();
        retVal.add(node.getParameter());
        return retVal;
    }
}
