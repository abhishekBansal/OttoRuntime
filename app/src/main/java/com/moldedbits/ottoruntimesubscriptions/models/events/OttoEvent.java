package com.moldedbits.ottoruntimesubscriptions.models.events;

/**
 *
 * Created by abhishek on 06/07/16.
 */

public abstract class OttoEvent {
    public enum LeaderEventType {
        BAR_CODE_EVENT
    }

    private LeaderEventType leaderEventType;
}
