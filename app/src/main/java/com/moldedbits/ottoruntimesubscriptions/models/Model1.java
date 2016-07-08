package com.moldedbits.ottoruntimesubscriptions.models;

import com.moldedbits.ottoruntimesubscriptions.models.events.Event1;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event1Delegate;
import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventDelegate;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventListener;

import timber.log.Timber;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Model1 extends Model {
    private OttoEventDelegate mDelegate;

    public Model1() {
        super(ModelType.MODEL_1);
    }

    @Override
    public void runtimeSubscribe() {
        mDelegate = new Event1Delegate(new OttoEventListener() {
            @Override
            public void onEventReceived(OttoEvent event) {
                if(event instanceof Event1) {
                    Timber.d("Receiving Event in Model1: %s", ((Event1) event).getString());
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
