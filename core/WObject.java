package core;

//
// Basic Building Object
// 
// @author Alex Petersen <theoperatore@gmail.com>
//
public class WObject {

    //both fields used to check for equality
    private String name;
    private String matchName;
    private String description;

    //constructors
    public WObject() {
        this.name = "obj";
        this.matchName = "obj";
        this.description = "";
    }

    public WObject(String name) {
        this.name = name;
        this.matchName = name.toLowerCase().replace(' ', '_');
        this.description = "";
    }

    public WObject(String name, String desc) {
        this.name = name;
        this.matchName = name.toLowerCase().replace(' ', '_');
        this.description = desc;
    }

    //accessors
    public String getDisplayName() { return this.name; }
    public String getMatchName() { return this.matchName; }
    public String getDescription() { return this.description; }

    //mutators
    public void setName(String n)        { 
        this.name = n;
        this.matchName = n.toLowerCase().replace(' ', '_');
    }
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
            this.matchName.equals(o.getMatchName()) && 
            this.description.equals(o.getDescription())
        );
    }

    public boolean equals(String name) {
        return this.matchName.equals(name.toLowerCase().replace(' ','_'));
    }


}
