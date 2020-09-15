package ichttt.testspecialsource;

import specialsourcetest.orig.BaseClass;
import specialsourcetest.orig.ThingyHolder;

public class TestClass extends BaseClass {

    @Override
    protected void init() {
        super.init();
        addThingy(new ThingyHolder(holder -> {
            System.out.println("Doing some stuff from test class");
            System.out.println("Stuff going on");
        }));
        addThingy(new ThingyHolder(holder -> {
            System.out.println("Doing some other stuff from test class");
            System.out.println("Other stuff going on");
        }));
    }
}
