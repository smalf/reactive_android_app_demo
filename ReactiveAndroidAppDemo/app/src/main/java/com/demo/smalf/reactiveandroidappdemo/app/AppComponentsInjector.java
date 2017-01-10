package com.demo.smalf.reactiveandroidappdemo.app;

import android.app.Application;
import android.content.pm.ApplicationInfo;


import com.demo.smalf.reactiveandroidappdemo.MainActivity;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingModule;
import com.demo.smalf.reactiveandroidappdemo.net.NetModule;

import java.io.File;

import javax.inject.Named;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * @author Serhiy Malofeev
 */
@DemoAppScope
@Component(modules = {AppModule.class, NetModule.class, LoggingModule.class})
public interface AppComponentsInjector extends ComponentsInjector {

    void inject(DemoApp app);

    void inject(MainActivity mainActivity);

    Application app();
    DemoApp demoApp();
    ApplicationInfo applicationInfo();

    @Named(AppComponents.APP_CACHE_DIR)
    File appCacheDir();

    @Named(AppComponents.API_KEY)
    String apiKey();

    OkHttpClient okHttpClient();

}