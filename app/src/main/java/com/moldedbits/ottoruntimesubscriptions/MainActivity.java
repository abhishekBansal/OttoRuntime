package com.moldedbits.ottoruntimesubscriptions;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.moldedbits.ottoruntimesubscriptions.models.Model;
import com.moldedbits.ottoruntimesubscriptions.models.MultiEventModel;
import com.moldedbits.ottoruntimesubscriptions.models.Model1;
import com.moldedbits.ottoruntimesubscriptions.models.Model2;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event1;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event1Delegate;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event2;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event2Delegate;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event3;
import com.moldedbits.ottoruntimesubscriptions.models.events.Event3Delegate;

public class MainActivity extends AppCompatActivity {

    private Model mModel1;
    private Model mModel2;
    private MultiEventModel mMultiEventModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mModel1 = new Model1();
        mModel2 = new Model2();
        mMultiEventModel = new MultiEventModel();

        setupView();
    }

    @Override
    protected void onResume() {
        if(mModel1.getModelType() == Model.ModelType.MODEL_1) {
            mModel1.runtimeSubscribe();
        }

        if(mModel2.getModelType() == Model.ModelType.MODEL_2) {
            mModel2.runtimeSubscribe();
        }

        mMultiEventModel.runtimeSubscribe(new Event1Delegate(mMultiEventModel));
        mMultiEventModel.runtimeSubscribe(new Event2Delegate(mMultiEventModel));
        mMultiEventModel.runtimeSubscribe(new Event3Delegate(mMultiEventModel));
        super.onResume();
    }

    @Override
    protected void onPause() {
        mModel1.unsubscribe();
        mModel2.unsubscribe();
        mMultiEventModel.unsubscribe();
        super.onPause();
    }

    private void setupView() {
        Button bt1 = (Button) findViewById(R.id.btn_event1);
        Button bt2 = (Button) findViewById(R.id.btn_event2);
        Button bt3 = (Button) findViewById(R.id.btn_event3);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseApplication.getInstance().getBus().post(new Event1("Event1"));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseApplication.getInstance().getBus().post(new Event2("Event2"));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseApplication.getInstance().getBus().post(new Event3("Event3"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
