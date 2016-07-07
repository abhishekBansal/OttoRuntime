package com.moldedbits.ottoruntimesubscriptions;

import android.app.Application;

import com.squareup.otto.Bus;

import timber.log.Timber;

/**
 *
 * Created by abhishek on 05/04/16.
 */
public class BaseApplication extends Application {

    private static BaseApplication sInstance;

    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        bus = new Bus();
    }


    public static BaseApplication getInstance() {
        return sInstance;
    }

    public Bus getBus() {
        return bus;
    }
}
