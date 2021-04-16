package com.main;

public class Thing {
    protected String name;
    protected String description;

    // Constructor
    public Thing(String vName, String vDescription) {
        this.name = vName;
        this.description = vDescription;
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String vName) {
        this.name = vName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String vDescription) {
        this.description = vDescription;
    }

    // Methods
    public void describe() {
        System.out.println(name);
        System.out.println(description);
    }
}
