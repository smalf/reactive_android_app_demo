package com.demo.smalf.reactiveandroidappdemo.app;

import android.app.Application;
import android.content.pm.ApplicationInfo;


import com.demo.smalf.reactiveandroidappdemo.MainActivity;
import com.demo.smalf.reactiveandroidappdemo.logging.Logger;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingComponents;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingModule;
import com.demo.smalf.reactiveandroidappdemo.net.NetModule;
import com.demo.smalf.reactiveandroidappdemo.net.services.PostService;
import com.demo.smalf.reactiveandroidappdemo.net.services.PostsService;
import com.google.gson.Gson;

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

    @Named(LoggingComponents.APP_LOGGER)
    Logger appLoger();

    Application app();
    DemoApp demoApp();
    ApplicationInfo applicationInfo();

    @Named(AppComponents.APP_CACHE_DIR)
    File appCacheDir();

    @Named(AppComponents.API_KEY)
    String apiKey();
    @Named(AppComponents.API_DOMAIN)
    String apiDomain();

    OkHttpClient okHttpClient();
    Gson gson();

    /*
     *   Providing services for loading posts. Requests will be created in concrete injectors using this services.
     */
    PostService postService();
    PostsService postsService();


}