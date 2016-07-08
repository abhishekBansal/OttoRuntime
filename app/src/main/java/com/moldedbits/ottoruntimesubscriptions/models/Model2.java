package com.moldedbits.ottoruntimesubscriptions.models;

import com.moldedbits.ottoruntimesubscriptions.models.events.Event2;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event2Delegate;
import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventListener;

import timber.log.Timber;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Model2 extends Model {
    private Event2Delegate mDelegate;

    public Model2() {
        super(ModelType.MODEL_2);
    }

    @Override
    public void runtimeSubscribe() {
        mDelegate = new Event2Delegate(new OttoEventListener() {
            @Override
            public void onEventReceived(OttoEvent event) {
                if(event instanceof Event2) {
                    Timber.d("Receiving event in Model2: %s", ((Event2) event).getString());
                }
            }
        });

        mDelegate.register();
    }

    @Override
    public void unsubscribe() {
        mDelegate.unregister();
    }
}
