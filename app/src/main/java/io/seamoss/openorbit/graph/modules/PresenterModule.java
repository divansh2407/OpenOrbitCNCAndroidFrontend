package io.seamoss.openorbit.graph.modules;

import dagger.Module;
import dagger.Provides;
import io.seamoss.openorbit.views.home.HomePresenter;

/**
 * Created by Alexander Melton on 2/16/2017.
 */

@Module
public class PresenterModule {

    @Provides
    HomePresenter providesHomePresenter(){
        return new HomePresenter();
    }
}
