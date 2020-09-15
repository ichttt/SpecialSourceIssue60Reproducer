package specialsourcetest.orig;

public class BaseClass extends SuperClass {

    @Override
    protected void init() {
        this.addThingy(new ThingyHolder(holder -> {
            System.out.println("Some stuff happens here in base");
            System.out.println("Got " + holder + " in base");
            holder.someMethod("testing");
        }));

        this.addThingy(new ThingyHolder(holder -> {
            System.out.println("Some stuff happens here in base (foo2)");
        }));
    }
}
