package io.seamoss.openorbit;

import android.app.Application;

import io.seamoss.openorbit.graph.AppGraph;
import io.seamoss.openorbit.graph.DaggerAppGraph;
import io.seamoss.openorbit.graph.modules.ActivityModule;
import io.seamoss.openorbit.graph.modules.AppModule;
import io.seamoss.openorbit.graph.modules.PresenterModule;
import timber.log.Timber;

/**
 * Created by Alexander Melton on 3/1/2017.
 */

public class OpenOrbit extends Application {

    private AppGraph appGraph;
    private static OpenOrbit instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appGraph = DaggerAppGraph
                .builder()
                .appModule(new AppModule(this))
                .presenterModule(new PresenterModule())
                .activityModule(new ActivityModule())
                .build();

        appGraph.inject(this);

        Timber.plant(new Timber.DebugTree());
    }

    public static OpenOrbit instance(){
        return instance;
    }

    public AppGraph getAppGraph(){ return appGraph;}
}
