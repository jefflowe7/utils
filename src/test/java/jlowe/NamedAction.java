package jlowe;

import java.util.List;

public class NamedAction implements PipelineAction<List<String>> {
    public String Name;


    public NamedAction(String name) {
        Name = name;
    }

    @Override
    public void execute(List<String> message) {
        message.add(this.Name);
    }
}
