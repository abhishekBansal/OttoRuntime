package com.moldedbits.ottoruntimesubscriptions.models.events;

import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventDelegate;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventListener;
import com.squareup.otto.Subscribe;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Event2Delegate extends OttoEventDelegate {

    public Event2Delegate(OttoEventListener ottoEventListener) {
        super(ottoEventListener);
    }

    @Subscribe
    public void onOttoEvent(Event2 event) {
        getOttoEventListener().onEventReceived(event);
    }
}
