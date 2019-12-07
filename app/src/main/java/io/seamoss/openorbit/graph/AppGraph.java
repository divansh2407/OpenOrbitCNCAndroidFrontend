package io.seamoss.openorbit.graph;

import dagger.Component;
import io.seamoss.openorbit.OpenOrbit;
import io.seamoss.openorbit.base.BaseActivity;
import io.seamoss.openorbit.base.nav.NavHeadView;
import io.seamoss.openorbit.graph.modules.ActivityModule;
import io.seamoss.openorbit.graph.modules.AppModule;
import io.seamoss.openorbit.graph.modules.NetworkModule;
import io.seamoss.openorbit.graph.modules.PresenterModule;
import io.seamoss.openorbit.views.home.HomeActivity;

/**
 * Created by Alexander Melton on 2/11/2017.
 */

@AppScope
@Component(modules = {AppModule.class, PresenterModule.class, ActivityModule.class, NetworkModule.class})
public interface AppGraph {

    void inject(OpenOrbit application);

    void inject(BaseActivity baseActivity);

    void inject(NavHeadView navHeadView);

    void inject(HomeActivity homeActivity);

}
