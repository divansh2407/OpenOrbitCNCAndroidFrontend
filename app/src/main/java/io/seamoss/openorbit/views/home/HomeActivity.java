package io.seamoss.openorbit.views.home;

import android.os.Bundle;

import javax.inject.Inject;

import io.seamoss.openorbit.OpenOrbit;
import io.seamoss.openorbit.R;
import io.seamoss.openorbit.base.nav.BaseNavActivity;

/**
 * Created by Alexander Melton on 2/11/2017.
 */

public class HomeActivity extends BaseNavActivity implements HomeView{

    @Inject HomePresenter homePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");

        OpenOrbit.instance().getAppGraph().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.homePresenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.homePresenter.detachView();
    }
}
