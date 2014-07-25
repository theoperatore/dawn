package core;

//
// Basic Building Object
//
public class WObject {

    //both fields used to check for equality
    private String name;
    private String description;

    //constructors
    public WObject() {
        this.name = "obj";
        this.description = "";
    }

    public WObject(String name) {
        this.name = name;
        this.description = "";
    }

    //accessors
    public String getName()        { return this.name; }
    public String getDescription() { return this.description; }

    //mutators
    public void setName(String n)        { this.name = n; }
    public void setDescription(String d) { this.description = d; }

    //utilities
    @Override
    public String toString() {
        return this.name + " : " + this.description; 
    }

    //
    //Returns true iff both objects have the same name and 
    //description
    //
    public boolean equals(WObject o) {
        return (
            this.name.equals(o.getName()) && 
            this.description.equals(o.getDescription())
        );
    }


}