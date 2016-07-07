package com.moldedbits.ottoruntimesubscriptions;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.knomatic.database.greendao.DaoMaster;
import com.knomatic.database.greendao.DaoSession;
import com.knomatic.onboarding.LoginActivity;
import com.knomatic.utils.LocalStorage;
import com.squareup.otto.Bus;

import lombok.Getter;
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

        initDb();

        bus = new Bus();
    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper
                = new DaoMaster.DevOpenHelper(this, "android.velocity.db", null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static BaseApplication getInstance() {
        return sInstance;
    }

    public void logout(AppCompatActivity currentActivity) {
        daoSession.getDBFormDao().deleteAll();
        daoSession.getDBWorkItemDao().deleteAll();
        LocalStorage.getInstance().clear();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        currentActivity.finish();
    }
}
