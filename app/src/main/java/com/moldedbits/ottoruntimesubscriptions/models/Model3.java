package com.moldedbits.ottoruntimesubscriptions.models;

import com.moldedbits.ottoruntimesubscriptions.models.events.Event3;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event3Delegate;
import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventDelegate;
import com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic.OttoEventListener;

import timber.log.Timber;

/**
 *
 * Created by abhishek on 07/07/16.
 */

public class Model3 extends Model {
    private OttoEventDelegate mDelegate;

    public Model3() {
        super(ModelType.MODEL_3);
    }

    @Override
    public void runtimeSubscribe() {
        mDelegate = new Event3Delegate(new OttoEventListener() {
            @Override
            public void onEventReceived(OttoEvent event) {
                if(event instanceof Event3) {
                    Timber.d("Receiving Event in Model3: %s", ((Event3) event).getString());
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
