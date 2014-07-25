package core;

//
// An object that is usable
//
// TODO: Figure out if this class is needed...
//
public class Item extends WObject {

    public Item() {
       super("obj");
    }

    public Item(String name) {
        super(name);
    }

    public Item(String name, String description) {
        super(name);
        this.setDescription(description);
    }

}