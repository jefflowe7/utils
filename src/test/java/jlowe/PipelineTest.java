package jlowe;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PipelineTest {

    @Test
    public void testExecute() {

        List<String> breadcrumbs = new ArrayList<String>();


        Pipeline<List<String>> outer = new Pipeline<List<String>>();

        Pipeline<List<String>> nested = new Pipeline<List<String>>();


        nested.add(new NamedAction("nested.0"));
        nested.add(new NamedAction("nested.1"));
        nested.add(new NamedAction("nested.2"));
        nested.add(new NamedAction("nested.3"));
        nested.add(new NamedAction("nested.4"));


        outer.add(new NamedAction("outer.0"));
        outer.add(nested);
        outer.add(new NamedAction("outer.1"));
        outer.add(new NamedAction("outer.2"));
        outer.add(new NamedAction("outer.3"));



        outer.execute(breadcrumbs);


        Assert.assertEquals("outer.0",  breadcrumbs.get(0));
        Assert.assertEquals("nested.0",  breadcrumbs.get(1));
        Assert.assertEquals("nested.1",  breadcrumbs.get(2));
        Assert.assertEquals("nested.2",  breadcrumbs.get(3));
        Assert.assertEquals("nested.3",  breadcrumbs.get(4));
        Assert.assertEquals("nested.4",  breadcrumbs.get(5));
        Assert.assertEquals("outer.1",  breadcrumbs.get(6));
        Assert.assertEquals("outer.2",  breadcrumbs.get(7));
        Assert.assertEquals("outer.3",  breadcrumbs.get(8));







    }

}