package us.costan.chrome;

import android.app.Application;

/**
 * Created by Hongsec on 2016-09-01.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ChromeView.initialize(this);
    }
}
