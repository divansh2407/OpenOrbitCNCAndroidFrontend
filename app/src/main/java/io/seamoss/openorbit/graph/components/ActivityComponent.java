package io.seamoss.openorbit.graph.components;

import dagger.Component;
import io.seamoss.openorbit.graph.ActivityScope;
import io.seamoss.openorbit.graph.AppGraph;
import io.seamoss.openorbit.graph.modules.ActivityModule;

/**
 * Created by Alexander Melton on 2/13/2017.
 */

@ActivityScope
@Component(dependencies = AppGraph.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
