package com.pluralsight;

public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;

    // *** CONSTRUCTORS ***
    public Actor(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // *** GETTERS ***
    public int getActorId() {
        return actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
