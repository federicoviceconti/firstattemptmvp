package com.vetrya.firstattemptmvp.root;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

public interface BasePresenter {
    <T extends BaseView> void removeView(T base);
}
