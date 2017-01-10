package com.demo.smalf.reactiveandroidappdemo.app;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Provides application level components,  including shared configuration values etc.
 *
 * @author Serhiy Malofeev
 */
@Module
public class AppModule {
    private final DemoApp app;

    private final File appCacheDir;
    private final int httpCacheSize;

    private final String apiDomain;
    private final String apiKey;

    private AppModule(Builder builder) {
        this.app = builder.app;

        this.appCacheDir = builder.appCacheDir;
        this.httpCacheSize = builder.httpCacheSize;

        this.apiDomain = builder.apiDomain;
        this.apiKey = builder.apiKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private DemoApp app;

        private File appCacheDir;
        private int httpCacheSize;

        private String apiDomain;
        private String apiKey;

        private Builder() {
        }

        Builder app(DemoApp app) {
            this.app = app;
            return this;
        }

        Builder appCacheDir(File appCacheDir) {
            this.appCacheDir = appCacheDir;
            return this;
        }

        Builder httpCacheSize(int httpCacheSize) {
            this.httpCacheSize = httpCacheSize;
            return this;
        }

        Builder apiDomain(String apiDomain) {
            this.apiDomain = apiDomain;
            return this;
        }

        Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        AppModule build() {
            return new AppModule(this);
        }
    }

    @Provides
    @DemoAppScope
    public Application provideApp() {
        return app;
    }

    @Provides
    @DemoAppScope
    public DemoApp provideDemoApp() {
        return app;
    }

    @Provides
    @DemoAppScope
    public ApplicationInfo provideApplicationInfo() {
        return app.getApplicationInfo();
    }

    @Provides
    @DemoAppScope
    @Named(AppComponents.APP_CACHE_DIR)
    public File provideAppCacheDir() {
        return appCacheDir;
    }

    @Provides
    @DemoAppScope
    @Named(AppComponents.APP_HTTP_CACHE_SIZE_MB)
    public int provideHttpCacheSize() {
        return httpCacheSize;
    }

    @Provides
    @DemoAppScope
    @Named(AppComponents.API_DOMAIN)
    public String provideApiDomain() {
        return apiDomain;
    }

    @Provides
    @DemoAppScope
    @Named(AppComponents.API_KEY)
    public String provideApiKey() {
        return apiKey;
    }

}
