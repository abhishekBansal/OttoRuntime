package com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic;

import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;

/**
 *
 * Created by abhishek on 05/07/16.
 */

public interface OttoEventListener {
    void onEventReceived(OttoEvent event);
}
