package io.seamoss.openorbit.base.nav;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import butterknife.BindView;
import io.seamoss.openorbit.R;
import io.seamoss.openorbit.base.BaseActivity;

/**
 * Created by Alexander Melton on 2/16/2017.
 */

public abstract class BaseNavActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawerLayout != null){
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar, R.string.nav_opened, R.string.nav_closed);

            drawerLayout.addDrawerListener(toggle);
            if(getSupportActionBar() != null) getSupportActionBar().setHomeButtonEnabled(true);

            toggle.syncState();
        }

        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_nav;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.nav_boards:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_auth:
                break;
        }

        return true;
    }
}

