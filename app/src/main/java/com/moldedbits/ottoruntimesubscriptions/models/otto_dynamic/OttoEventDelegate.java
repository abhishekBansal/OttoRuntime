package com.moldedbits.ottoruntimesubscriptions.models.otto_dynamic;

import com.moldedbits.ottoruntimesubscriptions.BaseApplication;

/**
 * A class which essentially just pass around an otto event
 * It acts as a receiver and passes event further to interested party
 * Created by abhishek on 05/07/16.
 */

public abstract class OttoEventDelegate {
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

    public OttoEventListener getOttoEventListener() {
        return ottoEventListener;
    }

    public void setOttoEventListener(OttoEventListener ottoEventListener) {
        this.ottoEventListener = ottoEventListener;
    }
}
