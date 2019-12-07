package io.seamoss.openorbit.base.mvp;

/**
 * Created by Alexander Melton on 2/12/2017.
 */


public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
