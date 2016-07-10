package com.moldedbits.ottoruntimesubscriptions.models;

import com.moldedbits.ottoruntimesubscriptions.models.events.Event1;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event2;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event3;
import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventDelegate;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventListener;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class MultiEventModel implements OttoEventListener {
    private List<OttoEventDelegate> mDelegates = new ArrayList<>();

    public MultiEventModel() {}

    public void runtimeSubscribe(OttoEventDelegate eventDelegate) {
        mDelegates.add(eventDelegate);
        eventDelegate.register();
    }

    public void unsubscribe() {
        for(OttoEventDelegate eventDelegate : mDelegates) {
            eventDelegate.unregister();
        }
    }

    @Override
    public void onEventReceived(OttoEvent event) {
        if (event instanceof Event3) {
            Timber.d("Receiving Event in MultiEventModel: %s", ((Event3) event).getString());
        } else if(event instanceof Event1) {
            Timber.d("Receiving Event in MultiEventModel: %s", ((Event1) event).getString());
        } else if(event instanceof Event2) {
            Timber.d("Receiving Event in MultiEventModel: %s", ((Event2) event).getString());
        }
    }
}
