package com.moldedbits.ottoruntimesubscriptions.models.events;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Event2 extends OttoEvent {
    private String string;

    public Event2(String string) {this.string = string;}

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
