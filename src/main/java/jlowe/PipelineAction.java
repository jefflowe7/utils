package jlowe;


public interface PipelineAction<T> {

    void execute(T message);
    default void evalPreconditions(T message){}
    default void evalPostconditions(T message){}
    default boolean cancel(T message) {return false;}

}
