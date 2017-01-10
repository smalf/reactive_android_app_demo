package com.demo.smalf.reactiveandroidappdemo.net;

import com.demo.smalf.reactiveandroidappdemo.app.AppComponents;
import com.demo.smalf.reactiveandroidappdemo.app.DemoAppScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Provides networking components.
 *
 * @author Serhyi Malofeev
 */
@Module
public class NetModule {

    @Provides
    @DemoAppScope
    public OkHttpClient provideOkHttpClient(
            final Cache cache,
            final HttpLoggingInterceptor httpLoggingInterceptor
    ) {
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).cache(cache).build();
    }

    @Provides
    @DemoAppScope
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(
            final HttpLoggingInterceptor.Level loggingLevel
    ) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(loggingLevel);
        return interceptor;
    }

    @Provides
    @DemoAppScope
    public Cache provideOkHttpCache(
            @Named(AppComponents.APP_CACHE_DIR) final File cacheDir,
            @Named(AppComponents.APP_HTTP_CACHE_SIZE_MB) final int httpCacheSizeMb
    ) {
        return new Cache(cacheDir, httpCacheSizeMb * 1024 * 1024);
    }

    @Provides
    @DemoAppScope
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

}
