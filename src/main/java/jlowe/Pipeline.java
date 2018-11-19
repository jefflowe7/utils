package jlowe;

import java.util.ArrayList;

public class Pipeline<T> extends ArrayList<PipelineAction<T>> implements PipelineAction<T> {

    @Override
    public void execute(T message) {



        for( PipelineAction<T> action  : this) {


            action.evalPreconditions(message);
            action.execute(message);
            action.evalPostconditions(message);
            if(action.cancel(message)) {
                break;
            }
        }



    }
}
