package com.demo.smalf.reactiveandroidappdemo.app;

import android.app.Application;

import com.demo.smalf.reactiveandroidappdemo.logging.Logger;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingComponents;
import com.demo.smalf.reactiveandroidappdemo.logging.LoggingModule;
import com.demo.smalf.reactiveandroidappdemo.net.NetModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Demo application implementation, responsible for management of global shared components.
 *
 * @author Serhiy Malofeev
 */
public class DemoApp extends Application {
    private static final int HTTP_CACHE_SIZE_MB = 10;

    private static final String API_DOMAIN = "http://jsonplaceholder.typicode.com/";
    private static final String API_KEY = "";

    @Inject
    @Named(LoggingComponents.APP_LOGGER)
    protected Logger logger;

    @Override
    public void onCreate() {
        super.onCreate();

        final AppComponentsInjector appComponentsInjector = DaggerAppComponentsInjector
                .builder()
                .loggingModule(new LoggingModule())
                .netModule(new NetModule())
                .appModule(
                        AppModule.builder()
                            .app(this)
                            .appCacheDir(getCacheDir())
                            .appIdentifier(getClass().getSimpleName())
                            .httpCacheSize(HTTP_CACHE_SIZE_MB)
                            .apiDomain(API_DOMAIN)
                            .build()
                )
                .build();

        ComponentsInjectors.add(appComponentsInjector, AppComponentsInjector.class);
        appComponentsInjector.inject(this);

    }
}
