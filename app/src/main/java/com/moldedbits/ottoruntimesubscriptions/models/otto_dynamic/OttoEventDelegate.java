package com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic;

import com.knomatic.BaseApplication;
import com.moldedbits.ottoruntimesubscriptions.models.events.OttoEvent;
import com.squareup.otto.Subscribe;

import lombok.Getter;
import lombok.Setter;

/**
 * A class which essentially just pass around an otto event
 * It acts as a receiver and passes event further
 * Created by abhishek on 05/07/16.
 */

public class OttoEventDelegate {
    @Getter @Setter
    private OttoEventListener ottoEventListener;

    public OttoEventDelegate(OttoEventListener ottoEventListener) {
        this.ottoEventListener = ottoEventListener;
    }

    public void register() {
        BaseApplication.getInstance().getBus().register(this);
    }

    public void unregister() {
        BaseApplication.getInstance().getBus().unregister(this);
    }

    @Subscribe
    public void onOttoEvent(OttoEvent event) {
        getOttoEventListener().onEventReceived(event);
    }
}
