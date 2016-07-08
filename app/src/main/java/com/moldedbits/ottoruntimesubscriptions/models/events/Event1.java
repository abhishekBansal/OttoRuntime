package com.moldedbits.ottoruntimesubscriptions.models.events;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Event1 extends OttoEvent{
    private String string;

    public Event1(String string) {this.string = string;}

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
